package com.example.soai_project;

import androidx.appcompat.app.ActionBar;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.view.MenuItem;
        import android.widget.CompoundButton;
        import android.widget.Switch;

public class EmailsSMSActivity extends AppCompatActivity {
    //define the Switch name
    private Switch aSwitch;
    private Switch aSwitch2;
    private Switch aSwitch3;
    private Switch aSwitch4;
    private Switch aSwitch5;
    private Switch aSwitch6;
    //Define the SharedPreferences for save the value of the switches  for the whole time upto app unistall
    private SharedPreferences sharedPreferences;
    private SharedPreferences sharedPreferences2;
    private  static  final String ex="Switch1";
    private  static  final String ex2="Switch2";
    private  static  final String ex3="Switch3";
    private  static  final String ex4="Switch4";
    private  static  final String ex5="Switch5";
    private  static  final String ex6="Switch6";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emails_s_m_s);
        //  use the actionbar here for go to previous activity
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        //casting or intialize  all the Switches
        aSwitch=(Switch)findViewById(R.id.switchEin1);
        aSwitch2=(Switch)findViewById(R.id.switchEin2);
        aSwitch3=(Switch)findViewById(R.id.switchEin3);
        aSwitch4=(Switch)findViewById(R.id.switchEin4);
        aSwitch5=(Switch)findViewById(R.id.switchEin5);
        aSwitch6=(Switch)findViewById(R.id.switchEin6);
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
        //same as switch 1
        aSwitch3.setChecked(sharedPreferences2.getBoolean(ex3,false));
        aSwitch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    editor.putBoolean(ex3,true);
                }
                else {
                    editor.putBoolean(ex3,false);
                }
                editor.commit();
            }
        });
        //same as switch 1
        aSwitch4.setChecked(sharedPreferences2.getBoolean(ex4,false));
        aSwitch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    editor.putBoolean(ex4,true);
                }
                else {
                    editor.putBoolean(ex4,false);
                }
                editor.commit();
            }
        });
        //same as switch 1
        aSwitch5.setChecked(sharedPreferences2.getBoolean(ex5,false));
        aSwitch5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    editor.putBoolean(ex5,true);
                }
                else {
                    editor.putBoolean(ex5,false);
                }
                editor.commit();
            }
        });
        //same as switch 1
        aSwitch6.setChecked(sharedPreferences2.getBoolean(ex6,false));
        aSwitch6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    editor.putBoolean(ex6,true);
                }
                else {
                    editor.putBoolean(ex6,false);
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
}