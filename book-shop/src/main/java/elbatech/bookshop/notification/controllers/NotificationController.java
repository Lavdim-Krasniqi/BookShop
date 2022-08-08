package elbatech.bookshop.notification.controllers;

import elbatech.bookshop.notification.services.NotificationService;
import lombok.AllArgsConstructor;
import lombok.Data;
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
