package elbatech.bookshop.Publisher.Controller;

import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.Publisher.Entity.Publisher;
import elbatech.bookshop.Publisher.Service.ServicePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    ServicePublisher servicePublisher;

    @PostMapping("/addPublisher")
    public Publisher addPublisher(@RequestBody Publisher publisher){
        return servicePublisher.addPublisher(publisher);
    }

    @PutMapping("/editPublisher/{id}")
    public Publisher editPublisher(@RequestBody Publisher publisher, @PathVariable (value = "id") String id){
        return servicePublisher.editPublisher(publisher);
    }

    @DeleteMapping("/deletePublisher/{id}")
    public DeleteResult deletePublisher(@PathVariable (value = "id") String id){
        return servicePublisher.deletePublisher(id);
    }

    @GetMapping("/getPublisherById/{id}")
    public Publisher getPublisherById(@PathVariable(value = "id") String id){
        return servicePublisher.getPublisherById(id);
    }

    @GetMapping("/getAllPublishers")
    public List<Publisher> getAllPublishers(){
        return servicePublisher.getAllPublishers();
    }



}
