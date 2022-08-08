package elbatech.bookshop.author.Service;

import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.author.Entity.Author;
import elbatech.bookshop.author.Repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorService {

    AuthorRepository authorRepository;

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

    public boolean checkIfAllGivenAuthorsAreRegistered(List<String> authorsIds) {
        return authorRepository.checkIfAllGivenAuthorsAreRegistered(authorsIds);
    }
    public List<Author> getAuthorsByIds(List<String> ids) {
        return authorRepository.getAuthorsByIds(ids);
    }


}
