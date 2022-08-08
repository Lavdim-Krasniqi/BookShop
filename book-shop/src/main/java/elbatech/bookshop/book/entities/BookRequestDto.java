package elbatech.bookshop.book.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.time.Instant;
import java.util.List;

@Data
public class BookRequestDto {

    private String tittle;
    private String isbn;
    private String genre;
    private Instant publishDate;
    private Integer pageNumber;
    private Double price;
    private Integer rate;
    private List<String> listOfPublishers;
    private Integer editionNumber;
    private List<String> listOfAuthors;
}
