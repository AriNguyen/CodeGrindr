package com.example.codegrindr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnSubmit = findViewById(R.id.loginButton);
        final EditText txtUserName = findViewById(R.id.emailEditText);
        final EditText txtPassword = findViewById(R.id.passEditText);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isEmpty(txtUserName)) {
                txtUserName.setError("You cannot leave this empty");
            }
            else if (isEmpty(txtPassword)) {
                txtPassword.setError("You cannot leave this empty");
            }
            else if (checkPasswordLeng(txtPassword)) {
                txtPassword.setError("Password length should be at least 10 characters");
                txtPassword.setText("");
            } else {
        //final TextView lblUserName = findViewById(R.id.lblUserName);
        //lblUserName.setText("Works!!");
                Intent FinshLogin = new Intent(getBaseContext(), RegisteredHackActivity.class);
                startActivity(FinshLogin);
            }
        }

        private boolean checkPasswordLeng(EditText passText) {
        if (passText.getText().toString().trim().length() >= 10)
            return false;
        return true;
        }

        private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;
        return true;
        }
        }
        );
    }
}

