package elbatech.bookshop.users.services;

import elbatech.bookshop.users.repositories.UserRepository;
import elbatech.bookshop.users.entities.SecurityUser;
import elbatech.bookshop.users.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException("This user does not exists");
        return new SecurityUser(user);
    }


}
