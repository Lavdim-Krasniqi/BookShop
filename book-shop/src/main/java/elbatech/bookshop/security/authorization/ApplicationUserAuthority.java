package elbatech.bookshop.security.authorization;

import lombok.Getter;

@Getter
public enum ApplicationUserAuthority {
    read,
    write,
    update,
    delete
}
