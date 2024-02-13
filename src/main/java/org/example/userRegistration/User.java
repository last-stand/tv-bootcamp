package org.example.userRegistration;

public class User {
    private final String name;
    private final String email;
    private final String phone;
    private NotificationPreference notificationPreference;

    public User(String name, String email, String phone, NotificationPreference notificationPreference) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.notificationPreference = notificationPreference;
    }

    public NotificationPreference getNotificationPreference() {
        return this.notificationPreference;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
