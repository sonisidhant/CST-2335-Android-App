package com.example.sidhant.project;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Search extends AppCompatActivity {

    EditText Dispplay_Foodtype,Display_calories,Display_fats,Display_carbohydrates,searchfoodtype;
    TextView enterfoodtype,entercalories,enterfat,entercarbohydrates;
    Main2Activity db;
    SQLiteDatabase sqLiteDatabase;
    String id;Button button;
    Button button3;
    private ProgressBar spinner;
    Button button2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Dispplay_Foodtype = (EditText) findViewById(R.id.display);
        Display_calories = (EditText) findViewById(R.id.calories);
        Display_fats = (EditText) findViewById(R.id.editText2);
        Display_carbohydrates = (EditText) findViewById(R.id.editText);
        spinner = (ProgressBar)findViewById(R.id.progressBar1);
        enterfoodtype = (TextView) findViewById(R.id.EnterFoodType);
        entercalories = (TextView) findViewById(R.id.Calories);
        enterfat = (TextView) findViewById(R.id.Fat);
        entercarbohydrates = (TextView) findViewById(R.id.Carbohydrates);


        searchfoodtype=(EditText) findViewById(R.id.FoodType);

        button=(Button) findViewById(R.id.button);
        button2=(Button) findViewById(R.id.button2);

        button3=(Button) findViewById(R.id.button3);

        Dispplay_Foodtype.setVisibility(View.GONE);
        Display_calories.setVisibility(View.GONE);
        Display_fats.setVisibility(View.GONE);
        Display_carbohydrates.setVisibility(View.GONE);

        enterfoodtype.setVisibility(View.GONE);
        entercalories.setVisibility(View.GONE);
        enterfat.setVisibility(View.GONE);
        entercarbohydrates.setVisibility(View.GONE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner.setVisibility(View.VISIBLE);

                search();

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();       }
        });

    }

    public void search(){
        id= searchfoodtype.getText().toString();
        spinner.setVisibility(View.GONE);

        db=new Main2Activity(getApplicationContext());
        sqLiteDatabase=db.getReadableDatabase();
        Cursor cursor = db.getContact(id,sqLiteDatabase);
        if(cursor.moveToFirst())
        {
            String food = cursor.getString(1);
            String calories = cursor.getString(2);
            String fats1 = cursor.getString(3);
            String carbohydrates = cursor.getString(4);


            Dispplay_Foodtype.setText(food);
            Display_calories.setText(calories);
            Display_fats.setText(fats1);
            Display_carbohydrates.setText(carbohydrates);
            Display_calories.setVisibility(View.VISIBLE);
            Dispplay_Foodtype.setVisibility(View.VISIBLE);
            Display_fats.setVisibility(View.VISIBLE);
            Display_carbohydrates.setVisibility(View.VISIBLE);

            enterfoodtype.setVisibility(View.VISIBLE);
            entercalories.setVisibility(View.VISIBLE);
            enterfat.setVisibility(View.VISIBLE);
            entercarbohydrates.setVisibility(View.VISIBLE);
        }
    }
public void delete(){
    db=new Main2Activity(getApplicationContext());
    sqLiteDatabase=db.getReadableDatabase();
    db.deletemessages(id,sqLiteDatabase);
}
public void update(){
    db=new Main2Activity(getApplicationContext());
    sqLiteDatabase=db.getWritableDatabase();
    String foodtype1;
    String calories;
    String fats;
    String carbohydrates;


    foodtype1=Dispplay_Foodtype.getText().toString();
    calories=Display_calories.getText().toString();
    fats=Display_fats.getText().toString();
    carbohydrates=Display_carbohydrates.getText().toString();

    db.update(id,foodtype1,calories,fats,carbohydrates,sqLiteDatabase);

}
    public void toastmessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
