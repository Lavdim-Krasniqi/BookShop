package elbatech.bookshop.security;

import elbatech.bookshop.user.entities.User;
import elbatech.bookshop.user.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthenticationTests {

    @Autowired
    UserRepository repository;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void checkIfRepoIsNotNull() {
        assertThat(testRestTemplate).isNotNull();
    }

    @Test
    public void addUser() {
        var user = User.builder()
                .name("Lavdimiii")
                .surname("Krasniqiii")
                .username("12345")
                .password("11223344").build();


        repository.addUser(user);
        String url = "http://localhost:8080/login";
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(url).build();

        HttpHeaders headers = new HttpHeaders();
        headers.add("username", "dimi12345");
        headers.add("password", "12345");
        HttpEntity<Void> requestEntity = new HttpEntity<>(null, headers);

        ResponseEntity<Void> response = testRestTemplate.exchange(builder.toString(), HttpMethod.POST, requestEntity, Void.class);
        String authorization = Objects.requireNonNull(response.getHeaders().get("Authorization")).stream().findFirst().orElseThrow();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        System.out.println("-----------------------Token: " + authorization);
        assertThat(repository.findByUsername("12345")).isEqualTo(user);
    }

}
