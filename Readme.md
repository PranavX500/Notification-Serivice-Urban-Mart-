# Notification Service (Ecommerce Microservices)

The **Notification Service** is responsible for sending **email notifications** to users in the Ecommerce Microservices system.

This service **does not expose any REST APIs**.
It works entirely in an **event-driven manner**, consuming payment-related events from **Payment Service** via Kafka and sending confirmation emails using **JavaMailSender**.

---

## Tech Stack

* Spring Boot
* Kafka (Consumer)
* JavaMailSender
* Email (SMTP)
* Microservices Architecture
* Maven
* Lombok

---

## Responsibilities

### Event Consumption

* Consumes payment completion events from Payment Service via Kafka
* Listens for successful payment notifications

### Email Notification

* Sends order confirmation emails to users
* Uses JavaMailSender for email delivery

---

## Kafka Event Consumption

### Consumed DTO Structure

The Notification Service consumes the following data from Payment Service:

```java
private String emailId;
private Long userId;
private Long orderId;
private Double totalprice;
```

### Event Description

* `emailId` – Email address of the user
* `userId` – Unique user identifier
* `orderId` – Order reference number
* `totalprice` – Total order amount

---

## Email Flow

1. Payment Service completes payment
2. Payment event is published to Kafka
3. Notification Service consumes the event
4. Email is sent to the corresponding user
5. Order confirmation is delivered successfully

---

## Email Content (Example)

* Subject: Order Confirmation
* Body includes:

  * Order ID
  * Total Amount
  * Payment confirmation message

---

## Architecture Flow

```
Payment Service
      ↓ (Kafka)
Notification Service
      ↓
Email (JavaMailSender)
      ↓
User Inbox
```

---

## Future Enhancements

* Email templates (HTML / Thymeleaf)
* Retry mechanism for failed emails
* SMS / WhatsApp notifications
* Notification history persistence

---

## Author

Pranav Sharma
Spring Boot | Kafka | Email Systems | Microservices

---
