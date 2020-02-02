package com.example.codegrindr;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class ChatUserListActivity extends AppCompatActivity {

    Intent intent;

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
            R.drawable.circle_user_7,
            R.drawable.circle_user_8
    };

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_user);
        setTitle("Chat");

        final ImageView userImage = findViewById(R.id.userImage);

        ChatUserListAdapter whatever = new ChatUserListAdapter (this, chatUserNameArray, chatPreviewArray, chatTimestampArray, chatImageArray);
        listView = findViewById(R.id.chatUserListView);
        listView.setAdapter(whatever);

        userImage.setImageResource(userImageID);


        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        intent = new Intent(getApplicationContext(), RegisteredHackActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.navigation_dashboard:
                        intent = new Intent(getApplicationContext(), GroupDashboardActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.navigation_chat:
                        intent = new Intent(getApplicationContext(), ChatUserListActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });

    }
}
