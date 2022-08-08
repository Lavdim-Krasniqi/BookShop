package elbatech.bookshop.book.controllers;

import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.book.entities.Book;
import elbatech.bookshop.book.entities.BookRequestDto;
import elbatech.bookshop.book.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/book")
public class BookController {
    BookService service;

    @PreAuthorize("@methodAuthorization.hasRole('ROLE_ADMIN')")
    @PostMapping("/addBook")
    public Book addBook(@RequestBody BookRequestDto requestDto) {
        return service.addBook(requestDto);
    }


    @PreAuthorize("@methodAuthorization.hasAuthority('read')")
    @GetMapping("/getAllBooks/{page}/{size}")
    public Page<Book> getAllBooks(@PathVariable Integer page, @PathVariable Integer size) {
        return service.getAllBooks(page, size);
    }

    @PreAuthorize("@methodAuthorization.hasAuthority('read')")
    @GetMapping("/getById/{bookId}")
    public Book findById(@PathVariable String bookId) {

        return service.findById(bookId);
    }

    @PreAuthorize("@methodAuthorization.hasRole('ROLE_ADMIN')")
    @DeleteMapping("/deleteById/{bookId}")
    public DeleteResult deleteBookById(@PathVariable String bookId) {
        return service.deleteBookById(bookId);
    }

}
