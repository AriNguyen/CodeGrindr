package com.example.codegrindr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InformationActivity extends AppCompatActivity {

    public void showRegisteredHackActivity() {
        Intent intent = new Intent(getApplicationContext(), RegisteredHackActivity.class);
        startActivity(intent);
    }

    public void gettingStarted(View view) {
        showRegisteredHackActivity();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
    }
}
