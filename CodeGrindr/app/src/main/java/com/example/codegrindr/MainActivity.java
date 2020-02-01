package com.example.codegrindr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public void showSignUpPage() {
        Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
        startActivity(intent);
    }

    public void showRegisteredHackActivity() {
        Intent intent = new Intent(getBaseContext(), RegisteredHackActivity.class);
        startActivity(intent);
    }

    public void logIn(View view) {
        showRegisteredHackActivity();
    }

    public void signUp(View view) {
        showSignUpPage();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
