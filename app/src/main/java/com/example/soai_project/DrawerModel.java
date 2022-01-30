package com.example.soai_project;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DrawerModel{
    public int icon;
    public String name;

    // Constructor.
    //this is the customclass of the drawercustomadapter in which I set the value to variable with help of constructor
//And access these variable in the drawablecustomadapter class in the getview method

    public DrawerModel(int icon, String name) {

         this.icon = icon;
        this.name = name;
    }
    //here I used Constructor overloading
    public DrawerModel(String name) {

        this.name = name;
    }
}