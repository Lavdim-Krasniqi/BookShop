package elbatech.bookshop.page.Entity;

import elbatech.bookshop.base.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Getter
@Setter
@NoArgsConstructor
@Document("Page")
@CompoundIndex(def = "{'bookId':1, 'pageNumber':1}", unique = true)
public class Page extends BaseEntity {
    public static final String ID = "id";
    public static final String BOOK_ID = "bookId";
    public static final String CONTENT = "content";
    public static final String PAGE_NUMBER = "pageNumber";

    @Field(targetType = FieldType.OBJECT_ID)
    private String bookId;
    private String content;
    private Integer pageNumber;

}
