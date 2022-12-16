package com.example.layout_event_listeners;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView t1, t2, t3;
    String dept, name, rollno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        t1=(TextView)findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);
        t3=(TextView)findViewById(R.id.t3);

        Intent i=getIntent();

        name=i.getStringExtra("name_key");
        rollno=i.getStringExtra("rollno_key");
        dept=i.getStringExtra("dept_key");


        t1.setText(name);
        t1.setTextColor(Color.WHITE);
        t2.setText(rollno);
        t2.setTextColor(Color.WHITE);
        t3.setText(dept);
        t3.setTextColor(Color.WHITE);
    }
}