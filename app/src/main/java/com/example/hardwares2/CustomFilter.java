package com.example.hardwares2;

import android.widget.Filter;

import java.util.ArrayList;

public class CustomFilter extends Filter {
    MyAdapter adapter;
    ArrayList<ExampleItem> filterList;

    public  CustomFilter (ArrayList<ExampleItem> filterList,MyAdapter adapter){
        this.adapter=adapter;
        this.filterList=filterList;
    }
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results= new FilterResults();
        //check constraint validity
        if (constraint!= null && constraint.length()>0){
            //change constraint to uppercase
            constraint= constraint.toString().toUpperCase();
            //store our filterd models
            ArrayList<ExampleItem> filteredModels = new ArrayList<>();
            for (int i=0;i<filterList.size();i++){
                //check
                if(filterList.get(i).getTitle().toUpperCase().contains(constraint)){
                   //add models to filtered models
                    filteredModels.add(filterList.get(i));
                }
            }
            results.count=filteredModels.size();
            results.values=filteredModels;
        }
        else {
            results.count=filterList.size();
            results.values=filterList;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {

        adapter.exampleItems=( ArrayList <ExampleItem>) results.values;
        //refresh
        adapter.notifyDataSetChanged();
    }
}
