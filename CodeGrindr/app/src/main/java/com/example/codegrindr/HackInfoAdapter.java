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

public class HackInfoAdapter extends ArrayAdapter {

    private final Activity context;
    private final Integer[] imageArray;
    private final String[] nameArray;
    private final String[] universityArray;
    private final String[] skillArray;


    public HackInfoAdapter(Activity context, String[] nameArrayParam, String[] universityArrayParam, Integer[] imageArrayParam, String[] skillArrayParam){

        super(context,R.layout.activity_hack_info_row , universityArrayParam);

        this.context=context;
        this.imageArray = imageArrayParam;
        this.nameArray = nameArrayParam;
        this.universityArray = universityArrayParam;
        this.skillArray = skillArrayParam;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.activity_hack_info_row, null,true);

        //this code gets references to objects in the activity_hack_info_row.xml file
        TextView nameTextField = (TextView) rowView.findViewById(R.id.memberUserName);
        TextView universityTextField = (TextView) rowView.findViewById(R.id.memberUniversity);
        TextView skillTextField = (TextView) rowView.findViewById(R.id.memberSkill);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);

        //this code sets the values of the objects to values from the arrays
        nameTextField.setText(nameArray[position]);
        imageView.setImageResource(imageArray[position]);
        universityTextField.setText(universityArray[position]);
        skillTextField.setText(skillArray[position]);
        return rowView;

    };
}

