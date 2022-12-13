package com.example.notification;

//import static com.example.notification.R.drawable.ic_launcher_background;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            NotificationChannel channel= new NotificationChannel("My notification", "My notifiaction", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this, "My Notification");
                builder.setContentTitle("Notification");
                builder.setContentText("Hello there");
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat=NotificationManagerCompat.from(MainActivity.this);
                managerCompat.notify(0,builder.build());
            }
        });
//        onButtonClickListener();
    }

//    public void onButtonClickListener(){
//
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
//            NotificationChannel channel= new NotificationChannel("My notification", "My notifiaction", NotificationManager.IMPORTANCE_DEFAULT);
//            NotificationManager manager=getSystemService(NotificationManager.class);
//            manager.createNotificationChannel(channel);
//        }
//
//        b1=(Button)findViewById(R.id.button);
//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this, "My Notification");
//                builder.setContentTitle("Notification");
//                builder.setContentText("Hello there");
//                builder.setSmallIcon(R.drawable.ic_launcher_background);
//                builder.setAutoCancel(true);
//
//                NotificationManagerCompat managerCompat=NotificationManagerCompat.from(MainActivity.this);
//                managerCompat.notify(0,builder.build());
//            }
//        });
//    }
}