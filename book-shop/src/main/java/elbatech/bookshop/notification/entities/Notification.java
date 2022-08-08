package elbatech.bookshop.notifications.entities;

import elbatech.bookshop.base.BaseEntity;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("Notifications")
@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
public class Notification extends BaseEntity {

    public static final String ID = "id";
    public static final String RECIPIENT = "recipient";

    private List<String> recipients;
    private String message;
    private String subject;
    private String attachment;

}
