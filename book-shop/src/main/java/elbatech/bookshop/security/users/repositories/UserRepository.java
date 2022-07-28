package elbatech.bookshop.security.users.repositories;

import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.security.users.entities.User;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UserRepository {

    private MongoTemplate repo;


    public User addUser(User user) {
        return repo.insert(user);
    }

    public User findByUsername(String username) {
        val c1 = Criteria.where(User.USERNAME).is(username);
        return repo.findOne(Query.query(c1), User.class);
    }

    public DeleteResult deleteUserByUsername(String username) {
        val c1 = Criteria.where(User.USERNAME).is(username);
        return repo.remove(Query.query(c1), User.class);
    }

    public boolean doesExists(String username) {
        val c1 = Criteria.where(User.USERNAME).is(username);
        return repo.exists(Query.query(c1), User.class);
    }

}
