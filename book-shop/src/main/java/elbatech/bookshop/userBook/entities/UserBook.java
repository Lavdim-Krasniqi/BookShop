package elbatech.bookshop.userBook.entities;

import elbatech.bookshop.base.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document("User_Books")
@Getter
@Setter
@Builder
@CompoundIndex(def = "{'bookId':1, 'username':1}", unique = true)
public class UserBook extends BaseEntity {

    public static final String BOOK_ID = "bookId";
    public static final String USERNAME = "username";
    public static final String PAGE_NUMBER = "pageNumber";

    @Field(targetType = FieldType.OBJECT_ID)
    private String bookId;
    private String username;
    private Integer pageNumber;


}
