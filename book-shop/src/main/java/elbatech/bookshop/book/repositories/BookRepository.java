package elbatech.bookshop.book.repositories;

import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.book.entities.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
@Data
public class BookRepository {

    MongoTemplate repo;

    public Book addBook(Book book) {
        return repo.insert(book);
    }

    public Book findById(String bookId) {
        val c1 = Criteria.where(Book.ID).is(bookId);
        return repo.findOne(Query.query(c1), Book.class);
    }

    public DeleteResult deleteBookById(String bookId) {
        val c1 = Criteria.where(Book.ID).is(bookId);
        return repo.remove(Query.query(c1), Book.class);
    }

    public Page<Book> getAllBooks(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Query query = new Query();
        query.with(pageable);

        return PageableExecutionUtils.getPage(
                repo.find(query, Book.class),
                pageable,
                () -> repo.count(query.skip(0).limit(0), Book.class)
        );
    }

    public boolean doesExists(String bookId) {
        val c1 = Criteria.where(Book.ID).is(bookId);
        return repo.exists(Query.query(c1), Book.class);
    }
}
