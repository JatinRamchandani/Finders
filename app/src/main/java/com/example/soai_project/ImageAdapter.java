package com.example.soai_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ImageAdapter extends ArrayAdapter<Image> {
    private int mcolorResourceId;


    public ImageAdapter(Activity context, ArrayList<Image> words) {

        super(context, 0, words);

    }
    //this is getview method take three params position for position of the item in the gridview ,second param is view and third viewgroup
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridViewItem=convertView;
        //in the  constructor of the imageAdapter when i set the resource as 0 then gridViewItem should be valid not null but this if statement is only for check
        if(gridViewItem==null){

            gridViewItem= LayoutInflater.from(getContext()).inflate(R.layout.searchbar_list_item, parent, false);
        }
        //here I make cuurendword object and use getItem for  get the position of the gridViewItem
      Image CurrentWord=getItem(position);

        ImageView iconView=(ImageView)gridViewItem.findViewById(R.id.image1);
        //here we are checking the image id is valid or not
        if(CurrentWord.hasImage()){
            iconView.setImageResource(CurrentWord.getImageResourceId());
            iconView.setVisibility(View.VISIBLE);}
        else{
            iconView.setVisibility(View.GONE);
        }
  //finally we return this gridviewItem
        return  gridViewItem;
    }

}