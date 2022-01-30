package com.example.soai_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class  Image{

    private  int mImageResourceId=NO_IMAGE_PROVIDED;
    private static final int  NO_IMAGE_PROVIDED=-1;


    public Image(int ImageResourceId){
//here i give the id of image to the variable mImageResourceId
        mImageResourceId=ImageResourceId;

    }
    //it is getter method which return the id of the image or icon
    public int getImageResourceId()
    {
        return mImageResourceId;
    }
//this method i used only to check the valid image id
    public boolean hasImage(){
        return mImageResourceId!=NO_IMAGE_PROVIDED;
    }

}
