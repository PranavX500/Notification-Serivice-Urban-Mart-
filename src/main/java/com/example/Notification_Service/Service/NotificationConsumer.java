package com.example.Notification_Service.Service;

import com.example.Notification_Service.DTO.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @Autowired
    private NotificationService notificationService;

    @KafkaListener(
            topics = "Notification",
            groupId = "Notification-group",
            containerFactory = "responesToOrderKafkaListenerContainerFactory"
    )
    public void NotificationSender(EmailRequest emailRequest) {

        String msg = "Your Order has been placed successfully.\n" +
                "Order ID: " + emailRequest.getOrderId() + "\n" +
                "Total Price: ₹" + emailRequest.getTotalprice();

        notificationService.sendNotification(
                emailRequest.getEmailId(),
                "Order Confirmation",
                msg
        );
    }
}

