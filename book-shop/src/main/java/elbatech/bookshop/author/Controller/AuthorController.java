package elbatech.bookshop.author.Controller;

import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.author.Entity.Author;
import elbatech.bookshop.author.Service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/author")
@AllArgsConstructor
public class AuthorController {
    AuthorService authorService;

    @PostMapping("/addAuthor")
    public Author addAuthor(@Valid @RequestBody Author author) {
        return authorService.addAuthor(author);
    }

    @DeleteMapping("/deleteAuthor/{id}")
    public DeleteResult deleteAuthor(@PathVariable(value = "id") String id) {
        return authorService.deleteAuthor(id);
    }

    @PutMapping("/editAuthor/{id}")
    public Author editAuthor(@RequestBody Author author, @PathVariable(value = "id") String id) {
        return authorService.editAuthor(author);
    }

    @GetMapping("/getAuthorById/{id}")
    public Author getAuthorById(@PathVariable(value = "id") String id) {
        return authorService.getAuthorById(id);
    }

    @GetMapping("/getAllAuthors")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/findAuthorByNameOrSurname/{nameOrSurname}")
    public Author findAuthorByNameOrSurname(@PathVariable(value = "nameOrSurname") String nameOrSurname) {
        return authorService.findAuthorByNameOrSurname(nameOrSurname);
    }


    @GetMapping("/getByCountry/{country}")
    public List<Author> getByCountry(@PathVariable String country) {
        return authorService.getByCountry(country);
    }

    @GetMapping("/getAuthorsByIds")
    public List<Author> getAuthorsByIds(@RequestBody List<String> ids) {
        return authorService.getAuthorsByIds(ids);
    }


}
