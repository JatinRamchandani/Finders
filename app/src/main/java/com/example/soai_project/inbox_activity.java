package com.example.soai_project;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soai_project.InboxRecyclerAdapter.InboxAdapter;


public class inbox_activity extends AppCompatActivity implements InboxAdapter.ListItemClickListener {

    private RecyclerView inboxList;
    private ImageView img;
    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private Toolbar toolbar;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    androidx.appcompat.app.ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav5_activity_main);


        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);
        mTitle = mDrawerTitle = getTitle();
        mNavigationDrawerItemTitles= getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        img=(ImageView)findViewById(R.id.openmenu1);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mDrawerLayout.closeDrawers();


        final DrawerModel[] drawerItem = new DrawerModel[10];
        drawerItem[0] = new DrawerModel(R.drawable.ic_action_name, "Settings Menu");
        drawerItem[1] = new DrawerModel(R.drawable.share, "  Share");
        drawerItem[2] = new DrawerModel(R.drawable.privacy, "    Privacy");
        drawerItem[3] = new DrawerModel(R.drawable.question, "  Help");
        drawerItem[4] = new DrawerModel(R.drawable.shield, "   T&C");
        drawerItem[5] = new DrawerModel(R.drawable.notification, "    Notifications");
        drawerItem[6] = new DrawerModel(R.drawable.qrcode, "  User Tag");
        drawerItem[7] = new DrawerModel(R.drawable.info, "     About");
        drawerItem[8] = new DrawerModel( 0, "");
        drawerItem[9] = new DrawerModel(R.drawable.logout, "       Log Out");
        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.list_view_item_row, drawerItem);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Intent intent;
                switch (position) {
                    case 7:
                        intent= new Intent( inbox_activity.this,AboutActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent= new Intent(  inbox_activity.this,HelpActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent= new Intent(  inbox_activity.this,PrivacyActivity.class);

                        startActivity(intent);

                        break;
                    case 5:
                        intent= new Intent(  inbox_activity.this,NotificationActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        });
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        setupDrawerToggle();

        inboxList = (RecyclerView) findViewById(R.id.inbox_recycle);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        inboxList.setLayoutManager(layoutManager);
        inboxList.setHasFixedSize(true);


        // Since the data set is not available this array is used to in place of username, this arrya is passed to the adapter for now
        String[] a={"a","b","c","d","e","f","g","h","i","j","k","l","m","n"};

        inboxList.setAdapter( new InboxAdapter(this,a));


    }


    @Override
    public void onListItemClick(String username, TextView message) {
        Intent intentToStartChat =new Intent(inbox_activity.this, ChatActivity.class);
        intentToStartChat.putExtra(Intent.EXTRA_TEXT,username);
        startActivity(intentToStartChat);
        message.setTextColor(Color.parseColor("#c9c9c9"));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.inbox_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();

        if(id==R.id.user)
        {
            Intent intent=new Intent(inbox_activity.this, UserPofile1.class);
            startActivity(intent);
            return true;
        }

        if(id==R.id.setting){
            mDrawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        if(id==R.id.search)
        {

        }


        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }


        return super.onOptionsItemSelected(item);


    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);


        }

    }

    private void selectItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new ConnectFragment();
                break;


            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(mNavigationDrawerItemTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }



    void setupDrawerToggle(){
        mDrawerToggle = new androidx.appcompat.app.ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.app_name, R.string.app_name);
        //This is necessary to change the icon of the Drawer Toggle upon state change.
        mDrawerToggle.syncState();
    }

}