package com.example.reto1movil.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.reto1movil.Adapter.LeatherAdapterCloud;
import com.example.reto1movil.LeatherDetailActivity;
import com.example.reto1movil.LeatherProducts;
import com.example.reto1movil.Model.Leather;
import com.example.reto1movil.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;
import java.util.Locale;

public class ProductosFragment extends Fragment {
    private GridView grilla;
    private LeatherAdapterCloud leatherAdapter;

    public ProductosFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.productos_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Context context = getActivity().getApplicationContext();
        grilla = getView().findViewById(R.id.grillaZapatos);
        if (LeatherProducts.leatherProds != null){
            leatherAdapter = new LeatherAdapterCloud(getContext());
            grilla.setAdapter(leatherAdapter);
        }else Toast.makeText(getContext(),"Revise su conexión a Internet",Toast.LENGTH_LONG).show();

        grilla.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View view,int position,long id){
                Leather item = (Leather)parent.getItemAtPosition(position);
                Intent intent = new Intent(getContext(), LeatherDetailActivity.class);
                intent.putExtra("leather_id", item.getId());
                intent.putExtra("leather_name", item.getName());
                intent.putExtra("leather_description", item.getDescription());
                //intent.putExtra("leather_drawable", item.getIdDrawable());
                intent.putExtra("leather_drawable", item.getBase64Drawable());
                intent.putExtra("leather_price", item.getPrice());
                startActivity(intent);
            }
        });
    }
}
