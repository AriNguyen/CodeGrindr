package com.example.codegrindr;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ChatUserListAdapter extends ArrayAdapter {

    //to reference the Activity
    private final Activity context;
    //to store the animal images
    private final Integer[] imageArray;
    //to store the list of countries
    private final String[] nameArray;
    //to store the list of countries
    private final String[] chatPreviewArray;
    // to store location of hackathon
    private final String[] timestampArray;

    public ChatUserListAdapter(Activity context, String[] nameArrayParam, String[] chatPreviewArrayParam, String[] timestampArrayParam, Integer[] imageArrayParam){

        super(context,R.layout.activity_chat_user_row , nameArrayParam);

        this.context=context;
        this.imageArray = imageArrayParam;
        this.nameArray = nameArrayParam;
        this.chatPreviewArray = chatPreviewArrayParam;
        this.timestampArray = timestampArrayParam;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.activity_chat_user_row, null,true);

        TextView nameTextField = (TextView) rowView.findViewById(R.id.chatUserName);
        TextView chatPreviewTextField = (TextView) rowView.findViewById(R.id.chatPreview);
        TextView timestampTextField = (TextView) rowView.findViewById(R.id.chatTimestamp);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.logoImageView);

        //this code sets the values of the objects to values from the arrays
        nameTextField.setText(nameArray[position]);
        chatPreviewTextField.setText(chatPreviewArray[position]);
        timestampTextField.setText(timestampArray[position]);
        imageView.setImageResource(imageArray[position]);
        return rowView;

    };
}
