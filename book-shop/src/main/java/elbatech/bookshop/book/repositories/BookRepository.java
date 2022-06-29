package elbatech.bookshop.book.repositories;

import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.book.entities.Book;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class BookRepository {

    private final MongoTemplate repo;

    // This method adds a new author document into Book collection
    public Book addAuthor(Book book) {
        return repo.insert(book);
    }

    // This methods delete book document by id from Book collection
    public DeleteResult removeBook(String bookId) {
        val c1 = Criteria.where(Book.ID).is(bookId);
        return repo.remove(Query.query(c1), Book.class);
    }


}
