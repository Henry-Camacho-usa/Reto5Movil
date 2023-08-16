package com.example.reto1movil.Adapter;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.reto1movil.LeatherProducts;
import com.example.reto1movil.Model.Leather;
import com.example.reto1movil.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LeatherAdapterCloud extends BaseAdapter{
    private Context context;
    public LeatherAdapterCloud(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return LeatherProducts.leatherProds.length;
    }

    @Override
    public Leather getItem(int i) {return LeatherProducts.leatherProds[i];}

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
        //La siguiente línea no es necesaria debido a que carga el ID de otra manera. No recuerdo donde jeje
        //ImageView idLeather = (ImageView) view.findViewById(R.id.leatherId);
        TextView nombreLeather = (TextView) view.findViewById(R.id.leatherName);
        TextView descripcionLeather = (TextView) view.findViewById(R.id.leatherDescription);
        ImageView fotoLeather = (ImageView) view.findViewById(R.id.leatherImg);
        TextView precioLeather = (TextView) view.findViewById(R.id.leatherPrice);
        Leather item = getItem(i);
        //fotoLeather.setImageResource(item.getIdDrawable());
        String base64String = item.getBase64Drawable();
        byte[] decodedString = Base64.decode(base64String, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        nombreLeather.setText(item.getName());
        fotoLeather.setImageBitmap(decodedByte);
        descripcionLeather.setText(item.getDescription());
        precioLeather.setText(String.valueOf(item.getPrice()));
        return view;
    }
}
