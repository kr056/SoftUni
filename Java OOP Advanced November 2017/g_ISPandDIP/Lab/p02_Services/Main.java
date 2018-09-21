package g_ISPandDIP.Lab.p02_Services;

public class Main {
    public static void main(String[] args) {
        NotificationService email = new EmailNotificationService(true);
        NotificationService sms = new SmsNotificationService();

        OnlineStoreOrder onlineStoreOrderSms = new OnlineStoreOrder(sms);
        OnlineStoreOrder onlineStoreOrderEmail = new OnlineStoreOrder(email);

        onlineStoreOrderEmail.process();
        onlineStoreOrderSms.process();
    }

}
