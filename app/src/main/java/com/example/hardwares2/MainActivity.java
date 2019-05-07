package com.example.hardwares2;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerview;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRecyclerview =findViewById(R.id.recycle);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));

        myAdapter=new MyAdapter(this, getPlayers());
        mRecyclerview.setAdapter(myAdapter);


    }
    private ArrayList<ExampleItem> getPlayers(){
        ArrayList<ExampleItem> exampleItems= new ArrayList<>();

        ExampleItem p= new ExampleItem();
        p.setTitle("Eagle");
        p.setDescription("located at Eldoret");
        p.setImg(R.drawable.image1);
        exampleItems.add(p);

        p= new ExampleItem();
        p.setTitle("Patel");
        p.setDescription("located at Eldoret");
        p.setImg(R.drawable.image1);
        exampleItems.add(p);

        p= new ExampleItem();
        p.setTitle("King");
        p.setDescription("located at Eldoret");
        p.setImg(R.drawable.image1);
        exampleItems.add(p);

        p= new ExampleItem();
        p.setTitle("Extras");
        p.setDescription("located at Eldoret");
        p.setImg(R.drawable.image1);
        exampleItems.add(p);

        p= new ExampleItem();
        p.setTitle("One stop");
        p.setDescription("located at Eldoret");
        p.setImg(R.drawable.image1);
        exampleItems.add(p);

        p= new ExampleItem();
        p.setTitle("Smart");
        p.setDescription("located at Eldoret");
        p.setImg(R.drawable.image1);
        exampleItems.add(p);

        return exampleItems;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main,menu);
        MenuItem item=menu.findItem(R.id.title4);
        SearchView searchView=(SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
             //called when you click search
                myAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //called whenever you type each letter in searchview
                myAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.title1){
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("plaintext/string");
            String header = "Share App via";
            String subheading = "Sharing";
            String shareBody = "app link";

            shareIntent.putExtra(Intent.EXTRA_SUBJECT,subheading);
            shareIntent.putExtra(Intent.EXTRA_TEXT,shareBody);

            /*Start activity*/
            startActivity(Intent.createChooser(shareIntent,header));
        }   if (id==R.id.title2){
            Toast.makeText(this,"notification Clicked",Toast.LENGTH_LONG).show();
        }  if (id==R.id.title3){
            Toast.makeText(this,"account Clicked",Toast.LENGTH_LONG).show();
        } if (id==R.id.title5){
            Toast.makeText(this,"filter Clicked",Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

}
