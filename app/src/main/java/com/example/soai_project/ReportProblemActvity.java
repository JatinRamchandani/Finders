package com.example.soai_project;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

public class ReportProblemActvity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_problem_actvity);
        //  use the actionbar here for go to previous activity
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
              /*here similiarly use as the userprofile1 this Drawermodel is custom class and the draweritemcustomadaper is its customadapter that is used
        to set the item in the listview */
        final DrawerModel[] drawerItem = new  DrawerModel[4];
        drawerItem[0] = new DrawerModel( "Report Spam or Abuse");
        drawerItem[1] = new DrawerModel(  "Report Problem");
        drawerItem[2] = new DrawerModel( "Report for Capital Counterfeit");
        drawerItem[3] = new DrawerModel(  "Report for Misconduct");
        ListView listView=(ListView)findViewById(R.id.list1);
        //define the custom class adapter called DrawerItemCustomadapter
        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.list_view_item_row, drawerItem);
       //set the adapter on the listview
        listView.setAdapter(adapter);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}