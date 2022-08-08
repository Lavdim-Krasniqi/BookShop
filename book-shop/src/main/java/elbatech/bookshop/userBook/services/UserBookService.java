package elbatech.bookshop.userBook.services;

import com.mongodb.client.result.UpdateResult;
import elbatech.bookshop.book.services.BookService;
import elbatech.bookshop.page.Service.PageService;
import elbatech.bookshop.userBook.entities.UserBook;
import elbatech.bookshop.userBook.entities.UserBookDto;
import elbatech.bookshop.userBook.repositories.UserBookRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Data
public class UserBookService {

    private UserBookRepository repo;
    private BookService bookService;

    private PageService pageService;

    public UserBook addUserBook(UserBookDto book) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (bookService.doesExists(book.getBookId())) {
            UserBook userBook = UserBook.builder()
                    .bookId(book.getBookId())
                    .username(authentication.getName())
                    .pageNumber(book.getPageNumber()).build();

            return repo.addUserBook(userBook);
        }
        throw new RuntimeException("Not found any book with given bookId");
    }

    public Page<UserBook> getAllUserBooks(Integer page, Integer size) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return repo.getAllUserBooks(authentication.getName(), page, size);
    }

    public UpdateResult updateBookPage(Integer pageNumber, String bookId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (pageService.doesExists(pageNumber, bookId)) {
            return repo.updateBookPage(pageNumber, bookId, authentication.getName());

        }
        throw new RuntimeException("Book or page does not exists in our database.");
    }

}
