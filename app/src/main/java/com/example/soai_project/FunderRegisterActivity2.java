package com.example.soai_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.soai_project.DataModel.FunderModel;
import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

public class FunderRegisterActivity2 extends AppCompatActivity {

    TextInputEditText summaryFunderET, websiteFunderET;
    String summaryFunderString, websiteFunderString;
    String categoryString, stageString;
    String firstname,lastname,Email,dob,city, pwd;
    String qualificationString, workExString,linkedinString;


    TextView nextRegFunder2;
    FunderModel funderModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funder_register_2);

        summaryFunderET=(TextInputEditText)findViewById(R.id.summaryFunderET);
        websiteFunderET=(TextInputEditText)findViewById(R.id.webLinkFunderET);

        summaryFunderString=summaryFunderET.getEditableText().toString().trim();
        websiteFunderString=websiteFunderET.getEditableText().toString().trim();

        nextRegFunder2=(TextView)findViewById(R.id.nextRegFunder2);


        firstname=getIntent().getStringExtra("fname");
        lastname=getIntent().getStringExtra("lname");
        Email=getIntent().getStringExtra("email");
        dob=getIntent().getStringExtra("pwd");
        city=getIntent().getStringExtra("dob");
        pwd=getIntent().getStringExtra("city");
        workExString=getIntent().getStringExtra("workex");
        qualificationString=getIntent().getStringExtra("qualification");
        linkedinString=getIntent().getStringExtra("linkedin");
        categoryString=getIntent().getStringExtra("categoryfunder");
        stageString=getIntent().getStringExtra("stagefunder");



        nextRegFunder2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate(summaryFunderET) && validate(websiteFunderET)) {
                    funderModel.setSummaryFunder(summaryFunderString);
                    funderModel.setWebsiteFunder(websiteFunderString);

                    Intent intent=new Intent(FunderRegisterActivity2.this, FunderRegisterActivity3.class);
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
                    intent.putExtra("categoryfunder",categoryString);
                    intent.putExtra("stagefunder",stageString);
                    intent.putExtra("summaryfunder",summaryFunderString);
                    intent.putExtra("websitefunder",websiteFunderString);

                    startActivity(intent);

                }
            }
        });


    }


//    public boolean validate(){
//        if(summaryFundertString!=null && websiteFunderString!=null){
//            return true;
//        }else{
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