package com.example.sidhant.project;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TestToolbar extends AppCompatActivity {
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_toolbar);

b = (Button)findViewById(R.id.Button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openmainactivity();
            }
        });
    }

     public boolean onCreateOptionsMenu (Menu m){
         MenuInflater menuInflater = getMenuInflater();
         menuInflater.inflate(R.menu.toolbar_menu2, m );
         return true;
     }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_one:
                Log.d("Toolbar", "Option 1 selected");
                planeDialog();
            case R.id.action_two:
                Log.d("Toolbar", "Option 2 selected");
                openDialog();
                return true;
            case R.id.action_three:
                String name4 = ("Click here to add button to start activity");
                Context context1 = getApplicationContext();
                int duration1 = Toast.LENGTH_SHORT;
                Toast toast1 = Toast.makeText(context1, name4, duration1);
                toast1.show();
                return true;
            case R.id.action_about:
                String name = ("Version 1.0, by Sidhant Soni");
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, name, duration);
                toast.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void openmainactivity(){
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }
    private void planeDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("You selected item 1");
        // Add the buttons
        builder.setPositiveButton(R.string.buttonOk, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        builder.setNegativeButton(R.string.buttonCancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        // Create the AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    private void openDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.dialogTitle);
        // Add the buttons
        builder.setPositiveButton(R.string.buttonOk, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        builder.setNegativeButton(R.string.buttonCancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        // Create the AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
