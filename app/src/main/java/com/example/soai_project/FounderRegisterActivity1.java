package com.example.soai_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


import com.example.soai_project.DataModel.FounderModel;
import com.example.soai_project.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
import java.util.List;

public class FounderRegisterActivity1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private static final int SELECT_VIDEO_REQUEST = 1234;
    TextView categoryTV;
    TextView stageTV;
    String ideaString,categoryFounderString,stageFounderString;
    String firstname,lastname,Email,dob,city, pwd;
    String qualificationString, workExString,linkedinString;

    private TextView pitchVideo;
    private ImageView choose;


    private Intent intent;


    Uri fileUri;

    FounderModel founderModel;

    EditText ideaName;
    MaterialTextView categoryFounder,stageFounder;
    TextView founderReg1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_founder_register_1);



        ideaName=(EditText)findViewById(R.id.nameTitleET);
        categoryFounder=(MaterialTextView)findViewById(R.id.categoryTV);
        stageFounder=(MaterialTextView)findViewById(R.id.stageTV);
        pitchVideo=findViewById(R.id.pitchupload);


        choose=findViewById(R.id.pitchvideo);
        choose.setOnClickListener(this);

        founderReg1=(TextView)findViewById(R.id.nextRegFounder1);



        final Spinner spinnerC=(Spinner)findViewById(R.id.spinnerCategory);
        final Spinner spinnerS=(Spinner)findViewById(R.id.spinnerStage);

        spinnerC.setOnItemClickListener((AdapterView.OnItemClickListener) this);
        spinnerS.setOnItemClickListener((AdapterView.OnItemClickListener) this);

        List<String> categories = new ArrayList<String>();
        categories.add("Agricultural Sector");
        categories.add("Industrial Automation");
        categories.add("Software");
        categories.add("Embedded Electronics");
        categories.add("Electrical Appliance");
        categories.add("Other(Please specify)");

        List<String> stages=new ArrayList<String>();
        stages.add("Beginner Stage");
        stages.add("Intermediate Stage");
        stages.add("Advanced Stage");

        //Creating Spinner adapter
        ArrayAdapter<String> categoriesAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, categories);

        //Drop down list
        categoriesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerC.setAdapter(categoriesAdapter);

        ArrayAdapter<String> stageAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, stages);
        stageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerS.setAdapter(stageAdapter);

        ideaString=ideaName.getEditableText().toString().trim();
        categoryFounderString=String.valueOf(spinnerC.getSelectedItem());
        stageFounderString=String.valueOf(spinnerS.getSelectedItem());

        firstname=getIntent().getStringExtra("fname");
        lastname=getIntent().getStringExtra("lname");
        Email=getIntent().getStringExtra("email");
        dob=getIntent().getStringExtra("pwd");
        city=getIntent().getStringExtra("dob");
        pwd=getIntent().getStringExtra("city");
        workExString=getIntent().getStringExtra("workex");
        qualificationString=getIntent().getStringExtra("qualification");
        linkedinString=getIntent().getStringExtra("linkedin");


        founderReg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate(ideaName)) {
                    founderModel.setIdeaFounder(ideaString);
                    founderModel.setCategoryFounder(categoryFounderString);
                    founderModel.setStageFounder(stageFounderString);

                    intent=new Intent(FounderRegisterActivity1.this,FounderRegisterActivity2.class);
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
                    startActivity(intent);
                }
            }
        });

        if(validate(ideaName)) {
            founderModel.setIdeaFounder(ideaString);
            founderModel.setCategoryFounder(categoryFounderString);
            founderModel.setStageFounder(stageFounderString);
        }
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();

        if (parent.getId()==R.id.spinnerCategory){
            categoryTV.setText(item);
        }
        if(parent.getId()==R.id.spinnerStage){
            stageTV.setText(item);
        }
    }

    public void onNothingSelected(AdapterView<?> arg0) {


    }

//    public void sendData(){
//        if (ideaString!=null && stageFounderString!=null && categoryFounderString!=null) {
//
//            Intent i = new Intent(getBaseContext(), DataModel.class);
//            i.putExtra("ideaFounder",ideaString);
//            i.putExtra("stageFounder",stageFounderString);
//            i.putExtra("categoryFounder",categoryFounderString);
//        }
//    }

    public boolean checkData(){
        if (ideaString!=null && stageFounderString!=null && categoryFounderString!=null) {
            return true;
        }else{
            return false;
        }
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

    @Override
    public void onClick(View v) {

        showChoosingFile();

    }


    private void showChoosingFile() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("video/*");
        startActivityForResult(
                Intent.createChooser(intent, "Complete action using"),
                SELECT_VIDEO_REQUEST);
    }


    @ Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == SELECT_VIDEO_REQUEST) {
            fileUri = data.getData();
            pitchVideo.setText(fileUri.toString());
            intent.putExtra("videouri",pitchVideo.getText().toString());


        }
    }
}