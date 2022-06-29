package elbatech.bookshop.book.entities;

import lombok.Data;

import java.util.List;

@Data
public class RequestDto {

    private String title;
    private List<String> authorsIds;
}
