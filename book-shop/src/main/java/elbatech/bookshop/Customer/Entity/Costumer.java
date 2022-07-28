package elbatech.bookshop.Customer.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document
@Data
@NoArgsConstructor
public class Costumer {
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String PERSONAL_NUMBER = "personalNo";
    public static final String ORDER_ID = "orderId";


    private String id;
    private String name;
    private String surname;
    private String personalNo;
    private String orderId;

    @CreatedDate
    private Instant createdDate;
}
