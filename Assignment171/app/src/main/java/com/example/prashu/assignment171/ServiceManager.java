package com.example.prashu.assignment171;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

import java.nio.channels.Channel;

import static com.example.prashu.assignment171.MyNotificationManager.CHANNEL_ID;

/**
 * Created by Prashu on 02-06-2018.
 */

public class ServiceManager extends Service {

    private MediaPlayer musicPlayer;
   Context context;


    @Override
    public void onCreate() {
        super.onCreate();
        musicPlayer = MediaPlayer.create(getApplicationContext(), R.raw.media);
        context=this;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        musicPlayer.start();
        Intent intent1 = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,201,intent1,0);
        Notification notification = new NotificationCompat.Builder(this,CHANNEL_ID).setContentTitle("Music Player")
                .setContentText("Click here to play or stop music").setSmallIcon(R.drawable.yo).setContentIntent(pendingIntent)
                .build();
        startForeground(1,notification);

        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        musicPlayer.release();
        super.onDestroy();
    }
}
