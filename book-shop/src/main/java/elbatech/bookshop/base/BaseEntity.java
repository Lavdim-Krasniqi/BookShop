package elbatech.bookshop.base;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@Data
public class BaseEntity {

    @Id
    private String id;
    @CreatedDate
    private Instant createdDate;
    @LastModifiedDate
    private Instant lastModified;
}
