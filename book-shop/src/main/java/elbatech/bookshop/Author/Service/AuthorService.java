package elbatech.bookshop.Author.Service;

import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.Author.Entity.Author;
import elbatech.bookshop.Author.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    Author author;

    
    public Author addAuthor(Author author) {
        return authorRepository.addAuthor(author);
    }

    public DeleteResult deleteAuthor(String id) {
        return authorRepository.deleteAuthor(id);
    }

    public Author editAuthor(Author author) {
        return authorRepository.editAuthor(author);
    }

    public Author getAuthorById(String id) {
        return authorRepository.getAuthorById(id);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.getAllAuthors();
    }


    public Author findAuthorByNameOrSurname(String name) {
        return authorRepository.findAuthorByNameOrSurname(name);
    }

    public List<Author> getByCountry(String country) {
        return authorRepository.getByCountry(country);
    }


}
