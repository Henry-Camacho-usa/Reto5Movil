package com.example.reto1movil.Adapter;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.reto1movil.Model.Leather;
import com.example.reto1movil.R;


public class LeatherAdapter extends BaseAdapter {

    private Context context;

    public LeatherAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return Leather.ITEMS.length;
    }

    @Override
    public Leather getItem(int i) {
        return Leather.ITEMS[i];
    }

    @Override
    public long getItemId(int i) {
        return getItem(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_grilla,parent,false);
        }
        //ImageView idLeather = (ImageView) view.findViewById(R.id.leatherId);
        TextView nombreLeather = (TextView) view.findViewById(R.id.leatherName);
        TextView descripcionLeather = (TextView) view.findViewById(R.id.leatherDescription);
        ImageView fotoLeather = (ImageView) view.findViewById(R.id.leatherImg);
        TextView precioLeather = (TextView) view.findViewById(R.id.leatherPrice);
        Leather item = getItem(i);
        fotoLeather.setImageResource(item.getIdDrawable());
        nombreLeather.setText(item.getName());
        descripcionLeather.setText(item.getDescription());
        precioLeather.setText(String.valueOf(item.getPrice()));
        return view;
    }
}
