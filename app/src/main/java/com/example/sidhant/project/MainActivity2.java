package com.example.sidhant.project;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import java.util.Calendar;
import java.util.Date;

public class MainActivity2 extends AppCompatActivity {
    private EditText editTextChat ;
    private EditText editTextChat1 ;
    private EditText editTextChat2 ;
    private EditText editTextChat3 ;

    Context context=this;
    SQLiteDatabase sqLiteDatabase;
    Main2Activity db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editTextChat = (EditText) findViewById(R.id.textChat);
        editTextChat1 = (EditText) findViewById(R.id.Calories);
        editTextChat2 = (EditText) findViewById(R.id.Fat);
        editTextChat3 = (EditText) findViewById(R.id.carbs);

    }

    public void add(View view){
        String foodtype = editTextChat.getText().toString();
        String  calories = editTextChat1.getText().toString();
        String  fat = editTextChat2.getText().toString();
        String  carbo = editTextChat3.getText().toString();
        String currentDate;
        String dt;
        Date cal = (Date) Calendar.getInstance().getTime();
        dt = cal.toLocaleString();
        currentDate=dt.toString();
        db= new Main2Activity(context);
        sqLiteDatabase=db.getWritableDatabase();
        db.addproduct(foodtype,calories,fat,carbo,currentDate,sqLiteDatabase);
        editTextChat.setText("");
        editTextChat1.setText("");
        editTextChat2.setText("");
        editTextChat3.setText("");
        toastmessage("Data Inserted");
        db.close();
    }
public void ViewContact(View view){
    Intent intent = new Intent(this,Showinglist.class);
    startActivity(intent);
}

    public void b(View view){
        Intent intent = new Intent(this,Search.class);
        startActivity(intent);
    }
    private void toastmessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }


}

