package org.example.userRegistration;

public class NotifierFactory {

    private final Notifier<String> emailNotifier;
    private final Notifier<String> smsNotifier;

    public NotifierFactory(Notifier<String> emailNotifier, Notifier<String> smsNotifier) {
        this.emailNotifier = emailNotifier;
        this.smsNotifier = smsNotifier;
    }

    Notifier<String> getNotifier(NotificationPreference notificationPreference) {
        if (notificationPreference.equals(NotificationPreference.EMAIL)) {
            return this.emailNotifier;
        } else {
            return this.smsNotifier;
        }
    }
}
