package elbatech.bookshop.Publisher.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Publisher{
    public static final String ID = "id";

    private String id;
    private String name;
    private String country;

    @CreatedDate
    private Instant createdDate;

}
