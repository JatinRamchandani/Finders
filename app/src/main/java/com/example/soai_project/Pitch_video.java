package com.example.soai_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.example.soai_project.Retrofit.APIService;
import com.example.soai_project.Retrofit.Api;
import com.example.soai_project.companydetails.Companies;
import com.example.soai_project.companydetails.Companydetail;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Pitch_video extends AppCompatActivity {
    private static final String BUCKET_NAME ="bucket" ;
    private ImageView img2;
    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private Toolbar toolbar;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    androidx.appcompat.app.ActionBarDrawerToggle mDrawerToggle;



    APIService apiService;




    private static final String AWS_BUCKET ="bucket" ;
    private final String KEY = "k";
    private final String SECRET = "sk";


    private BasicAWSCredentials credentials;
    private AmazonS3Client s3Client;


    private ViewPager2 viewPager2;
    private List<pitchVideoitem> pitchVideoitems;
    private List<String> vidUrls;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav5_activity_main);


        credentials = new BasicAWSCredentials(KEY, SECRET);
        s3Client = new AmazonS3Client(credentials);


        AWSMobileClient.getInstance().initialize(this).execute();


        apiService= Api.getRetrofitInstance().create(APIService.class);



        viewPager2 = findViewById(R.id.Pitchviewpager);
        pitchVideoitems = new ArrayList<>();





//settings menu code start
        mTitle = mDrawerTitle = getTitle();
        mNavigationDrawerItemTitles= getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        img2=(ImageView)findViewById(R.id.imagesetting);
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
        mDrawerList.setOnItemClickListener(new  DrawerItemClickListener());

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mDrawerLayout.openDrawer(GravityCompat.START);

            }
        });
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Intent intent;
                switch (position) {
                    case 7:
                        intent= new Intent( Pitch_video.this,AboutActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent= new Intent( Pitch_video.this,HelpActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent= new Intent( Pitch_video.this,PrivacyActivity.class);

                        startActivity(intent);

                        break;
                    case 5:
                        intent= new Intent( Pitch_video.this,NotificationActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        });
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        setupDrawerToggle();
        //Settings menu code end


        ObjectListing listing = s3Client.listObjects( AWS_BUCKET, "pitchVids/" );
        List<S3ObjectSummary> summaries = listing.getObjectSummaries();
        //
        vidUrls = new ArrayList<>();

        while (listing.isTruncated()) {
            listing = s3Client.listNextBatchOfObjects (listing);
            summaries.addAll (listing.getObjectSummaries());
        }

        for(S3ObjectSummary objectSummary : summaries) {
            String key = objectSummary.getKey();
            String toUseUrl="https://bucket-for-app.s3.Region.amazonaws.com/pitchVids/"+key;
//            pitchVideoitem newItem=new pitchVideoitem();
//            newItem.pitchvideourl= toUseUrl;
//            newItem.Companyname="By google";
//            newItem.CompanyLocation="Lucknow,India";
//            newItem.Companydiscrption="This is one of the best company for bigger fun";
//            pitchvideoitems.add(newItem);
            vidUrls.add(toUseUrl);

        }


        getData();


       // viewPager2.setAdapter(new pitchVideoAdapter(pitchvideoitems));




    }
    //settings menu code start
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
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
        mDrawerToggle = new androidx.appcompat.app.ActionBarDrawerToggle(this,mDrawerLayout,R.string.app_name, R.string.app_name);
        //This is necessary to change the icon of the Drawer Toggle upon state change.
        mDrawerToggle.syncState();
    }
// settings menu option code end








    private void getData()
    {
        Call<Companies> userList= apiService.getCompanyList();
        userList.enqueue(new Callback<Companies>() {
            @Override
            public void onResponse(Call<Companies> call, Response<Companies> response) {
                Companies newCompList=response.body();
                List<Companydetail> allComps=newCompList.getCompanydetails();

                viewPager2.setAdapter(new pitchVideoAdapter(vidUrls,allComps));

            }

            @Override
            public void onFailure(Call<Companies> call, Throwable t) {
                Log.e("THIDDDDDDDDDDDDTG",String.valueOf(t));

            }
        });
    }
}
