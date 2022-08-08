package elbatech.bookshop.notification.services;

import elbatech.bookshop.notification.entities.Notification;
import elbatech.bookshop.notification.repositories.NotificationRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Data
public class NotificationService {

    private NotificationRepository repo;
    private JavaMailSender mailSender;

    /**
     * This method will be called every time when admin adds new book on database
     *
     * @param notification defines mail recipients and details of message
     **/

    public String sendNotification(Notification notification) {
        String[] emails = new String[notification.getRecipients().size()];
        notification.getRecipients().toArray(emails);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("bookshop.KS123@gmail.com ");
        message.setBcc(emails);
        message.setText(notification.getMessage());
        message.setSubject(notification.getSubject());

        mailSender.send(message);
        repo.addNotification(notification);

        return "Successfully send!";
    }
}
