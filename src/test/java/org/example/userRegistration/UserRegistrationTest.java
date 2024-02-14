package org.example.userRegistration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationTest {
    @Test
    void shouldSendEmailToRegisteredUserIfNotificationPreferenceIsEmail() {
        User user = new User("Admin", "admin@email.com", "9876543210", NotificationPreference.EMAIL);
        NotifierStub<String> emailNotifier = new NotifierStub<>();
        NotifierStub<String> smsNotifier = new NotifierStub<>();
        UserRegistration userRegistration = new UserRegistration(new NotifierFactory(emailNotifier, smsNotifier));

        userRegistration.register(user);

        assertTrue(emailNotifier.isSent());
    }

    @Test
    @DisplayName("Recipient is admin@email.com")
    void shouldSendEmailToRegisteredUserEmailIfNotificationPreferenceIsEmail() {
        User user = new User("Admin", "admin@email.com", "9876543210", NotificationPreference.EMAIL);
        NotifierStub<String> emailNotifier = new NotifierStub<>();
        NotifierStub<String> smsNotifier = new NotifierStub<>();
        UserRegistration userRegistration = new UserRegistration(new NotifierFactory(emailNotifier, smsNotifier));

        userRegistration.register(user);

        assertEquals("admin@email.com", emailNotifier.getRecipient());
    }

    @Test
    void shouldSendSMSToRegisteredUserIfNotificationPreferenceIsSMS() {
        User user = new User("Admin", "admin@email.com", "9876543210", NotificationPreference.SMS);
        NotifierStub<String> smsNotifier = new NotifierStub<>();
        NotifierStub<String> emailNotifier = new NotifierStub<>();
        UserRegistration userRegistration = new UserRegistration(new NotifierFactory(emailNotifier, smsNotifier));

        userRegistration.register(user);

        assertTrue(smsNotifier.isSent());
    }

    @Test
    @DisplayName("Recipient is 9876543210")
    void shouldSendSMSToRegisteredUserPhoneNumberIfNotificationPreferenceIsSMS() {
        User user = new User("Admin", "admin@email.com", "9876543210", NotificationPreference.SMS);
        NotifierStub<String> smsNotifier = new NotifierStub<>();
        NotifierStub<String> emailNotifier = new NotifierStub<>();
        UserRegistration userRegistration = new UserRegistration(new NotifierFactory(emailNotifier, smsNotifier));

        userRegistration.register(user);

        assertEquals("9876543210", smsNotifier.getRecipient());
    }

    @Test
    void shouldNotSendEmailIfNotificationPreferenceIsSMS() {
        User user = new User("Admin", "admin@email.com", "9876543210", NotificationPreference.SMS);
        NotifierStub<String> smsNotifier = new NotifierStub<>();
        NotifierStub<String> emailNotifier = new NotifierStub<>();
        NotifierFactory notifierFactory = new NotifierFactory(emailNotifier, smsNotifier);
        UserRegistration userRegistration = new UserRegistration(notifierFactory);

        userRegistration.register(user);

        assertFalse(emailNotifier.isSent());
    }

    private class NotifierStub<T> implements Notifier<T>{
        private boolean sent;
        private T recipient;

        @Override
        public void sendNotification(T recipient) {
            sent = true;
            this.recipient = recipient;
        }
        public boolean isSent() {
            return sent;
        }

        public T getRecipient() {
            return recipient;
        }
    }
}