package com.example.codegrindr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Write a message to the database
        // Write a message to the database
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");
        Log.i("Success",  "Send to Server");


        final Button loginButton = findViewById(R.id.loginButton);
        final TextView signUpTextView = findViewById(R.id.signUpTextView);
        final EditText emailEditText = findViewById(R.id.emailEditText);
        final EditText passEditText = findViewById(R.id.passEditText);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmpty(emailEditText)) {
                    emailEditText.setError("You cannot leave this empty");
                }
                else if (isEmpty(passEditText)) {
                    passEditText.setError("You cannot leave this empty");
                }
                else if (checkPasswordLeng(passEditText)) {
                    passEditText.setError("Password length should be at least 10 characters");
                    passEditText.setText("");
                } else {
            //final TextView lblUserName = findViewById(R.id.lblUserName);
            //lblUserName.setText("Works!!");
                    Intent FinishLogin = new Intent(getBaseContext(), RegisteredHackActivity.class);
                    startActivity(FinishLogin);
                }
            }

            private boolean checkPasswordLeng(EditText passText) {
                if (passText.getText().toString().trim().length() >= 10) return false;
                return true;
            }

            private boolean isEmpty(EditText etText) {
                if (etText.getText().toString().trim().length() > 0) return false;
                return true;
            }
        });

        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent goToSignUp = new Intent(getBaseContext(), SignUpActivity.class);
                startActivity(goToSignUp);
            }
        });
    }
}

