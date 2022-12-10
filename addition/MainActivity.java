package com.example.addition;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v){
        EditText e1=(EditText)findViewById(R.id.text1);
        EditText e2=(EditText)findViewById(R.id.text3);
        TextView t1=(TextView)findViewById(R.id.textView);
        int num1=Integer.parseInt(e1.getText().toString());
        int num2=Integer.parseInt(e2.getText().toString());
        int sum=num1+num2;
        t1.setText(Integer.toString(sum));
    }

}