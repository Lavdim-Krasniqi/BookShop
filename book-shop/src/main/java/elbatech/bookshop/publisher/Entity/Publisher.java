package elbatech.bookshop.publisher.Entity;

import elbatech.bookshop.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Publisher")
@Getter
@Setter
public class Publisher extends BaseEntity {
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String COUNTRY = "country";

    private String name;
    private String country;

}
