package com.example.shapes;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bitmap bg=Bitmap.createBitmap(720, 1280, Bitmap.Config.ARGB_8888);
        ImageView i=(ImageView)findViewById(R.id.imageView);
        i.setBackgroundDrawable(new BitmapDrawable(bg));

        Canvas canvas=new Canvas(bg);

        Paint paint=new Paint();
        paint.setColor(Color.BLUE);
        paint.setTextSize(30);

        Paint paint2=new Paint();
        paint2.setColor(Color.RED);
        paint2.setTextSize(50);

        canvas.drawCircle(500, 250, 100, paint);

        canvas.drawText("Circle", 450, 250, paint2);
        canvas.drawRect(300, 100, 100, 650, paint);
        paint2.setColor(Color.TRANSPARENT);
        canvas.drawOval(300, 1300, 100, 700, paint2);

//        invalidate();
    }
}