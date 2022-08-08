package elbatech.bookshop.Publisher.Repository;

import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.Publisher.Entity.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PublisherRepository {

    @Autowired
    MongoTemplate repo;

    public Publisher addPublisher(Publisher publisher) {
        return repo.save(publisher,"publisher");
    }

    public Publisher editPublisher(Publisher publisher) {
        return repo.save(publisher,"publisher");
    }

    public DeleteResult deletePublisher(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where(Publisher.ID).is(id));
        return repo.remove(query, Publisher.class);
    }

    public Publisher getPublisherById(String id) {
        return repo.findById(id,Publisher.class);
    }

    public List<Publisher> getAllPublishers() {
        return repo.findAll(Publisher.class,"publisher");
    }
}
