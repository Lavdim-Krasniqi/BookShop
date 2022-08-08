package elbatech.bookshop.user.controllers;

import elbatech.bookshop.user.entities.User;
import elbatech.bookshop.user.entities.UserDto;
import elbatech.bookshop.user.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    UserService service;

    @PostMapping("/addUser")
    public User addUser(@RequestBody UserDto dto) {
        return service.addUser(dto);
    }

    @PreAuthorize("@methodAuthorization.hasRole('ROLE_ADMIN')")
    @PostMapping("/addAdmin")
    public User addAdmin(@RequestBody UserDto dto) {
        return service.addAdmin(dto);
    }

    @PreAuthorize("@methodAuthorization.hasAuthority('read')")
    @GetMapping("/great")
    public String hello() {
        return "hello";
    }


    @PreAuthorize("@methodAuthorization.hasAuthority('update')")
    @GetMapping("/hola")
    public String Hola() {
        return "hello";
    }

    @GetMapping("/getUsersWithEnabledNotifications")
    public List<String> getUsersEmailsWithNotificationEnabled() {
        return service.getUsersEmailsWithNotificationEnabled();
    }


}
