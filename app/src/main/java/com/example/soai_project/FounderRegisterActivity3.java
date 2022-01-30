package com.example.soai_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.TextView;
import android.widget.Toast;


import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.util.IOUtils;
import com.example.soai_project.DataModel.FounderModel;
import com.example.soai_project.Founderr1.CommonData;
import com.example.soai_project.Retrofit.APIService;
import com.example.soai_project.Retrofit.Api;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FounderRegisterActivity3 extends AppCompatActivity {




    private static final String AWS_BUCKET ="bucket-for-app" ;
    private final String KEY = "AKIA54H4UQOWKMJQ3YC4";
    private final String SECRET = "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";

    private AmazonS3Client s3Client;
    private BasicAWSCredentials credentials;

    APIService apiService;
    Retrofit retrofit;
    public JsonObject jsonObject;
    public JsonObject  user;
    public JsonObject  PersonalDetails;
    public JsonObject  ProfessionalDetails;
    public JsonObject  fon_StartupDetails;

    CommonData commonData;
    TextInputEditText fundsReq,retDis;
    String fundReqString, retDisString;
    String purposeString, ideaMoreString,websiteString;
    String ideaString,categoryFounderString,stageFounderString;
    String firstname,lastname,Email,dob,city, pwd;
    String qualificationString, workExString,linkedinString;


    String videouri;

    Uri fileUri;


    String awsUrlToSend;

    TextView finishRegfounder;
    FounderModel founderModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_founder_register_3);



        credentials = new BasicAWSCredentials(KEY, SECRET);
        s3Client = new AmazonS3Client(credentials);

        AWSMobileClient.getInstance().initialize(this).execute();

        fundsReq=(TextInputEditText)findViewById(R.id.fundsReqET);
        retDis=(TextInputEditText)findViewById(R.id.returnDisET);

        finishRegfounder=(TextView)findViewById(R.id.finishRegFounder);


        fundReqString=fundsReq.getEditableText().toString().trim();
        retDisString=retDis.getEditableText().toString().trim();

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
        purposeString=getIntent().getStringExtra("purposefounder");
        ideaMoreString=getIntent().getStringExtra("ideamorefounder");
        websiteString=getIntent().getStringExtra("websitefounder");


        videouri=getIntent().getStringExtra("videouri");
        fileUri=Uri.parse(videouri);



        commonData.setFirst_Name(firstname);
        commonData.setLast_Name(lastname);
        commonData.setDate_Of_Birth(dob);
        commonData.setEmail(Email);
        commonData.setCity(city);
        commonData.setPassword(pwd);
        commonData.setWorkExCommon(workExString);
        commonData.setQualificatioNCommon(qualificationString);
        commonData.setLinkedinCommon(linkedinString);


        apiService= Api.getRetrofitInstance().create(APIService.class);


finishRegfounder.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(validate(fundsReq) && validate(retDis)) {
            founderModel.setFundsReqFounder(fundReqString);
            founderModel.setRetDisFounder(retDisString);

            uploadFile();

            createPost();

            Intent intent=new Intent(FounderRegisterActivity3.this,Pitch_video.class);
            startActivity(intent);
        }
    }

});






    }

//    public boolean validate(){
//        if(fundReqString!=null && retDisString!=null){
//            return true;
//        } else{
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




    private void createPost(){

        user=new JsonObject();
        user.addProperty("Email",Email);
        user.addProperty("Password",pwd);
        user.addProperty("Contact_No","some number");
        user.addProperty("Team_ID","some id");
        user.addProperty("User_type",getIntent().getStringExtra("role"));

        PersonalDetails=new JsonObject();
        PersonalDetails.addProperty("First_Name",firstname);
        PersonalDetails.addProperty("Last_Name",lastname);
        PersonalDetails.addProperty("Bio","bio");
        PersonalDetails.addProperty("Date_Of_Birth",dob);
        PersonalDetails.addProperty("City",city);
        PersonalDetails.addProperty("Country","India");

        ProfessionalDetails=new JsonObject();
        ProfessionalDetails.addProperty("Qualification",qualificationString);
        ProfessionalDetails.addProperty("Level_Of_Education",workExString);
        ProfessionalDetails.addProperty("LinkedIn",linkedinString);

        fon_StartupDetails=new JsonObject();
        fon_StartupDetails.addProperty("Startup_Name",ideaString);
        fon_StartupDetails.addProperty("Idea_Description",ideaMoreString);
        fon_StartupDetails.addProperty("Deck_Link","decklink");
        fon_StartupDetails.addProperty("Tags","sometag");
        fon_StartupDetails.addProperty("Stage",stageFounderString);
        fon_StartupDetails.addProperty("Purpose",purposeString);
        fon_StartupDetails.addProperty("Req_Funds",fundReqString);
        fon_StartupDetails.addProperty("Website",websiteString);
        fon_StartupDetails.addProperty("Pitch_Vid_Link",awsUrlToSend);

        jsonObject=new JsonObject();
        jsonObject.add("user",user);
        jsonObject.add("PersonalDetails",PersonalDetails);
        jsonObject.add("ProfessionalDetails",ProfessionalDetails);
        jsonObject.add("fon_StartupDetails",fon_StartupDetails);




        Call<JsonObject> call= apiService.founderregisteraddedsuccessfully(jsonObject);

        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {


                Toast.makeText(FounderRegisterActivity3.this, " Registerd Succesfully", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

                Toast.makeText(FounderRegisterActivity3.this, "Registerd Failed", Toast.LENGTH_SHORT).show();

            }
        });
    }





    //aws s3 upload and url retrieval from here



    private String getUrl(){
        return s3Client.getUrl(AWS_BUCKET,"pitchVids/" + getIntent().getStringExtra("ideaString") + "." + getFileExtension(fileUri) ).toExternalForm();
    }




    private void uploadFile() {

        if (fileUri != null) {
            final String fileName = getIntent().getStringExtra("ideaString");

            if (!validateInputFileName(fileName)) {
                return;
            }

            final File file = new File(Environment.getExternalStoragePublicDirectory(Environment.MEDIA_MOUNTED),
                    "/" + fileName);

            createFile(getApplicationContext(), fileUri, file);

            TransferUtility transferUtility =
                    TransferUtility.builder()
                            .context(getApplicationContext())
                            .awsConfiguration(AWSMobileClient.getInstance().getConfiguration())
                            .s3Client(s3Client)
                            .build();

            TransferObserver uploadObserver =
                    transferUtility.upload("pitchVids/" + fileName + "." + getFileExtension(fileUri), file);

            uploadObserver.setTransferListener(new TransferListener() {

                @Override
                public void onStateChanged(int id, TransferState state) {
                    if (TransferState.COMPLETED == state) {
                        Toast.makeText(getApplicationContext(), "Upload Completed!", Toast.LENGTH_SHORT).show();
                        awsUrlToSend=getUrl();



                        file.delete();
                    } else if (TransferState.FAILED == state) {
                        file.delete();
                    }
                }

                @Override
                public void onProgressChanged(int id, long bytesCurrent, long bytesTotal) {
                    float percentDonef = ((float) bytesCurrent / (float) bytesTotal) * 100;
                    int percentDone = (int) percentDonef;
                }

                @Override
                public void onError(int id, Exception ex) {
                    ex.printStackTrace();
                }

            });
        }
    }



    private String getFileExtension(Uri uri) {
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();

        return mime.getExtensionFromMimeType(contentResolver.getType(uri));
    }

    private boolean validateInputFileName(String fileName) {

        if (TextUtils.isEmpty(fileName)) {
            Toast.makeText(this, "Enter file name!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }


    private void createFile(Context context, Uri srcUri, File dstFile) {
        try {
            InputStream inputStream = context.getContentResolver().openInputStream(srcUri);
            if (inputStream == null) return;
            OutputStream outputStream = new FileOutputStream(dstFile);
            IOUtils.copy(inputStream, outputStream);
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}