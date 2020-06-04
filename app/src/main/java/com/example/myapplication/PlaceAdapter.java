package com.example.myapplication;


import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

import com.example.myapplication.model.Place;

import java.util.List;


public class PlaceAdapter  extends ArrayAdapter<Place>{


    private Context context;
    private List<Place> places;


    public PlaceAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Place> objects) {
        super(context, resource, objects);
        this.context = context;
        this.places = objects;
    }


    @Override
    public View getView(final int pos, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_place, parent, false);

        //TextView txtUserId = (TextView) rowView.findViewById(R.id.txtUserId);
        TextView placeTxt = (TextView) rowView.findViewById(R.id.place);

       // txtUserId.setText(String.format("#ID: %d", places.get(pos).getId()));
        if(places.get(pos).getContaminated() == 'Y'){
            placeTxt.setText(String.format("%s is contaminated", places.get(pos).getName()));
        }
        else if (places.get(pos).getContaminated() == 'S') {
            placeTxt.setText(String.format("%s is probably contaminated", places.get(pos).getName()));
        }



/*
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start Activity User Form
                Intent intent = new Intent(context, UserActivity.class);
                intent.putExtra("user_id", String.valueOf(users.get(pos).getId()));
                intent.putExtra("user_name", users.get(pos).getName());
                context.startActivity(intent);
            }
        });*/

        return rowView;
    }

}
