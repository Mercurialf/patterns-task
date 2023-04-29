package notification.type;


import notification.HtmlNotification;
import notification.Notification;

public class HtmlCheck extends Check {
    @Override
    public Notification createNotification() {
        return new HtmlNotification();
    }
}
