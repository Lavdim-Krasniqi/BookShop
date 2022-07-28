package elbatech.bookshop.security.users.services;

import elbatech.bookshop.security.users.entities.User;
import elbatech.bookshop.security.users.entities.UserDto;
import elbatech.bookshop.security.users.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import static elbatech.bookshop.security.authorization.ApplicationUserRole.ROLE_ADMIN;
import static elbatech.bookshop.security.authorization.ApplicationUserRole.ROLE_USER;

@Service
@AllArgsConstructor
public class UserService {
    UserRepository repo;

    PasswordEncoder passwordEncoder;


    public User addUser(UserDto userDto) {

        User user = User.builder()
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .email(userDto.getEmail())
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .role(ROLE_USER.name())
                .build();
        return repo.addUser(user);
    }

    public User addAdmin(UserDto userDto) {
        User user = User.builder()
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .email(userDto.getEmail())
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .role(ROLE_ADMIN.name())
                .build();
        return repo.addUser(user);
    }

    @PostConstruct
    private void addDefaultAdmin() {
        User user = User.builder()
                .name("book")
                .surname("shop")
                .email("bookShop@gmail.com")
                .username("bookShop123")
                .password(passwordEncoder.encode("12345"))
                .role(ROLE_ADMIN.name())
                .build();
        if (!repo.doesExists(user.getUsername())) {
            repo.addUser(user);
        }
    }
}
