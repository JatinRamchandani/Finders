package com.example.soai_project;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.SearchManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.SearchView;
import android.widget.Toolbar;

import java.util.ArrayList;

public class  DiscoverActivity extends AppCompatActivity {

    private ImageAdapter adapter;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_bar);
        //Here I made an empty arraylist with Word object as the data type
        ArrayList<Image> words = new ArrayList<Image>();
//here I added the item in the array list and pass the item to the constructor of the image class
        words.add(new Image(R.drawable.agriculture_palate));
        words.add(new Image(R.drawable.pharmaceuticals_palate));
        words.add(new Image(R.drawable.ml_palate));
        words.add(new Image(R.drawable.fintech_palate));
        words.add(new Image(R.drawable.ai_pallete));
        words.add(new Image(R.drawable.block_chain_palette));
        words.add(new Image(R.drawable.crypto_currency_palate));
        words.add(new Image(R.drawable.automation_pallete));
//here i instantiate the customadapter of the image class which is imageAdapter

        adapter = new ImageAdapter(this, words);

        GridView gridView = (GridView) findViewById(R.id.grid);
//here i set the adapter on the gridview
        gridView.setAdapter(adapter);

    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_view, menu);
        //here I added the searchbar in the  menubar
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setQueryHint("Search Here");
        searchView.setIconified(false);
        return true;
    }

}
