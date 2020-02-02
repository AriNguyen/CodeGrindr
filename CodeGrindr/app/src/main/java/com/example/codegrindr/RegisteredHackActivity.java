package com.example.codegrindr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class RegisteredHackActivity extends AppCompatActivity {

    Intent intent;

    public void showUserInfo(View view) {
        Intent intent = new Intent(getApplicationContext(), UserProfile.class);
        startActivity(intent);
    }
    public void showHackInfo(View view) {
        Intent intent = new Intent(getApplicationContext(), hack_info.class);
        startActivity(intent);
    }

    public void searchHack(View view) {
        Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
        startActivity(intent);
    }

    String userName = "Nom Phan";
    String[] hackathonNameArray = {
            "Hoya Hacks",
            "TechTogether",
            "Make Harvard",
            "DragonHacks"};

    String[] dateArray = {
            "Jan 31st - Feb 2nd 2020",
            "Jan 31st - Feb 2nd 2020",
            "Feb 1st - Feb 2nd 2020",
            "Feb 22nd - Feb 23rd 2020"
    };

    String[] locationArray = {
            "Washington DC, US",
            "Boston MA, US",
            "Boston MA, US",
            "Philadelphia PA, US"
    };

    Integer[] imageArray = {
            R.drawable.hoya,
            R.drawable.techtogether,
            R.drawable.makeharvard,
            R.drawable.dragonhacks
    };

    ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered_hack);

        final TextView user_name = findViewById(R.id.user_name);

        CustomListAdapter arrayAdapter = new CustomListAdapter(this, hackathonNameArray, dateArray, locationArray, imageArray);
        listView = findViewById(R.id.registered_hackathon);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                showHackInfo(view);
            }
        });

        user_name.setText(userName);

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
