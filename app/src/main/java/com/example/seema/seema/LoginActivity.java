package com.example.seema.seema;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    private AutoCompleteTextView usernameTv;
    private TextView passwordTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameTv = findViewById(R.id.user_name);
        passwordTv = findViewById(R.id.password);

        findViewById(R.id.email_sign_in_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        Button action_signup = findViewById(R.id.email_sign_up_button);
        action_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,LandingActivity.class));
            }
        });
    }

    public void login(){
        ParseUser.logInInBackground(usernameTv.getText().toString(),passwordTv.getText().toString(), new LogInCallback() {
            public void done(ParseUser user, ParseException e) {
                if (user != null) {
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                    // Hooray! The user is logged in.
                } else {
                    Log.e("Login Error",e.toString());
                    Toast.makeText(LoginActivity.this,e.toString(),Toast.LENGTH_SHORT).show();
                    // Signup failed. Look at the ParseException to see what happened.
                }
            }
        });
    }
}
