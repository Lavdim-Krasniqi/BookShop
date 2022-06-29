package elbatech.bookshop.book.entities;

import elbatech.bookshop.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Document("Book")
public class Book extends BaseEntity {
    public static final String ID = "id";
    public static final String TITLE = "name";

    private String title;
    @Field(targetType = FieldType.OBJECT_ID)
    private List<String> authorsIds;
}
