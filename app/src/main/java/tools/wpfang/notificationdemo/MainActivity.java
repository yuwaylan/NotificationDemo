package tools.wpfang.notificationdemo;
//  haha nothing 
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    NotificationManager notificationManager;
    NotificationCompat.Builder builder;
    private static final int NOTIFICATION_ID=1;
    private static final String NOTIFICATION_CHANNEL="Setting";
    NotificationChannel notificationChannel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    public void createNewChannnel(){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel;
            channel = new NotificationChannel(NOTIFICATION_CHANNEL,"Setting", NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("All the Setting Notificarion will come here");
            channel.enableVibration(true);
            notificationManager.createNotificationChannel(channel);
            Log.d("testing", "inside createNewChannel");
        }

    }
    public void doNotification(View view) {
        createNewChannnel();
        builder=new NotificationCompat.Builder(this,NOTIFICATION_CHANNEL);
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
