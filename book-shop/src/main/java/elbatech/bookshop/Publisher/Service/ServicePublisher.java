package elbatech.bookshop.Publisher.Service;

import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.Publisher.Entity.Publisher;
import elbatech.bookshop.Publisher.Repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePublisher {

    @Autowired
    PublisherRepository publisherRepository;
    public Publisher addPublisher(Publisher publisher) {
        return publisherRepository.addPublisher(publisher);
    }

    public Publisher editPublisher(Publisher publisher) {
        return publisherRepository.editPublisher(publisher);
    }

    public DeleteResult deletePublisher(String id) {
        return publisherRepository.deletePublisher(id);
    }

    public Publisher getPublisherById(String id) {
        return publisherRepository.getPublisherById(id);
    }

    public List<Publisher> getAllPublishers() {
        return publisherRepository.getAllPublishers();
    }
}
