package com.example.hardwares2;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MyHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
    ImageView mImage;
    TextView mTitle, mDescrb;
    ItemClickListener itemClickListener;

     MyHolder(View itemView) {
        super(itemView);
        this.mImage= itemView.findViewById(R.id.imageView);
        this.mTitle= itemView.findViewById(R.id.text1);
        this.mDescrb= itemView.findViewById(R.id.text2);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick( v,this.getLayoutPosition());

    }
    public  void setItemClickListener(ItemClickListener ic){
        this.itemClickListener=ic;
    }
}
