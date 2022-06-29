package elbatech.bookshop.author.repositories;

import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.author.entities.Author;
import elbatech.bookshop.author.entities.CountDto;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.count;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;

@AllArgsConstructor
@Repository
public class AuthorRepository {

    private final MongoTemplate repo;

    // This method adds a new author document into Book collection
    public Author addAuthor(Author author) {
        return repo.insert(author);
    }

    // This methods delete author document by id from Book collection
    public DeleteResult removeAuthor(String authorId) {
        val c1 = Criteria.where(Author.ID).is(authorId);
        return repo.remove(Query.query(c1), Author.class);
    }

    //this method checks if all given ids exists on Author collection
    public boolean doesAllIdsMatch(List<String> ids) {
        Aggregation aggregation = Aggregation.newAggregation(
                match(Criteria.where(Author.ID).in(ids)),
                count().as("count")
        );

        try {
            val count =
                    repo.aggregate(aggregation, Author.class, CountDto.class)
                            .getMappedResults().get(0);
            return ids.size() == count.getCount();
        }
        catch (IndexOutOfBoundsException ex){
            return false;
        }

    }

}
