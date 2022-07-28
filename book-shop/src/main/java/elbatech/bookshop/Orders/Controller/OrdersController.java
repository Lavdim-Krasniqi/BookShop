package elbatech.bookshop.Orders.Controller;

import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.Orders.Entity.Orders;
import elbatech.bookshop.Orders.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    OrderService ordersService;

    @PostMapping("/addOrders")
    public Orders addOrders(@RequestBody Orders orders) {
        return ordersService.addOrders(orders);
    }

    @DeleteMapping("/deleteOrder/{id}")
    public DeleteResult deleteOrder(@PathVariable(value = "id") String id) {
        return ordersService.deleteOrder(id);
    }

    @PutMapping("/editOrders")
    public Orders editOrders(@RequestBody Orders orders) {
        return ordersService.addOrders(orders);
    }

    @GetMapping("/getAllOrders")
    public List<Orders> getAllOrders() {
        return ordersService.getAllOrders();
    }

    @GetMapping("/getOrdersById/{id}")
    public Orders getOrdersById(@PathVariable(value = "id") String id) {
        return ordersService.getOrdersById(id);
    }

}
