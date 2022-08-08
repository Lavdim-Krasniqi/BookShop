package elbatech.bookshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;


@SpringBootApplication
@EnableMongoAuditing
public class BookShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookShopApplication.class, args);
    }

}
