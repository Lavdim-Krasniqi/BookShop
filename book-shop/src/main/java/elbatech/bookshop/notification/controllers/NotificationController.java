package elbatech.bookshop.notifications.controllers;

import elbatech.bookshop.notifications.services.NotificationService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Data
@RequestMapping("/notification")
public class NotificationController {

    private NotificationService service;

//    @PostMapping("/send")
//    public String sendNotification(){
//        return service.sendNotification();
//    }

}
