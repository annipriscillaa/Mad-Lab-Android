package com.example.layout_event_listeners;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    EditText editName, editRollNo;
    Button btSubmit;
    Spinner s;
    String[] dept={"IT", "CSE", "ECE", "EEE", "MECH"};
    String name, dept2, rollNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        editDept=(EditText)findViewById(R.id.deptText);
        editName=(EditText)findViewById(R.id.nameText);
        editRollNo=(EditText)findViewById(R.id.rollnoText);
        btSubmit=(Button)findViewById(R.id.submit);
        s=(Spinner)findViewById(R.id.spinner);

        ArrayAdapter adapter=new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_item, dept);
        s.setAdapter(adapter);

        btSubmit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        name=editName.getText().toString();
                        dept2=s.getSelectedItem().toString();
                        rollNo=editRollNo.getText().toString();

                        Intent i=new Intent(MainActivity.this, SecondActivity.class);
                        i.putExtra("name_key", name);
                        i.putExtra("dept_key",dept2);
                        i.putExtra("rollno_key", rollNo);

                        startActivity(i);
                    }
                }
        );
    }
}