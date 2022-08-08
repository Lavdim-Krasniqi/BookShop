package elbatech.bookshop.Author.Repository;

import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.Author.Entity.Author;
import lombok.Data;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository

public class AuthorRepository{

    @Autowired
    MongoTemplate repo;
    @Autowired
    Author author;

    public Author addAuthor(Author author) {
        return repo.save(author);
    }

    public DeleteResult deleteAuthor(String id) {
        Query query = new Query(Criteria.where(Author.ID).is(id));
        return repo.remove(query, Author.class);
    }

    public Author editAuthor(Author author) {
        return repo.save(author, "author");
    }

    public Author getAuthorById(String id) {
        return repo.findById(id, Author.class);
    }

    public List<Author> getAllAuthors() {
        return repo.findAll(Author.class);
    }

    public Author findAuthorByNameOrSurname(String nameOrSurname) {
        val criteria1 = Criteria.where(Author.NAME).is(nameOrSurname);
        val criteria2 = Criteria.where(Author.SURNAME).is(nameOrSurname);

        MatchOperation match = Aggregation.match(Criteria.where(Author.SURNAME).is(nameOrSurname));
        System.out.println(match.toString());

        Query query = new Query(new Criteria().orOperator(criteria1,criteria2));
        return repo.findOne(query,Author.class);
    }


    public List<Author> getByCountry(String country) {
        Query query = new Query();
        query.addCriteria(Criteria.where(Author.COUNTRY).is(country));
        return repo.find(query,Author.class);
    }


}
