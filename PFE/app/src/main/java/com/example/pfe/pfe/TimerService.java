package com.example.pfe.pfe;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerService extends Service {
    // constant
    public static final long NOTIFY_INTERVAL = 10 * 700; // 7 seconds

    // run on another Thread to avoid crash
    private Handler mHandler = new Handler();
    // timer handling
    private Timer mTimer = null;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        // cancel if already existed
        if(mTimer != null) {
            mTimer.cancel();
        } else {
            // recreate new
            mTimer = new Timer();
        }
        // schedule task
        mTimer.scheduleAtFixedRate(new TimeDisplayTimerTask(), 0, NOTIFY_INTERVAL);
    }

    class TimeDisplayTimerTask extends TimerTask {

        @Override
        public void run() {
            // run on another thread
            mHandler.post(new Runnable() {

                @Override
                public void run() {
                    // display toast
                    showNotification("hello time is: " + getDateTime(), getApplicationContext());
                }

            });
        }

        private String getDateTime() {
            // get date time in custom format
            SimpleDateFormat sdf = new SimpleDateFormat("[yyyy/MM/dd - HH:mm:ss]");
            return sdf.format(new Date());
        }

        private NotificationCompat.Builder showNotification(String eventtext, Context ctx) {
            //NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(ctx);
            //mBuilder.setSmallIcon(R.drawable.notification_icon);
            //mBuilder.setContentTitle("Notification Alert, Click Me!");
            //mBuilder.setContentText(eventtext);

            //NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            // notificationID allows you to update the notification later on.
            //mNotificationManager.notify(0, mBuilder.build());
            Toast.makeText(getApplicationContext(), eventtext,
                    Toast.LENGTH_SHORT).show();
             return new NotificationCompat.Builder(getApplicationContext(), "Test")
                    .setContentTitle("Test Alarm")
                    .setContentText(eventtext)
                    .setSmallIcon(R.drawable.ic_launcher_background);

        }

    }
}
