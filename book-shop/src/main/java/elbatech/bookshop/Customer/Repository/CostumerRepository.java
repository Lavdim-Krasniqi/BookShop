package elbatech.bookshop.Customer.Repository;

import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.Book.Entity.Book;
import elbatech.bookshop.Book.Repository.BookRepository;
import elbatech.bookshop.Customer.Entity.Costumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CostumerRepository {

    @Autowired
    MongoTemplate repo;


    public Costumer addCostumer(Costumer costumer) {
        return repo.save(costumer);
    }

    public DeleteResult deleteCostumer(String id) {
        Query query = new Query(Criteria.where(Costumer.ID).is(id));
        return repo.remove(query, Costumer.class);
    }

    public Costumer updateCostumer(Costumer costumer) {
        return repo.save(costumer,"costumer");
    }

    public List<Costumer> listAllCostumer() {
        return repo.findAll(Costumer.class,"costumer");
    }

    public Costumer getCostumerById(String id) {
        return repo.findById(id,Costumer.class);
    }
}
