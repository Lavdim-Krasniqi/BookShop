package elbatech.bookshop.notification.repositories;

import elbatech.bookshop.notification.entities.Notification;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
@ToString
public class NotificationRepository {

    MongoTemplate repo;

    public void addNotification(Notification notification) {
        repo.insert(notification);
    }
}
