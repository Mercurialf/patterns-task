package notification;

public class HtmlNotification implements Notification {
    @Override
    public void notify(String text) {
        System.out.println("HTML Notification");
        System.out.println(text);
    }
}
