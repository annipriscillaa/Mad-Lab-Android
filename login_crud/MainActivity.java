package com.example.sqlitedemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;

    EditText editName, editSurname, editMark, editId;
    Button btnAddData, btnDeleteData, btnUpdateData, btnDisplayData, btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb=new DatabaseHelper(this);

        editName=(EditText)findViewById(R.id.name);
        editSurname=(EditText)findViewById(R.id.surname);
        editMark=(EditText)findViewById(R.id.mark);
        editId=(EditText)findViewById(R.id.id);
        btnAddData=(Button)findViewById(R.id.insert_bt);
        btnDisplayData=(Button)findViewById(R.id.display_bt);
        btnUpdateData=(Button)findViewById(R.id.update_bt);
        btnDeleteData=(Button)findViewById(R.id.delete_bt);
        btnLogin=(Button)findViewById(R.id.login_bt);

        UpdateData();
        DeleteData();
        AddData();
        displayData();
        loginFn();

    }

    public void loginFn(){
        btnLogin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isLoggedIn=myDb.loginFn(editName.getText().toString());
                        if(isLoggedIn==true){
                            Intent i=new Intent(MainActivity.this, SecondActivity.class);
                            startActivity(i);
                            Toast.makeText(MainActivity.this, "login was successful", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this, "login was unsuccessful", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }


    public void UpdateData(){
        btnUpdateData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isUpdated=myDb.updateData(editId.getText().toString(),editName.getText().toString(),
                                editSurname.getText().toString(), editMark.getText().toString());
                        if(isUpdated==true){
                            Toast.makeText(MainActivity.this, "data was updated", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this, "data wasn't updated", Toast.LENGTH_SHORT).show();
                        }

                    }
                }
        );
    }

    public void DeleteData(){
        btnDeleteData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int noOfRowsDeleted= myDb.deleteData(editId.getText().toString());
                        if(noOfRowsDeleted==0){
                            Toast.makeText(MainActivity.this, "data wasn't deleted", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this, "data was deleted", Toast.LENGTH_SHORT).show();
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
                        boolean isInserted=myDb.insertData(editName.getText().toString(),editSurname.getText().toString(),
                                editMark.getText().toString());
                        if(isInserted==true){
                            Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this, "Data not inserted", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

    public void displayData(){
        btnDisplayData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Cursor res=myDb.getAllData();
                        if(res.getCount()==0){
                            showMessage("Error","No data present in database");
                            return;
                        }
                        StringBuffer buffer=new StringBuffer();
                        while(res.moveToNext()){
                            buffer.append("Id: "+res.getString(0)+"\n");
                            buffer.append("Name: "+res.getString(1)+"\n");
                            buffer.append("Surname: "+res.getString(2)+"\n");
                            buffer.append("Mark: "+res.getString(3)+"\n\n");
                        }
                        showMessage("data", buffer.toString());
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