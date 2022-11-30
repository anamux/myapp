package br.com.ana.myapplication.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class AdapterLista extends ArrayAdapter<String> {
    private ArrayList<String> localDataSet;


    public AdapterLista(@NonNull Context context, int resource, @NonNull ArrayList<String> objects) {
        super(context, resource, objects);
        this.localDataSet = objects;
    }


}
