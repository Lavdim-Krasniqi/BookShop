package elbatech.bookshop.Author.Entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.stereotype.Component;

import javax.sound.midi.Sequence;
import java.time.Instant;
import java.util.Date;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component
public class Author  {

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String SURNAME = "surname";

    public static final String COUNTRY = "country";

    @Id
    @Field
    private String id;
    private String name;
    private String surname;
    private Date birthdate;
    private String country;


    @CreatedDate
    private Instant createdDate;
}
