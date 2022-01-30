package com.example.soai_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.soai_project.DataModel.FunderModel;
import com.example.soai_project.Retrofit.APIService;
import com.example.soai_project.Retrofit.Api;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.JsonObject;

import org.json.JSONException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FunderRegisterActivity3 extends AppCompatActivity {


    public JsonObject jsonObject;
    public JsonObject  user;
    public JsonObject  PersonalDetails;
    public JsonObject  ProfessionalDetails;
    APIService apiService;

    TextInputEditText payableAmtFunderET, returnNetInvFunderET;
    String payableAmtFunderString, returnNetInvFunderString;
    String summaryFunderString, websiteFunderString;
    String categoryString, stageString;
    String firstname,lastname,Email,dob,city, pwd;
    String qualificationString, workExString,linkedinString;

    TextView finishFunderReg;

    FunderModel funderModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funder_register_3);

        payableAmtFunderET=(TextInputEditText)findViewById(R.id.payableAmtET);
        returnNetInvFunderET=(TextInputEditText)findViewById(R.id.returnonInvestmentET);

        finishFunderReg=(TextView)findViewById(R.id.finishRegFunder);

        payableAmtFunderString=payableAmtFunderET.getEditableText().toString().trim();
        returnNetInvFunderString=returnNetInvFunderET.getEditableText().toString().trim();





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
        summaryFunderString=getIntent().getStringExtra("summaryfunder");;
        websiteFunderString=getIntent().getStringExtra("websitefunder");;


        apiService= Api.getRetrofitInstance().create(APIService.class);


        finishFunderReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate(payableAmtFunderET) && validate(returnNetInvFunderET)) {
                    funderModel.setPayableAmtFunder(payableAmtFunderString);
                    funderModel.setReturnNetInvFunder(returnNetInvFunderString);

                    createPost();

                    Intent intent=new Intent(FunderRegisterActivity3.this,Pitch_video.class);
                }


            }
        });

    }

    public boolean validate(TextInputEditText editText)//validation of edittext
    {
        if (editText.getEditableText().toString().trim().length() > 0) {
            return true;
        }
        editText.setError("Please fill this");
        editText.requestFocus();
        return false;
    }

    private void createPost() {

        user=new JsonObject();
        user.addProperty("Email",Email);
        user.addProperty("Contact","some number");
        user.addProperty("Password",pwd);
        user.addProperty("User_type",getIntent().getStringExtra("role"));
        user.addProperty("Team_ID","someId");

        PersonalDetails=new JsonObject();
        PersonalDetails.addProperty("First_Name",firstname);
        PersonalDetails.addProperty("Last_Name",lastname);
        PersonalDetails.addProperty("Bio",lastname);
        PersonalDetails.addProperty("Date_Of_Birth",dob);
        PersonalDetails.addProperty("City",city);

        ProfessionalDetails=new JsonObject();
        ProfessionalDetails.addProperty("Qualification",qualificationString);
        ProfessionalDetails.addProperty("Level_Of_Education",workExString);
        ProfessionalDetails.addProperty("LinkedIn",linkedinString);
        ProfessionalDetails.addProperty("Type_of_Investor","sometype");

        jsonObject=new JsonObject();
        jsonObject.add("user",user);
        jsonObject.add("PersonalDetails",PersonalDetails);
        jsonObject.add("ProfessionalDetails",ProfessionalDetails);





        Call<JsonObject> call= apiService.founderregisteraddedsuccessfully(jsonObject);

        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {


                Toast.makeText(FunderRegisterActivity3.this, "Succesfully created", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

                Toast.makeText(FunderRegisterActivity3.this, "Registration Failed", Toast.LENGTH_SHORT).show();

            }
        });
    }

}