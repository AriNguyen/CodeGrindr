package com.example.codegrindr;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class ChatUserListActivity extends AppCompatActivity {

    Integer userImageID = R.drawable.profile;
    String[] chatUserNameArray = {
            "Laurie Amway",
            "Rahul Sharma",
            "Scott Pilgrim"};
    String[] chatPreviewArray = {
            "Shall we meet again today?",
            "Shall we meet again tonight?",
            "Shall we meet again tomorrow?"};
    String[] chatTimestampArray = {
            "9:40 AM",
            "3:27 PM",
            "8:37 PM"
    };
    Integer[] chatImageArray = {
            R.drawable.circle_user,
            R.drawable.circle_user,
            R.drawable.circle_user
    };

    ListView listView;



//    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_user);
        setTitle("Chat");

        final ImageView userImage = findViewById(R.id.userImage);

        ChatUserListAdapter whatever = new ChatUserListAdapter (this, chatUserNameArray, chatPreviewArray, chatTimestampArray, chatImageArray);
        listView = (ListView) findViewById(R.id.chatUserListView);
        listView.setAdapter(whatever);

        userImage.setImageResource(userImageID);

    }
}
