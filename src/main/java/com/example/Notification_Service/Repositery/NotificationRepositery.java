package com.example.Notification_Service.Repositery;

import com.example.Notification_Service.Model.Notifcation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepositery extends JpaRepository<Notifcation,Long> {


}
