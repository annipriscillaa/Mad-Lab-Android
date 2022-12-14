package com.example.sqliteapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editName, editSurname, editMarks, editId;
    Button btnAddData,btnViewAll, btnUpdate, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb=new DatabaseHelper(this);


        editName=(EditText)findViewById(R.id.name);
        editMarks=(EditText)findViewById(R.id.marks);
        editSurname=(EditText)findViewById(R.id.surname);
        btnAddData=(Button)findViewById(R.id.button_add);
        btnViewAll=(Button)findViewById(R.id.button_view_all);
        btnUpdate=(Button)findViewById(R.id.button_update);
        editId=(EditText)findViewById(R.id.EditId);
        btnDelete=(Button)findViewById(R.id.button_del);

        AddData();
        viewAll();
        UpdateData();
        DeleteData();
    }

    public void DeleteData(){
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Integer noOfRowsDel=myDb.deleteData(editId.getText().toString());
                        if(noOfRowsDel==0){
                            Toast.makeText(MainActivity.this, "Data not deleted", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(MainActivity.this, "Data deleted", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }


    public void UpdateData(){
        btnUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isUpdated=myDb.updateData(editId.getText().toString(),
                                editName.getText().toString(),editSurname.getText().toString(),editMarks.getText().toString());
                        if(isUpdated==true){
                            Toast.makeText(MainActivity.this, "Data was updated", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(MainActivity.this, "Data wasn't updated", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }


    public void AddData(){
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted= myDb.insertData(editName.getText().toString(),editSurname.getText().toString(),editMarks.getText().toString());
                        if(isInserted= true){
                            Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(MainActivity.this, "Data not inserted", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

    public void viewAll(){
        btnViewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Cursor res=myDb.getAllData();
                        if(res.getCount()==0){
                            showMessage("Error","No data to display");
                            return;
                        }
                        StringBuffer buffer=new StringBuffer();
                        while(res.moveToNext()){
                            buffer.append("Id :"+res.getString(0)+"\n");
                            buffer.append("Name :"+res.getString(1)+"\n");
                            buffer.append("Surname :"+res.getString(2)+"\n");
                            buffer.append("Marks :"+res.getString(3)+"\n\n");
                        }
                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }


}