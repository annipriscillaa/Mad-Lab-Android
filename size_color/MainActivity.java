package com.example.font_color;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    TextView textView;
    Button btSize, btColor;
    int co=1;
    int si=30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1=(EditText)findViewById(R.id.editText);
        btColor=(Button)findViewById(R.id.color);
        btSize=(Button)findViewById(R.id.size);
        textView=(TextView)findViewById(R.id.result);

        onButtonClickColor();
        onButtonClickSize();
    }

    public void onButtonClickColor(){
        btColor.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        textView.setText(editText1.getText().toString());
                        switch(co){
                            case 1:
                                textView.setTextColor(Color.RED);
                                break;
                            case 2:
                                textView.setTextColor(Color.BLUE);
                                break;
                            case 3:
                                textView.setTextColor(Color.YELLOW);
                                break;
                        }
                        co=co+1;
                        if(co>3){
                            co=1;
                        }
                    }
                }
        );
    }

    public void  onButtonClickSize(){
        btSize.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        si=si+30;
                        textView.setText(editText1.getText().toString());
                        textView.setTextSize(si);

                        if(si>150){
                            si=30;
                        }
                    }
                }
        );
    }
}