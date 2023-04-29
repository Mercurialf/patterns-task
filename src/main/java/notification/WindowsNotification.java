package notification;

public class WindowsNotification implements Notification {
    @Override
    public void notify(String text) {
        System.out.println("Windows Notification");
        System.out.println(text);
    }
}
