package com.example.soai_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.soai_project.DataModel.FounderModel;
import com.google.android.material.textfield.TextInputEditText;

public class FounderRegisterActivity2 extends AppCompatActivity {

    TextInputEditText purposeET,ideaET,websiteET;
    String purposeString, ideaMoreString,websiteString;
    String ideaString,categoryFounderString,stageFounderString;
    String firstname,lastname,Email,dob,city, pwd;
    String qualificationString, workExString,linkedinString;

    TextView founderReg2;

    FounderModel founderModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_founder_register_2);

        purposeET = (TextInputEditText) findViewById(R.id.purposeET);
        ideaET = (TextInputEditText) findViewById(R.id.summaryET);
        websiteET = (TextInputEditText) findViewById(R.id.webLinkET);

        founderReg2=(TextView)findViewById(R.id.nextRegFounder2);


        purposeString = purposeET.getEditableText().toString().trim();
        ideaMoreString=ideaET.getEditableText().toString().trim();
        websiteString=websiteET.getEditableText().toString().trim();

        firstname=getIntent().getStringExtra("fname");
        lastname=getIntent().getStringExtra("lname");
        Email=getIntent().getStringExtra("email");
        dob=getIntent().getStringExtra("pwd");
        city=getIntent().getStringExtra("dob");
        pwd=getIntent().getStringExtra("city");
        workExString=getIntent().getStringExtra("workex");
        qualificationString=getIntent().getStringExtra("qualification");
        linkedinString=getIntent().getStringExtra("linkedin");
        ideaString=getIntent().getStringExtra("ideafounder");
        categoryFounderString=getIntent().getStringExtra("categoryfounder");
        stageFounderString=getIntent().getStringExtra("stagefounder");


        founderReg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate(purposeET) && validate(ideaET) && validate(websiteET)) {
                    founderModel.setPurposeFounder(purposeString);
                    founderModel.setIdeaDesFounder(ideaMoreString);
                    founderModel.setWebsiteFounder(websiteString);

                    Intent intent=new Intent(FounderRegisterActivity2.this,FounderRegisterActivity3.class);
                    intent.putExtra("role",getIntent().getStringExtra("role"));
                    intent.putExtra("fname",firstname);
                    intent.putExtra("lname",lastname);
                    intent.putExtra("email",Email);
                    intent.putExtra("pwd",pwd);
                    intent.putExtra("dob",dob);
                    intent.putExtra("city",city);
                    intent.putExtra("qualification",qualificationString);
                    intent.putExtra("workex",workExString);
                    intent.putExtra("linkedin",linkedinString);
                    intent.putExtra("ideafounder",ideaString);
                    intent.putExtra("categoryfounder",categoryFounderString);
                    intent.putExtra("stagefounder",stageFounderString);
                    intent.putExtra("purposefounder",purposeString);
                    intent.putExtra("ideamorefounder",ideaMoreString);
                    intent.putExtra("websitefounder",websiteString);
                    intent.putExtra("videouri",getIntent().getStringExtra("videouri"));
                    startActivity(intent);
                }
            }
        });


    }
//    public boolean validate(){
//        if(purposeString!=null && ideaString!=null && websiteString!=null){
//            return true;
//        }
//        else{
//            return false;
//        }
//    }

    public boolean validate(TextInputEditText editText)//validation of edittext
    {
        if (editText.getEditableText().toString().trim().length() > 0) {
            return true;
        }
        editText.setError("Please fill this");
        editText.requestFocus();
        return false;
    }

}