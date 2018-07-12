package tools.wpfang.notificationdemo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    NotificationManager notificationManager;
    NotificationCompat.Builder builder;
    private static final int NOTIFICATION_ID=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    public void doNotification(View view) {
        builder=new NotificationCompat.Builder(this);
        builder.setContentTitle("1 New message");
        builder.setContentText("Hi,How mare you");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        Intent it=new Intent(this,MainActivity.class);
        PendingIntent pd=PendingIntent.getActivity(this,NOTIFICATION_ID,it,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pd);
        builder.setAutoCancel(true);
        notificationManager.notify(NOTIFICATION_ID,builder.build());
        finish();
    }
}
