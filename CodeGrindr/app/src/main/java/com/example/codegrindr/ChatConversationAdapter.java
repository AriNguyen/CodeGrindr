package com.example.codegrindr;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;

public class ChatConversationAdapter extends ArrayAdapter {

    //to reference the Activity
    private final Activity context;
    //to store the animal images
    private final Integer[] imageArray;
    //to store the list of countries
    private final String[] messageContentArray;

    public ChatConversationAdapter(Activity context, String[] messageContentArrayParam, Integer[] imageArrayParam){

        super(context,R.layout.activity_chat_conversation_row , messageContentArrayParam);

        this.context=context;
        this.imageArray = imageArrayParam;
        this.messageContentArray = messageContentArrayParam;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.activity_registered_hackathon_row, null,true);

        //this code gets references to objects in the activity_registered_hackathon_row.xml file
        TextView nameTextField = (TextView) rowView.findViewById(R.id.hackathon_name);
        TextView dateTextField = (TextView) rowView.findViewById(R.id.hackathon_date);
        TextView locationTextField = (TextView) rowView.findViewById(R.id.hackathon_location);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);

        //this code sets the values of the objects to values from the arrays
        nameTextField.setText(messageContentArray[position]);
        imageView.setImageResource(imageArray[position]);
        return rowView;

    };
}

