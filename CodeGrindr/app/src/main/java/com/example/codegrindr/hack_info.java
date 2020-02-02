package com.example.codegrindr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class hack_info extends AppCompatActivity {

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
    }
}
