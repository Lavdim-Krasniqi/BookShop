package elbatech.bookshop.Book.Entity;

import lombok.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.stereotype.Component;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Document
@ComponentScan
public class Book {

    public static final String ID = "id";
    public static final String TITTLE = "tittle";

    @Id
    @Field(targetType = FieldType.OBJECT_ID)
    private String id;
    private String tittle;
    @CreatedDate
    private Instant createdDate;
}
