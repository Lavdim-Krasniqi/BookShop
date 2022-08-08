package elbatech.bookshop.Page.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document
public class Page {
    public static final String ID = "id";

    private String id;
    private String editionNumber;
    private String content;
    private Integer currentNumberOfPage;

}
