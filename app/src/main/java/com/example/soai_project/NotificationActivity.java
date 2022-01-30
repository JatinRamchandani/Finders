package com.example.soai_project;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class NotificationActivity extends AppCompatActivity {
    //define the Switch
   private Switch aSwitch;
    //Define the SharedPreferences for save the value of the switches  for the whole time upto app unistall
   private SharedPreferences sharedPreferences;
   private  static  final String ex="Switch13";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        //  use the actionbar here for go to previous activity
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        //casting or intialize the Switch
        aSwitch=(Switch)findViewById(R.id.switch1);
        // use getSharedPreferences method and pass the Mode and then set it to the sharedpreferences variable
        sharedPreferences= getSharedPreferences(" ",MODE_PRIVATE);
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
        TextView inboxText=(TextView)findViewById(R.id.inbox);
        inboxText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(NotificationActivity.this,InboxMenuActivity.class);
                startActivity(intent);
            }
        });
        TextView FromFindersText=(TextView)findViewById(R.id.fromfinders);
        FromFindersText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(NotificationActivity.this,FromFindersActivity.class);
                startActivity(intent);
            }
        });
        TextView EmailSmsText=(TextView)findViewById(R.id.EmailsSms);
         EmailSmsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(NotificationActivity.this,EmailsSMSActivity.class);
                startActivity(intent);
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