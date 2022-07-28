package elbatech.bookshop.Book.Repository;

import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.Author.Entity.Author;
import elbatech.bookshop.Book.Entity.Book;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public class BookRepository {

    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    Author author;

    public Book addBook(Book book) {
        return mongoTemplate.save(book);
    }

    public DeleteResult deleteBook(String id) {
        Query query = new Query(Criteria.where(Book.ID).is(id));
        return mongoTemplate.remove(query, Book.class);
    }

    public List<Book> listAllBooks() {
        return mongoTemplate.findAll(Book.class, "book");
    }

    public boolean idExists(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where(Book.ID).is(id));
        return mongoTemplate.exists(query, Book.class);
    }

    public Book updateBook(Book book) {
        return mongoTemplate.save(book, "book");
    }


}
