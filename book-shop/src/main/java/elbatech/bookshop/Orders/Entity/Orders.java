package elbatech.bookshop.Orders.Entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.time.Instant;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Orders {
    public static final String ID = "id";

    @Id
    @Field(targetType = FieldType.OBJECT_ID)
    private String id;
    private String bookId;
    private Integer editionNumber;
    private Integer quantity;

    @CreatedDate
    private Instant createdDate;

}
