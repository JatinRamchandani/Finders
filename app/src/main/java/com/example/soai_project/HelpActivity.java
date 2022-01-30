package com.example.soai_project;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        //  use the actionbar here for go to previous activity
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
           /*here similiarly use as the userprofile1 this Drawermodel is custom class and the draweritemcustomadaper is its customadapter that is used
        to set the item in the listview */
        final DrawerModel[] drawerItem = new DrawerModel[4];
        drawerItem[0] = new DrawerModel( "Report a problem");
        drawerItem[1] = new DrawerModel(  "Privacy and Security");
        drawerItem[2] = new DrawerModel( "Help Centre");
        drawerItem[3] = new DrawerModel( "Send Feedback");
        ListView listView=(ListView)findViewById(R.id.list1);
        //define the custom class adapter called DrawerItemCustomadapter
        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.list_view_item_row, drawerItem);
       //set the adapter on the listview
        listView.setAdapter(adapter);
        //this is used to go to reportProblemActivity and privacySecurityActivity e.t.c, when click on the listview item of the helperactivty
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent= new Intent(HelpActivity.this, ReportProblemActvity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent= new Intent(HelpActivity.this, PrivacySecurityActivity.class);
                        startActivity(intent);
                        break;

                    default:
                        break;
                }
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