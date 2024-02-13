package org.example.userRegistration;

public class UserRegistration {
    private Notifier emailNotifier;
    private Notifier smsNotifier;
    private Notifier notifier;

    public UserRegistration(Notifier emailNotifier, Notifier smsNotifier) {
        this.emailNotifier = emailNotifier;
        this.smsNotifier = smsNotifier;
    }

    public void register(User user) {
        System.out.println("User is registered successfully");
        if (user.getNotificationPreference().equals(NotificationPreference.EMAIL)) {
            emailNotifier.sendNotification(user.getEmail());
        } else {
            smsNotifier.sendNotification(user.getPhone());
        }
    }
}
