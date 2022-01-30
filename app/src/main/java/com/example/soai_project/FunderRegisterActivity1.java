package com.example.soai_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.soai_project.DataModel.FunderModel;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class FunderRegisterActivity1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView categoryFunderTV;
    TextView stageFunderTV;
    TextView nextRegFunder1;



//    TextInputEditText categoryET,stageET;
    String categoryString, stageString;
    String firstname,lastname,Email,dob,city, pwd;
    String qualificationString, workExString,linkedinString;


    FunderModel funderModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funder_register_1);



      //  funderModel=new FunderModel();

        categoryFunderTV=(TextView)findViewById(R.id.categoryFunderTV);
        stageFunderTV=(TextView)findViewById(R.id.stageFunderTV);

        nextRegFunder1=(TextView)findViewById(R.id.nextRegFunder1);

        final Spinner spinnerFunderC=(Spinner)findViewById(R.id.spinnerFunderCategory);
        final Spinner spinnerFunderS=(Spinner)findViewById(R.id.spinnerFunderStage);

        spinnerFunderC.setOnItemSelectedListener(this);
        spinnerFunderS.setOnItemSelectedListener(this);

        List<String> categoriesFunder = new ArrayList<String>();
        categoriesFunder.add("Agricultural Sector");
        categoriesFunder.add("Industrial Automation");
        categoriesFunder.add("Software");
        categoriesFunder.add("Embedded Electronics");
        categoriesFunder.add("Electrical Appliance");
        categoriesFunder.add("Other(Please specify)");

        List<String> stagesFunder=new ArrayList<String>();
        stagesFunder.add("Beginner Stage");
        stagesFunder.add("Intermediate Stage");
        stagesFunder.add("Advanced Stage");

        //Creating Spinner adapter
        ArrayAdapter<String> categoriesFunderAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, categoriesFunder);

        //Drop down list
        categoriesFunderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerFunderC.setAdapter(categoriesFunderAdapter);

        ArrayAdapter<String> stageFunderAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, stagesFunder);
        stageFunderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFunderS.setAdapter(stageFunderAdapter);

       categoryString = String.valueOf(spinnerFunderC.getSelectedItem());
       stageString = String.valueOf(spinnerFunderS.getSelectedItem());


        firstname=getIntent().getStringExtra("fname");
        lastname=getIntent().getStringExtra("lname");
        Email=getIntent().getStringExtra("email");
        dob=getIntent().getStringExtra("pwd");
        city=getIntent().getStringExtra("dob");
        pwd=getIntent().getStringExtra("city");
        workExString=getIntent().getStringExtra("workex");
        qualificationString=getIntent().getStringExtra("qualification");
        linkedinString=getIntent().getStringExtra("linkedin");


        nextRegFunder1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()) {
                    funderModel.setCategoryFunder(categoryString);
                    funderModel.setStageFunder(stageString);

                    Intent intent=new Intent(FunderRegisterActivity1.this,FunderRegisterActivity2.class);
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
                    startActivity(intent);
                }
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();

        if (parent.getId()==R.id.spinnerCategory){
            categoryFunderTV.setText(item);
        }
        if(parent.getId()==R.id.spinnerStage){
            stageFunderTV.setText(item);
        }
    }

    public void onNothingSelected(AdapterView<?> arg0) {


    }

    public boolean validate(){
        if(categoryString!=null && stageString!=null){
            return true;
        }else{
            return false;
        }
    }
//    public boolean validate(TextInputEditText editText)//validation of edittext
//    {
//        if (editText.getEditableText().toString().trim().length() > 0) {
//            return true;
//        }
//        editText.setError("Please fill this");
//        editText.requestFocus();
//        return false;
//    }
}
