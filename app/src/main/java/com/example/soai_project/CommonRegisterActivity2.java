package com.example.soai_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.soai_project.Founderr1.CommonData;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
import java.util.List;

public class CommonRegisterActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    MaterialTextView qualificationTV;
    EditText workExET, linkedinET;
    String qualificationString, workExString,linkedinString;
    CommonData commonData;
    TextView nextReg2;
    String role;

    String firstname,lastname,Email,dob,city, pwd;

    List<String> categories;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_register_2);

        commonData=new CommonData();
        categories = new ArrayList<String>();
        final Spinner spinnerQ=(Spinner)findViewById(R.id.spinnerQualification);
        nextReg2=(TextView)findViewById(R.id.nextReg2);

        spinnerQ.setOnItemSelectedListener(this);
        categories.add("High School Diploma");
        categories.add("Bachelor's Degree");
        categories.add("Master's Degree");
        categories.add("PHD Doctorate");
        categories.add("Dropout");
        categories.add("No Specification");


        //Creating Spinner adapter
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, categories);

        //Drop down list
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerQ.setAdapter(dataAdapter);

        workExET=(EditText)findViewById(R.id.summaryET);
        linkedinET=(EditText)findViewById(R.id.linkedinET);

        qualificationTV=(MaterialTextView)findViewById(R.id.qualificationTV);


//        qualificationTV.setText(spinnerQ.getSelectedItem().toString());

        qualificationString=String.valueOf(spinnerQ.getSelectedItem());
        workExString=workExET.getEditableText().toString().trim();
        linkedinString=linkedinET.getEditableText().toString().trim();

        role=getIntent().getStringExtra("role");

        //Getting CommonRegister1 data
        firstname=getIntent().getStringExtra("fname");
        lastname=getIntent().getStringExtra("lname");
        Email=getIntent().getStringExtra("email");
        dob=getIntent().getStringExtra("pwd");
        city=getIntent().getStringExtra("dob");
        pwd=getIntent().getStringExtra("city");


        nextReg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate(workExET) && validate(linkedinET)) {
                    commonData.setQualificatioNCommon(qualificationString);
                    commonData.setWorkExCommon(workExString);
                    commonData.setLinkedinCommon(linkedinString);

                    if(role.equals("founder")) {
                        Intent intent = new Intent(CommonRegisterActivity2.this, FounderRegisterActivity1.class);
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
                        startActivity(intent);
                    } else{
                        Intent intent = new Intent(CommonRegisterActivity2.this, FunderRegisterActivity1.class);
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
                        startActivity(intent);
                    }

                }
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();

        qualificationTV.setText(item);
    }

    public void onNothingSelected(AdapterView<?> arg0) {


    }


    public boolean validate(EditText editText)//validation of edittext
    {
        if (editText.getText().toString().trim().length() > 0) {
            return true;
        }
        editText.setError("Please fill this");
        editText.requestFocus();
        return false;
    }
}