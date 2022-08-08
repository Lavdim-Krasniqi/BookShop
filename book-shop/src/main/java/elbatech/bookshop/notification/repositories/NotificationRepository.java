package elbatech.bookshop.notifications.repositories;

import elbatech.bookshop.notifications.entities.Notification;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@AllArgsConstructor
@ToString
public class NotificationRepository {

    MongoTemplate repo;

    public void addNotification(Notification notification) {
        repo.insert(notification);
    }
}
