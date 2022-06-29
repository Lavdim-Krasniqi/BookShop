package elbatech.bookshop.author.controllers;

import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.author.entities.Author;
import elbatech.bookshop.author.services.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/author")
public class AuthorController {

    AuthorService service;
    @PostMapping("/addAuthor")
    public Author addAuthor(@RequestBody Author author) {
        return service.addAuthor(author);
    }

    // This methods delete author document by id from Book collection
    @DeleteMapping("/deleteAuthor/{authorId}")
    public DeleteResult removeAuthor(@PathVariable String authorId) {
        return service.removeAuthor(authorId);
    }

    //this method checks if all given ids exists on Author collection
    @PostMapping("/checkForGivenAuthors")
    public boolean doesAllIdsMatch(@RequestBody List<String> ids) {
        return service.doesAllIdsMatch(ids);
    }

}
