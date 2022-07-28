package elbatech.bookshop.Customer.Service;

import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.Customer.Entity.Costumer;
import elbatech.bookshop.Customer.Repository.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostumerService {

    @Autowired
    CostumerRepository costumerRepository;
    public Costumer addCostumer(Costumer costumer) {
        return costumerRepository.addCostumer(costumer);
    }

    public DeleteResult deleteCostumer(String id) {
        return costumerRepository.deleteCostumer(id);
    }

    public Costumer updateCostumer(Costumer costumer) {
        return costumerRepository.updateCostumer(costumer);
    }

    public List<Costumer> listAllCostumer() {
        return costumerRepository.listAllCostumer();
    }


    public Costumer getCostumerById(String id) {
        return costumerRepository.getCostumerById(id);
    }
}
