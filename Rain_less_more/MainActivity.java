package com.example.rain_less_more;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v){
        EditText e1=(EditText)findViewById(R.id.rain_level);
        Button b1=(Button)findViewById(R.id.button);
        TextView t1=(TextView)findViewById(R.id.textView);
        int r1=Integer.parseInt(e1.getText().toString());
        if(r1>30){
            t1.setText("Lot of rain");
            Toast.makeText(MainActivity.this, "Lot of rain",Toast.LENGTH_LONG).show();

        }else{
            t1.setText("less rain");
            Toast.makeText(MainActivity.this, "Less rain",Toast.LENGTH_LONG).show();
        }
    }

}