package com.example.hardwares2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail2Activity extends AppCompatActivity {
    TextView mTv,mDesc;
    ImageView Image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);

        ActionBar actionBar=getSupportActionBar();

        mTv=findViewById(R.id.text11);
        mDesc =findViewById(R.id.text22);
        Image =findViewById(R.id.image);

        Intent intent=getIntent();
       String mTitle= intent.getStringExtra("iTitle");
        String mDescr=intent.getStringExtra("iDescr");
        byte[] mBytes=getIntent().getByteArrayExtra("iImage");

        Bitmap bitmap= BitmapFactory.decodeByteArray(mBytes,0,mBytes.length);

        actionBar.setTitle(mTitle);

        mTv.setText(mTitle);
        mDesc.setText(mDescr);
        Image.setImageBitmap(bitmap);



    }


}
