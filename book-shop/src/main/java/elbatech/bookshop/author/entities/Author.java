package elbatech.bookshop.author.entities;

import elbatech.bookshop.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@Document("Author")
public class Author extends BaseEntity {
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String BIRTHDATE = "birthDate";
    public static final String COUNTRY = "country";

    private String name;
    private String surname;
    private Date birthDate;
    private String country;
}
