package elbatech.bookshop.Orders.Entity;

import lombok.Data;

@Data
public class OrderRequestDto {

    private String bookId;
    private String editionId;
    private Integer quantity;
}
