package elbatech.bookshop.book.services;

import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.author.Service.AuthorService;
import elbatech.bookshop.book.entities.Book;
import elbatech.bookshop.book.entities.BookRequestDto;
import elbatech.bookshop.book.repositories.BookRepository;
import elbatech.bookshop.notification.entities.Notification;
import elbatech.bookshop.notification.services.NotificationService;
import elbatech.bookshop.publisher.Service.ServicePublisher;
import elbatech.bookshop.user.services.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class BookService {

    BookRepository repo;
    ServicePublisher publisherService;
    AuthorService authorService;
    UserService userService;
    NotificationService notificationService;

    public Book addBook(BookRequestDto bookRequestDto) {

        if (bookRequestDto.getListOfPublishers() == null || bookRequestDto.getListOfAuthors() == null
                || bookRequestDto.getListOfPublishers().isEmpty() || bookRequestDto.getListOfAuthors().isEmpty())
            throw new RuntimeException("Lists of publishers and authors shouldn't be null or empty");

        Book book = Book.builder()
                .tittle(bookRequestDto.getTittle())
                .isbn(bookRequestDto.getIsbn())
                .genre(bookRequestDto.getGenre())
                .publishDate(bookRequestDto.getPublishDate())
                .pageNumber(bookRequestDto.getPageNumber())
                .price(bookRequestDto.getPrice())
                .listOfPublishers(bookRequestDto.getListOfPublishers())
                .rate(bookRequestDto.getRate())
                .editionNumber(bookRequestDto.getEditionNumber())
                .listOfAuthors(bookRequestDto.getListOfAuthors())
                .build();

        if (publisherService.checkIfAllGivenPublishersAreRegistered(bookRequestDto.getListOfPublishers())) {
            if (authorService.checkIfAllGivenAuthorsAreRegistered(bookRequestDto.getListOfAuthors())) {
                Book book1 = repo.addBook(book);
                sendNotification(userService.getUsersEmailsWithNotificationEnabled(),
                        book.getTittle(), book.getListOfAuthors(), book.getGenre(), "Book-Shop");
                return book1;
            } else throw new RuntimeException("Author id does not exists on database. Please add it.");

        } else {
            throw new RuntimeException("Publisher id does not exists on database. Please add it.");
        }
    }

    public Book findById(String bookId) {
        return repo.findById(bookId);
    }

    public DeleteResult deleteBookById(String bookId) {
        return repo.deleteBookById(bookId);
    }

    public Page<Book> getAllBooks(Integer page, Integer size) {
        return repo.getAllBooks(page, size);
    }

    public boolean doesExists(String bookId) {
        return repo.doesExists(bookId);
    }


    private void sendNotification(List<String> recipientsEmails, String bookName, List<String> authorsIds, String genre, String subject) {
        
        List<String> authors = authorService.getAuthorsByIds(authorsIds)
                .stream().map(author -> author.getName() + " " + author.getSurname()).toList();

        String message = "Hello, we are delighted to inform you that recently we have added new book on BookShop. \n" +
                "This book is called " + bookName + ", wrote by " + authors.toString() + " and the genre of book is " + genre;

        Notification notification = Notification.builder()
                .recipients(recipientsEmails)
                .message(message)
                .subject(subject)
                .build();

        notificationService.sendNotification(notification);
    }

}
