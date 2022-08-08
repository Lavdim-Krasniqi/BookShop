package elbatech.bookshop.publisher.Controller;

import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.publisher.Entity.Publisher;
import elbatech.bookshop.publisher.Service.ServicePublisher;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publisher")
@AllArgsConstructor
public class PublisherController {
    ServicePublisher servicePublisher;

    @PostMapping("/addPublisher")
    public Publisher addPublisher(@RequestBody Publisher publisher) {
        return servicePublisher.addPublisher(publisher);
    }

    @PutMapping("/editPublisher/{id}")
    public Publisher editPublisher(@RequestBody Publisher publisher, @PathVariable(value = "id") String id) {
        return servicePublisher.editPublisher(publisher);
    }

    @DeleteMapping("/deletePublisher/{id}")
    public DeleteResult deletePublisher(@PathVariable(value = "id") String id) {
        return servicePublisher.deletePublisher(id);
    }

    @GetMapping("/getPublisherById/{id}")
    public Publisher getPublisherById(@PathVariable(value = "id") String id) {
        return servicePublisher.getPublisherById(id);
    }

    @GetMapping("/getAllPublishers")
    public List<Publisher> getAllPublishers() {
        return servicePublisher.getAllPublishers();
    }


}
