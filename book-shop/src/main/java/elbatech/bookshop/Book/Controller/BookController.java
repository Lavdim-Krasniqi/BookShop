package elbatech.bookshop.Book.Controller;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.Author.Entity.Author;
import elbatech.bookshop.Book.Entity.Book;
import elbatech.bookshop.Book.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;




    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @DeleteMapping("/deleteBook/{id}")
    public DeleteResult deleteBook(@PathVariable(value = "id") String id) {

        if (!bookService.idExists(id)) {
            throw new RuntimeException("BAD REQUEST");
        }
        return bookService.deleteBook(id);
    }

    @GetMapping("listAllBooks")
    public List<Book> listAllBooks() {
        return bookService.listAllBooks();
    }

    @PutMapping("/updateBook/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable (value = "id") String id) {
        return bookService.updateBook(book);
    }



}
