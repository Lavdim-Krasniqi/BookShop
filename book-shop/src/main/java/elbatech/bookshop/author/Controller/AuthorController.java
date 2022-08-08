package elbatech.bookshop.Author.Controller;

import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.Author.Entity.Author;
import elbatech.bookshop.Author.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;


    @PostMapping("/addAuthor")
    public Author addAuthor(@RequestBody Author author) {
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


}
