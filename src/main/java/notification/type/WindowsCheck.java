package notification.type;


import notification.Notification;
import notification.WindowsNotification;

public class WindowsCheck extends Check {
    @Override
    public Notification createNotification() {
        return new WindowsNotification();
    }
}
