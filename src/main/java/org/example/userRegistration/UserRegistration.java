package org.example.userRegistration;

public class UserRegistration {
    private final NotifierFactory notifierFactory;

    public UserRegistration(NotifierFactory notifierFactory) {
        this.notifierFactory = notifierFactory;
    }

    public void register(User user) {
        System.out.println("User is registered successfully");
        Notifier notifier = notifierFactory.getNotifier(user.getNotificationPreference());
        String recipient = user.getNotificationPreference().equals(NotificationPreference.EMAIL) ? user.getEmail() : user.getPhone();
        notifier.sendNotification(recipient);
    }

}
