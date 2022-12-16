package com.example.notification_final_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button b1;
    EditText e1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button)findViewById(R.id.button);
        e1=(EditText)findViewById(R.id.name);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel("hi","hi", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        b1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this, "hi");
                        builder.setSmallIcon(R.drawable.ic_launcher_background);
                        builder.setAutoCancel(true);
                        builder.setContentTitle("heyyyyy");
                        builder.setContentText(e1.getText().toString());

                        NotificationManagerCompat managerCompat=NotificationManagerCompat.from(MainActivity.this);
                        managerCompat.notify(1, builder.build());

                    }
                }
        );
    }
}