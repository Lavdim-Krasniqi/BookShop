package elbatech.bookshop.Customer.Controller;

import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.Customer.Entity.Costumer;
import elbatech.bookshop.Customer.Service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/costumer")

public class CostumerController {

    @Autowired
    CostumerService costumerService;

    @PostMapping("/addCostumer")
    public Costumer addCustomer (@RequestBody Costumer costumer){
        return costumerService.addCostumer(costumer);
    }

    @DeleteMapping("deleteCostumer/{id}")
    public DeleteResult deleteCostumer(@PathVariable(value ="id") String id){
        return costumerService.deleteCostumer(id);
    }

    @PutMapping("/updateCostumer/{id}")
    public Costumer updateCostumer(@RequestBody Costumer costumer, @PathVariable (value ="id") String id){
        return costumerService.updateCostumer(costumer);
    }

    @GetMapping("/listAllCostumer")
    public List<Costumer> listAllCostumer(){
        return costumerService.listAllCostumer();
    }

    @GetMapping("/getCostumer/{id}")
    public Costumer getCostumerById(@PathVariable (value = "id") String id){
        return costumerService.getCostumerById(id);
    }
}
