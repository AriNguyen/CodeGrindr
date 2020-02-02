package com.example.codegrindr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class hack_info extends AppCompatActivity {

    Intent intent;

    public void showDashboard() {
        Intent intent = new Intent(getApplicationContext(), GroupDashboardActivity.class);
        startActivity(intent);
    }

    public void addMember(View view) {
        showDashboard();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hack_info);

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
