package elbatech.bookshop.book.entities;

import elbatech.bookshop.author.Entity.Author;
import elbatech.bookshop.publisher.Entity.Publisher;
import elbatech.bookshop.base.BaseEntity;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.time.Instant;
import java.util.List;

@Document("Book")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Book extends BaseEntity {

    public static final String ID = "id";
    public static final String TITTLE = "tittle";
    public static final String ISBN = "isbn";
    public static final String GENRE = "genre";
    public static final String PUBLISH_DATE = "publishDate";
    public static final String PAGE_IDS = "pageIds";
    public static final String PAGE_NUMBER = "pageNumber";
    public static final String PRICE = "price";
    public static final String LIST_OF_PUBLISHERS = "listOfPublishers";
    public static final String RATE = "rate";
    public static final String EDITION_NUMBER = "editionNumber";
    public static final String LIST_OF_AUTHORS = "listOfAuthors";

    private String tittle;
    private String isbn;
    private String genre;
    private Instant publishDate;
    private Integer pageNumber;
    private Double price;
    @Field(targetType = FieldType.OBJECT_ID)
    private List<String> listOfPublishers;
    private Integer rate;
    private Integer editionNumber;
    @Field(targetType = FieldType.OBJECT_ID)
    private List<String> listOfAuthors;

}
