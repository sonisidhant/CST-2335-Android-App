package com.example.sidhant.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sidhant on 2017-12-29.
 */

public class ListDataadapter extends ArrayAdapter {
    List list = new ArrayList();
    public ListDataadapter( Context context,  int resource) {
        super(context, resource);
    }

    static class LayoutHandler{
    TextView message;
        TextView Calories;
        TextView fat;
        TextView carbo;
        TextView id;
       }


    @Override
    public void add(Object o){
        super.add(o);
        list.add(o);
    }
    @Override
    public int getCount(){
      return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }


    @Override
    public View getView(int position, View convertView,ViewGroup parent) {

        View row = convertView;
        LayoutHandler layoutHandler;
        if(row == null){

            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.row_layout,parent,false);
            layoutHandler = new LayoutHandler();
            layoutHandler.message=(TextView) row.findViewById(R.id.text);
            layoutHandler.Calories=(TextView) row.findViewById(R.id.cal);
            layoutHandler.fat=(TextView) row.findViewById(R.id.fat);
            layoutHandler.carbo=(TextView) row.findViewById(R.id.carbo);
            layoutHandler.id=(TextView) row.findViewById(R.id.id1);

            row.setTag(layoutHandler);

        }else{
            layoutHandler=(LayoutHandler) row.getTag();
        }
        Chat chat = (Chat) this.getItem(position);
        layoutHandler.message.setText("FoodType: "+chat.getMessage());
        layoutHandler.Calories.setText("Cal: "+chat.getCalories());
        layoutHandler.fat.setText("Fat: "+ chat.getFat());
        layoutHandler.carbo.setText("Carbo: " + chat.getCarbohydates());
        layoutHandler.id.setText("ID: " + chat.get_id());

        return row;
    }
}

