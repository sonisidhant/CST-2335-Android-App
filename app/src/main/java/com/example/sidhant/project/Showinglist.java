package com.example.sidhant.project;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ProgressBar;

public class Showinglist extends AppCompatActivity {

    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    Main2Activity main2Activity;
    Cursor cursor;
    ListDataadapter listDataadapter;
    private boolean isFrameLoaded;
    private FrameLayout chatFrame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showinglist);

        listView = (ListView) findViewById(R.id.List);
        listDataadapter = new ListDataadapter(getApplicationContext(),R.layout.row_layout);
        listView.setAdapter(listDataadapter);
        main2Activity = new Main2Activity(getApplicationContext());
        sqLiteDatabase = main2Activity.getReadableDatabase();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {

                Object o = listView.getItemAtPosition(position);
                Chat str= (Chat) o;
                Bundle data = new Bundle();
                data.putString("messageText", str.getMessage());
                data.putString("Calories1",str.getCalories());
                data.putString("Carbohydrates",str.getCarbohydates());
                data.putString("Fats",str.getFat());
                data.putString("messageID", Integer.toString(position));
                data.putString("dataID", Long.toString(id));

                if(!isFrameLoaded) {        // phone
                    Intent intent = new Intent(Showinglist.this, MessageDetails.class);
                    intent.putExtras(data);
                    startActivityForResult(intent, 5);
                } else {                    // tablet
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    MessageFragment f = new MessageFragment(1);
                    f.setArguments(data);

                    ft.replace(R.id.chatFrame, f);
                    ft.commit();
                }
            }
        });

        chatFrame = (FrameLayout)findViewById(R.id.chatFrame);

        isFrameLoaded = (chatFrame != null);




        cursor = main2Activity.readMessages(sqLiteDatabase);
        if(cursor.moveToFirst()){
            do{
            String message;
                String calories;
                String fat;
                String carbs;
                long id;

               id= Long.parseLong(cursor.getString(0));
                message = cursor.getString(1);
                calories = cursor.getString(2);
                fat = cursor.getString(3);
                carbs = cursor.getString(4);

                Chat chat = new Chat(message,calories,fat,carbs,id);
                listDataadapter.add(chat);
            }while(cursor.moveToNext());
        }
    }



}
