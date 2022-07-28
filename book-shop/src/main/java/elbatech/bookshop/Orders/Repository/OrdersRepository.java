package elbatech.bookshop.Orders.Repository;

import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.Orders.Entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrdersRepository {

    @Autowired
    MongoTemplate repo;

    public Orders addOrders(Orders orders) {
        return repo.save(orders);
    }

    public Orders editOrders(Orders orders) {
        return repo.save(orders,"orders");
    }

    public DeleteResult deleteOrder(String id) {
        return repo.remove(Query.query(Criteria.where(Orders.ID).is(id)));
    }

    public List<Orders> getAllOrders() {
        return repo.findAll(Orders.class);
    }

    public Orders getOrdersById(String id) {
        return repo.findById(id,Orders.class);
    }
}
