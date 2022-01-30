package com.example.soai_project;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.TypedArrayUtils;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.view.MenuItem;
import android.view.View;
import android.widget.AlphabetIndexer;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.sql.Array;

public class PrivacyActivity extends AppCompatActivity {
    //define the Switches
    private Switch aSwitch;
    private Switch aSwitch2;
    //Define the SharedPreferences for save the value of the switches  for the whole time upto app unistall
    private SharedPreferences sharedPreferences;
    private SharedPreferences sharedPreferences2;
    private  static  final String ex="Switch14";
    private  static  final String ex2="Switch15";
    String Allowitem="Saved Contacts";
    private String ArrayUtils;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);

        //  use the actionbar here for go to previous activity
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        TextView profileText=(TextView)findViewById(R.id.profilepic2);
         profileText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//call this method  when click on the textview and set the overlay
                openDialog();

            }
        });
        TextView  aboutText=(TextView)findViewById(R.id.aboutyou2);
         aboutText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog();

            }
        });
        TextView  summaryText=(TextView)findViewById(R.id.summary2);
        summaryText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog();

            }
        });
        //casting or intialize  all the Switches
        aSwitch=(Switch)findViewById(R.id.switchpri1);
        aSwitch2=(Switch)findViewById(R.id.switchpri2);
        // use getSharedPreferences method and pass the Mode and then set it to the sharedpreferences variable
        sharedPreferences= getSharedPreferences(" ",MODE_PRIVATE);
        sharedPreferences2= getSharedPreferences(" ",MODE_PRIVATE);
        //use this method SharedPreferences.Editor because we will edit the preferences
        final SharedPreferences.Editor editor=sharedPreferences.edit();
        //set the defaultvalue to the switch
        aSwitch.setChecked(sharedPreferences.getBoolean(ex,false));
        //use this method because when we will click on the switch this method set the corrosponding  preferences
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //this is for when the switch is on
                if(isChecked){
                    editor.putBoolean(ex,true);
                }
                //this is for when the switch is off
                else {
                    editor.putBoolean(ex,false);
                }
                editor.commit();
            }
        });
        //same as switch 1
        aSwitch2.setChecked(sharedPreferences2.getBoolean(ex2,false));
        aSwitch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    editor.putBoolean(ex2,true);
                }
                else {
                    editor.putBoolean(ex2,false);
                }
                editor.commit();
            }
        });
    }
    //use this method for the actionbar for go to the previous activity
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    //use this method for set the overlay on the aboutyou, profilephoto etc
    public void openDialog() {
        RadioButton radio = null;
//set this item on the overlay or dialogbox which are in this array
       final String[] AllowOption={"Everyone","Saved Contacts","Nobody"};
        AlertDialog.Builder builder=new AlertDialog.Builder(PrivacyActivity.this);
        builder.setSingleChoiceItems(AllowOption, 1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Allowitem =AllowOption[which];

                            }
                        });
        builder.show();

    }


}