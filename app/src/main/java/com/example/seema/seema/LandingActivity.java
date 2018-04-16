package com.example.seema.seema;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class LandingActivity extends AppCompatActivity {
    private boolean fan = false;
    private boolean artist = false;
    private boolean org = false;

    private LinearLayout buttons;
    private ScrollView form;

    private AutoCompleteTextView emailTv;
    private AutoCompleteTextView nameTv;
    private AutoCompleteTextView surnameTv;
    private AutoCompleteTextView genderTv;
    private AutoCompleteTextView dobTv;
    private AutoCompleteTextView usernameTv;
    private AutoCompleteTextView stage_nameTv;
    private AutoCompleteTextView art_typeTv;
    private EditText passwordEt;
    private Button signupBtn;

    private Button fanBtn;
    private Button artistBtn;
    private Button organiserBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        emailTv = findViewById(R.id.email);
        nameTv = findViewById(R.id.name);
        surnameTv = findViewById(R.id.surname);
        genderTv = findViewById(R.id.gender);
        dobTv = findViewById(R.id.dob);
        usernameTv = findViewById(R.id.username);
        stage_nameTv = findViewById(R.id.stage_name);
        art_typeTv = findViewById(R.id.art_type);
        passwordEt = findViewById(R.id.password);
        signupBtn = findViewById(R.id.sign_up_button);

        buttons = findViewById(R.id.buttons);
        form = findViewById(R.id.signup_form);



        fanBtn = findViewById(R.id.fan);
        artistBtn = findViewById(R.id.artist);
        organiserBtn = findViewById(R.id.organiser);

        fanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttons.setVisibility(View.GONE);
                form.setVisibility(View.VISIBLE);
                art_typeTv.setVisibility(View.GONE);
                stage_nameTv.setVisibility(View.GONE);
            }
        });

        artistBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                artist=true;

                buttons.setVisibility(View.GONE);
                form.setVisibility(View.VISIBLE);

            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup();
            }
        });

        organiserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttons.setVisibility(View.GONE);
                form.setVisibility(View.VISIBLE);
                art_typeTv.setVisibility(View.GONE);
                stage_nameTv.setVisibility(View.GONE);
            }
        });



// other fields can be set just like with ParseObject

    }

    public void signup(){
        ParseUser user = new ParseUser();
        user.setUsername(usernameTv.getText().toString());
        Log.e("uname",usernameTv.getText().toString());
        user.setPassword(passwordEt.getText().toString());
        user.setEmail(emailTv.getText().toString());
        user.put("first_name",nameTv.getText().toString());
        user.put("surname",surnameTv.getText().toString());
        user.put("gender",genderTv.getText().toString());
        if(artist){
            user.put("stage_name",stage_nameTv.getText().toString());
            user.put("art_type",stage_nameTv.getText().toString());
        }

        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    Log.e("Hooray","Signup Done");
                    startActivity(new Intent(LandingActivity.this,MainActivity.class));
                    // Hooray! Let them use the app now.
                } else {
                    Log.e("Honay",e.toString());
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                }
            }
        });
    }
}
