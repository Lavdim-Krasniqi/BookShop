package elbatech.bookshop.author.services;

import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.author.entities.Author;
import elbatech.bookshop.author.repositories.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AuthorService {

    AuthorRepository repo;

    public Author addAuthor(Author author) {
        return repo.addAuthor(author);
    }

    // This methods delete author document by id from Book collection
    public DeleteResult removeAuthor(String authorId) {
        return repo.removeAuthor(authorId);
    }

    //this method checks if all given ids exists on Author collection
    public boolean doesAllIdsMatch(List<String> ids) {
        return repo.doesAllIdsMatch(ids);
    }
}
