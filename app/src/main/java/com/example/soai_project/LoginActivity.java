package com.example.soai_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    TextView loginbutton, signUpBtn;
    TextInputLayout nameIL, pwdIL;
    TextInputEditText nameET,pwdET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginbutton=findViewById(R.id.loginBtn);
        signUpBtn=(TextView)findViewById(R.id.btnSignUp);
        nameIL=(TextInputLayout) findViewById(R.id.inputEmail);
        pwdIL=(TextInputLayout) findViewById(R.id.pwd);
        nameET=(TextInputEditText)findViewById(R.id.emailET);
        pwdET=(TextInputEditText)findViewById(R.id.pwdET);


        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            if (loginCheck()) {

                Intent intent = new Intent(LoginActivity.this, Pitch_video.class);
                startActivity(intent);
            }

            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });



    }



    public boolean loginCheck(){
        if (nameET.getText().toString().trim().length()>0){
            return true;
        } else{
            nameET.setError("Please fill this");
            nameET.requestFocus();
            return false;
        }
    }
}