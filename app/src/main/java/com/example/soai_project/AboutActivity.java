package com.example.soai_project;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
      //  use the actionbar here for go to previous activity
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        /*here similiarly use as the userprofile1 this Drawermodel is custom class and the draweritemcustomadaper is its customadapter that is used
        to set the item in the listview */
       DrawerModel[] drawerItem = new DrawerModel[3];
        drawerItem[0] = new DrawerModel( "Data Policy");
        drawerItem[1] = new DrawerModel("Open Source Libraries");
        drawerItem[2] = new DrawerModel( "Version 1.0.2");
        ListView listView=(ListView)findViewById(R.id.list1);
        //define the custom class adapter called DrawerItemCustomadapter
        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.list_view_item_row, drawerItem);
        //set the adapter on the listview
        listView.setAdapter(adapter);
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