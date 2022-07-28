package elbatech.bookshop.security.users.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("User")
public class User {

    public static final String USERNAME = "username";
    public static final String ID = "id";
    public static final String PASSWORD = "password";
    public static final String ROLE = "role";

    private String id;
    private String name;
    private String surname;
    private String email;
    @Indexed(unique = true)
    private String username;
    private String password;
    private String role;
}
