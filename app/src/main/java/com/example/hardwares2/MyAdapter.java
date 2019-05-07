package com.example.hardwares2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyHolder>  implements Filterable {

    Context c;
    ArrayList<ExampleItem> exampleItems,filterList;
    CustomFilter filter;

    public MyAdapter(Context c, ArrayList<ExampleItem>exampleItems){
        this.c=c;
       this.exampleItems=exampleItems;
       this.filterList= exampleItems;

    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.exampleitem,null);

     return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, int i) {
        holder.mTitle.setText(exampleItems.get(i).getTitle());
        holder.mDescrb.setText(exampleItems.get(i).getDescription());
        holder.mImage.setImageResource(exampleItems.get(i).getImg());

        Animation animation= AnimationUtils.loadAnimation(c,android.R.anim.slide_in_left);
        holder.itemView.startAnimation(animation);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                String title= exampleItems.get(pos).getTitle();
                String descr= exampleItems.get(pos).getDescription();
                BitmapDrawable bitmapDrawable = (BitmapDrawable)holder.mImage.getDrawable();

                Bitmap bitmap=bitmapDrawable.getBitmap();
                ByteArrayOutputStream stream=new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
                byte[] bytes=stream.toByteArray();

                Intent intent =new Intent(c,Detail2Activity.class);
                intent.putExtra("iTitle",title);
                intent.putExtra("iDescr",descr);
                intent.putExtra("iImage",bytes);

                c.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return exampleItems.size();
    }

    @Override
    public Filter getFilter() {
        if(filter==null){
            filter=new CustomFilter(filterList,this);

        }
       return  filter;
    }
}
