package com.example.soai_project.Founderr1;

import androidx.appcompat.app.AppCompatActivity;
import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.soai_project.CommonRegisterActivity2;
import com.example.soai_project.R;
import com.example.soai_project.Retrofit.APIClient;
import com.example.soai_project.Retrofit.APIService;
import com.google.android.material.textfield.TextInputEditText;

public class CommonRegisterActivity1 extends AppCompatActivity {

    EditText etFname, etLname, etEmail, etDOB, etCity, etPwd;
    TextView NextRegister;
    SpotsDialog spotsDialog;
    String role;
    String firstname,lastname,Email,dob,city, pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_register_1);
//        activity=this;
         final CommonData commonData=new CommonData();

        etFname = (EditText) findViewById(R.id.inputFNameET);
        etLname = (EditText) findViewById(R.id.inputLName);
        etEmail = (EditText) findViewById(R.id.signUPemailET);
        etPwd=(EditText)findViewById(R.id.signUpPwdET);
        etDOB = (EditText) findViewById(R.id.dobET);
        etCity = (EditText) findViewById(R.id.cityCountryET);

        NextRegister=(TextView)findViewById(R.id.nextReg1);



        role=getIntent().getStringExtra("role");

        NextRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (validate(etFname) && validate(etLname) && validate(etEmail) && validate(etPwd) && validate(etDOB) && validate(etCity)) {





                    firstname = etFname.getEditableText().toString();
                    lastname = etLname.getEditableText().toString();
                    Email = etEmail.getEditableText().toString();
                    pwd=etPwd.getEditableText().toString();
                    dob = etDOB.getEditableText().toString();
                    city = etCity.getEditableText().toString();

//                    FounderR1 founderR1 = new FounderR1(firstname,lastname,
//                            Email, dob,
//                            city);


//                    getuserRegistration(founderR1);



                    commonData.setFirst_Name(firstname);
                    commonData.setLast_Name(lastname);
                    commonData.setEmail(Email);
                    commonData.setPassword(pwd);
                    commonData.setDate_Of_Birth(dob);
                    commonData.setCity(city);

                    Intent intent=new Intent(CommonRegisterActivity1.this, CommonRegisterActivity2.class);
                    intent.putExtra("role", role);
                    intent.putExtra("fname",firstname);
                    intent.putExtra("lname",lastname);
                    intent.putExtra("email",Email);
                    intent.putExtra("pwd",pwd);
                    intent.putExtra("dob",dob);
                    intent.putExtra("city",city);
                    startActivity(intent);



                }

            }

        });




    }


    private boolean validate(EditText editText)//validation of edittext
    {
        if (editText.getText().toString().trim().length() > 0) {
            return true;
        }
        editText.setError("Please fill this");
        editText.requestFocus();
        return false;

    }


//    private void getuserRegistration(final CommonData commonData) {
//
//        spotsDialog = new SpotsDialog(CommonRegisterActivity1.this);
//        spotsDialog.show();
//
//        APIClient.getApiCLientAfterLogin();
//        APIService services = APIClient.getApiCLientAfterLogin().create(APIService.class);
//        Call<Response1> call = services.registeraddedsucessfully(commonData);
//        call.enqueue(new Callback<Response1>() {
//            @Override
//            public void onResponse(Call<Response1> call, retrofit2.Response<Response1> response) {
//                spotsDialog.dismiss();
//                Response1 user = response.body();
//                if (user != null) {
//
//
//                    etFname.getText().clear();
//                    etLname.getText().clear();
//                    etEmail.getText().clear();
//                    etDOB.getText().clear();
//                    etCity.getText().clear();
//                    Toast.makeText(CommonRegisterActivity1.this, "Register Successfully", Toast.LENGTH_SHORT).show();
////
////                    Intent intent  = new Intent(SignUpActivity.this,LoginActivity.class);
////                    startActivity(intent);
//
//                } else {
//                    Toast.makeText(CommonRegisterActivity1.this, "Something wrong ", Toast.LENGTH_LONG).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Response1> call, Throwable t) {
//                spotsDialog.dismiss();
//                Log.d("Throwable  Exception", "" + t);
//                Toast.makeText(CommonRegisterActivity1.this, "Try After Some time", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }

}

//    public void getValues(){
//        etFname=(EditText)findViewById(R.id.inputFNameET);
//        etLname=(EditText)findViewById(R.id.inputLName);
//        etEmail=(EditText)findViewById(R.id.inputEmail);
//        etDOB=(EditText)findViewById(R.id.dobET);
//        etCity=(EditText)findViewById(R.id.cityCountryET);
//    }

//    public void toCommonRegisterActivity(View view) {
//        Intent intent=new Intent(activity,CommonRegisterActivity2.class);
//        startActivity(intent);
//    }
//}