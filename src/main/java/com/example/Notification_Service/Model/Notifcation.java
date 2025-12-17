package com.example.Notification_Service.Model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "Notification")
public class Notifcation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY )
    private Long id;

    private int UserId;
    private Long orderId;

    @CreatedDate
    @Column(columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime created_at;


}



//Notification {
//    id (UUID)
//    userId
//            email
//    orderId
//    type (EMAIL/SMS/PUSH)
//    message
//    status (PENDING/SENT/FAILED/RETRY)
//    attempts (int)
//    createdAt
//            sentAt
//}