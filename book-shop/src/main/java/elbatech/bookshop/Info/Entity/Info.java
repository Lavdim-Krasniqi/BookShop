package elbatech.bookshop.Info.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import elbatech.bookshop.Author.Entity.Author;
import elbatech.bookshop.Publisher.Entity.Publisher;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.util.BsonUtils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@CompoundIndex(def = "{'bookId':1, 'editionNumber':1}", unique = true, name = "info_index")
public class Info {

    public static final String ID = "id";
    public static final String BOOK_ID = "bookId";
    public static final String EDITION_NUMBER = "editionNumber";

    @Id
    private String id;

    @Field(targetType = FieldType.OBJECT_ID)
    private String bookId;
    private String ISBN;
    private String genre;
    @CreatedDate
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss", timezone="Europe/Zagreb")
    private Instant publishDate;
    private List<String> pageId;
    private Integer pageNumber;
    private Double price;
    private List<Publisher> publishers;
    private Integer rate;
    private Integer editionNumber;
    private List<Author> authors;


}
