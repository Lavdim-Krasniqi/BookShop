package elbatech.bookshop.book.services;

import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.author.services.AuthorService;
import elbatech.bookshop.book.entities.Book;
import elbatech.bookshop.book.entities.RequestDto;
import elbatech.bookshop.book.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BookService {

    BookRepository repo;
    AuthorService authorService;

    public Book addBook(RequestDto dto) {
        if (authorService.doesAllIdsMatch(dto.getAuthorsIds()))
            return repo.addAuthor(new Book(dto.getTitle(), dto.getAuthorsIds()));
        else throw new RuntimeException("Given Ids of authors doesn't exists on our database");
    }

    public DeleteResult removeBook(String bookId) {
        return repo.removeBook(bookId);
    }

}
