package elbatech.bookshop.publisher.Service;

import com.mongodb.client.result.DeleteResult;
import elbatech.bookshop.publisher.Entity.Publisher;
import elbatech.bookshop.publisher.Repository.PublisherRepository;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@ToString
public class ServicePublisher {

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

    public boolean checkIfAllGivenPublishersAreRegistered(List<String> publishersIds) {
        return publisherRepository.checkIfAllGivenPublishersAreRegistered(publishersIds);
    }


}
