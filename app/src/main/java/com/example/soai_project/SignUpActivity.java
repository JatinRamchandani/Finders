package com.example.soai_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.soai_project.Founderr1.CommonRegisterActivity1;

import org.w3c.dom.Text;

public class SignUpActivity extends AppCompatActivity {

    TextView funderBtn, founderBtn;
    String funder="Funder";
    String founder="Founder";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        funderBtn=(TextView)findViewById(R.id.funderTv);
        founderBtn=(TextView)findViewById(R.id.founderTV);



        funderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUpActivity.this, CommonRegisterActivity1.class);
                intent.putExtra("role",funder);
                startActivity(intent);
            }
        });

        founderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUpActivity.this, CommonRegisterActivity1.class);
                intent.putExtra("role",founder);
                startActivity(intent);
            }
        });
    }
}