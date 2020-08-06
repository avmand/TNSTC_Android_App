package com.example.project1;

import android.app.Activity;
import android.os.Bundle;


public class Maps_Tnstc_Ground extends Activity {


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.map_tnstc_layout);

        TouchImageView img = new TouchImageView(this);
        img.setImageResource(R.drawable.ground_floor);
        img.setMaxZoom(4f);
        setContentView(img);
    }
}