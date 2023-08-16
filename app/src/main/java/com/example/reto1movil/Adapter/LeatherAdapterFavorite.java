package com.example.reto1movil.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.reto1movil.Model.Leather;
import com.example.reto1movil.R;
import com.example.reto1movil.database.DatabaseActions;

public class LeatherAdapterFavorite extends BaseAdapter {
    private Context context;
    private Leather leather;
    private int sizeThis;

    public LeatherAdapterFavorite(Context context) {
        this.context = context;
        leather = new Leather();
        DatabaseActions db = new DatabaseActions();
        leather.setFavoriteItems(db.ConsultarFavoritos(context));
    }

    @Override
    public int getCount() {
        return leather.getFavoriteCount();
    }

    @Override
    public Leather getItem(int i) {
        return leather.getFavoriteItems(i);
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
        ImageView fotoLeather = (ImageView) view.findViewById(R.id.leatherImg);
        TextView nombreLeather = (TextView) view.findViewById(R.id.leatherName);
        TextView precioLeather = (TextView) view.findViewById(R.id.leatherPrice);
        Leather item = getItem(i);
        //fotoLeather.setImageResource(item.getIdDrawable());
        String base64String = item.getBase64Drawable();
        byte[] decodedString = Base64.decode(base64String, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        fotoLeather.setImageBitmap(decodedByte);
        nombreLeather.setText(item.getName());
        precioLeather.setText(String.valueOf(item.getPrice()));
        return view;
    }
}
