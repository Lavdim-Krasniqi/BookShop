package elbatech.bookshop.author.Entity;

import elbatech.bookshop.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Document("Author")
@Getter
@Setter
public class Author extends BaseEntity {

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String COUNTRY = "country";

    private String name;
    private String surname;
    private Date birthdate;
    private String country;
}
