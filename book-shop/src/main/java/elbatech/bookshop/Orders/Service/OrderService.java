package elbatech.bookshop.Orders.Service;

import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.Book.Service.BookService;
import elbatech.bookshop.Info.Entity.Info;
import elbatech.bookshop.Info.Service.ServiceInfo;
import elbatech.bookshop.Orders.Entity.Orders;
import elbatech.bookshop.Orders.Repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrdersRepository repository;

    @Autowired
    ServiceInfo serviceInfo;

    public Orders addOrders(Orders orders) {
        if (serviceInfo.getByBookIdAndEditionNumber(orders.getBookId(), orders.getEditionNumber())) {
            return repository.addOrders(orders);
        }
        throw new RuntimeException("This book does not exists");
    }

    public DeleteResult deleteOrder(String id) {
        return repository.deleteOrder(id);
    }

    public Orders editOrders(Orders orders) {
        if (serviceInfo.getByBookIdAndEditionNumber(orders.getBookId(), orders.getEditionNumber())) {
            return repository.addOrders(orders);
        }
        throw new RuntimeException("This book does not exists");
    }

    public List<Orders> getAllOrders() {
        return repository.getAllOrders();
    }

    public Orders getOrdersById(String id) {
        return repository.getOrdersById(id);
    }
}
