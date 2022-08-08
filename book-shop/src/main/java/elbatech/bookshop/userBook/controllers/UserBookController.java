package elbatech.bookshop.userBook.controllers;

import com.mongodb.client.result.UpdateResult;
import elbatech.bookshop.userBook.entities.UserBook;
import elbatech.bookshop.userBook.entities.UserBookDto;
import elbatech.bookshop.userBook.services.UserBookService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/userBook")
public class UserBookController {

    UserBookService service;

    @PostMapping("/addBook")
    public UserBook addUserBook(@RequestBody UserBookDto book) {
        return service.addUserBook(book);
    }

    @GetMapping("/getAllUserBooks/{page}/{size}")
    public Page<UserBook> getAllUserBooks(@PathVariable Integer page, @PathVariable Integer size) {
        return service.getAllUserBooks(page, size);
    }

    @PutMapping("/nextPage/{pageNumber}/{bookId}")
    public UpdateResult updatePage(@PathVariable Integer pageNumber, @PathVariable String bookId) {
        return service.updateBookPage(pageNumber, bookId);
    }
}
