package com.example.codegrindr;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter {
    //to reference the Activity
    private final Activity context;
    public CustomListAdapter(Activity context, String[] nameArrayParam, String[] dateArrayParam, String[] locationArrayParam, Integer[] imageIDArrayParam){

        super(context,R.layout.activity_registered_hackathon_row , nameArrayParam);

        this.context=context;
        this.imageIDarray = imageIDArrayParam;
        this.nameArray = nameArrayParam;
        this.infoArray = dateArrayParam;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.activity_registered_hackathon_row, null,true);

        //this code gets references to objects in the activity_registered_hackathon_row.xml file
        TextView nameTextField = (TextView) rowView.findViewById(R.id.hackathon_name);
        TextView infoTextField = (TextView) rowView.findViewById(R.id.hackathon_date);
        TextView locationTextField = (TextView) rowView.findViewById(R.id.hackathon_location);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);

        //this code sets the values of the objects to values from the arrays
        nameTextField.setText(nameArray[position]);
        infoTextField.setText(infoArray[position]);
        imageView.setImageResource(imageIDarray[position]);
        return rowView;

    };

    //to store the animal images
    private final Integer[] imageIDarray;

    //to store the list of countries
    private final String[] nameArray;

    //to store the list of countries
    private final String[] infoArray;
}
