package elbatech.bookshop.book.controllers;

import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.book.entities.Book;
import elbatech.bookshop.book.entities.RequestDto;
import elbatech.bookshop.book.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/book")
public class BookController {

    BookService service;

    @PostMapping("/addBook")
    public Book addBook(@RequestBody RequestDto dto){
        return service.addBook(dto);
    }

    @DeleteMapping("/deleteBook/{bookId}")
    public DeleteResult deleteBook(@PathVariable String bookId){
        return service.removeBook(bookId);
    }
}
