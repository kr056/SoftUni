package g_ISPandDIP.Lab.p02_Services;

public class OnlineStoreOrder {

    private NotificationService notificationService;

    public OnlineStoreOrder(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void process() {
        if (this.notificationService.isActive()) {
            this.notificationService.sendNotification();
        }
    }
}
