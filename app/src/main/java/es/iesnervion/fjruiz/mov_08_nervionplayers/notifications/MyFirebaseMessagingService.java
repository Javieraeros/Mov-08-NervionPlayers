package es.iesnervion.fjruiz.mov_08_nervionplayers.notifications;

import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import es.iesnervion.fjruiz.mov_08_nervionplayers.R;

/**
 * Created by fjruiz on 7/02/17.
 */
public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        showNotification(remoteMessage);
    }

    private void showNotification(RemoteMessage message) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setAutoCancel(true)
                .setContentTitle(getResources().getText(R.string.app_name))
                .setContentText(message.getNotification().getBody())
                .setSmallIcon(R.drawable.ic_announcement_white_24dp);

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(0,builder.build());
    }


}
