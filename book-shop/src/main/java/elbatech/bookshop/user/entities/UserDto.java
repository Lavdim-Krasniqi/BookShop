package elbatech.bookshop.users.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private String name;
    private String surname;
    private String email;
    private String username;
    private String password;
}