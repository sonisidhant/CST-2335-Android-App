package com.example.sidhant.project;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class MessageFragment extends Fragment {

    private int deviceType;

    public MessageFragment() {
        deviceType = 0;
    }

    public MessageFragment(int d) {
        deviceType = d;
    }
private Main2Activity main2Activity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_fragment, container, false);

        final Bundle data = this.getArguments();

        TextView messageText = (TextView)v.findViewById(R.id.messageText);
        TextView messageID = (TextView)v.findViewById(R.id.messageID);
        TextView Calories = (TextView)v.findViewById(R.id.Calories);
        TextView Carbohydrates = (TextView)v.findViewById(R.id.Carbohydrates);
        TextView Fats = (TextView)v.findViewById(R.id.Fats);

        final int id = Integer.parseInt(data.getString("messageID"));
        final long dataid = Long.parseLong(data.getString("dataID"));

        messageText.setText("Food Type: "+ data.getString("messageText"));
        messageID.setText("ID: "+data.getString("dataID"));
        Calories.setText("Calories: "+data.getString("Calories1"));
        Carbohydrates.setText("Carbohydrates: " +data.getString("Carbohydrates"));
        Fats.setText("Fats: " +data.getString("Fats"));




        return v;
    }
}
