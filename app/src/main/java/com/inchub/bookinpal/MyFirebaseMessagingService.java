package com.inchub.bookinpal;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        getFirebaseMessage(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
    }

    public void getFirebaseMessage(String title, String msg) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "MyFrebaseChannel")
                .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                .setContentTitle(title)
                .setContentText(msg)
                .setAutoCancel(true);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(101,builder.build());


    }
}
