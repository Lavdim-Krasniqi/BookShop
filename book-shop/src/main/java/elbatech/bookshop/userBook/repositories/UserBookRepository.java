package elbatech.bookshop.userBooks.repositories;


import com.mongodb.client.result.UpdateResult;
import elbatech.bookshop.userBooks.entities.UserBook;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
@Data
public class UserBookRepository {
    MongoTemplate repo;

    public UserBook addUserBook(UserBook book) {
        return repo.insert(book);
    }

    public Page<UserBook> getAllUserBooks(String username, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Query query = new Query();
        query.addCriteria(Criteria.where(UserBook.USERNAME).is(username));
        query.with(pageable);

        return PageableExecutionUtils.getPage(repo.find(query, UserBook.class),
                pageable, () -> repo.count(query.skip(0).limit(0), UserBook.class));
    }

    public UpdateResult updateBookPage(Integer pageNumber, String bookId, String username) {
        val c1 = Criteria.where(UserBook.BOOK_ID).is(bookId);
        val c2 = Criteria.where(UserBook.USERNAME).is(username);
        Update update = new Update();
        update.set(UserBook.PAGE_NUMBER, pageNumber);

        return repo.updateFirst(Query.query(new Criteria().andOperator(c1, c2)), update, UserBook.class);
    }
}
