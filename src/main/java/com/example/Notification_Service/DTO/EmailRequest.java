package com.example.Notification_Service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailRequest {
    private String emailId;
    private Long UserId;
    private Long orderId;
    private Double totalprice;
}
