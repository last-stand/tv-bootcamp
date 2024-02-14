package org.example.userRegistration;

public interface Notifier<T> {
    void sendNotification(T recipient);
}
