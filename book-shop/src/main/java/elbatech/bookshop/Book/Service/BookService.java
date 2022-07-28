package elbatech.bookshop.Book.Service;

import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.Author.Entity.Author;
import elbatech.bookshop.Book.Entity.Book;
import elbatech.bookshop.Book.Repository.BookRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class BookService {

    @Autowired
    private BookRepository repository;


    public Book addBook(Book book) {
        return repository.addBook(book);
    }

    public DeleteResult deleteBook(String id) {
        return repository.deleteBook(id);

    }

    public List<Book> listAllBooks() {
        return repository.listAllBooks();
    }

    public boolean idExists (String id){
        return repository.idExists(id);
    }


    public Book updateBook(Book book) {
        return repository.updateBook(book);
    }

}
