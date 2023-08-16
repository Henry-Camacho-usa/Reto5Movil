package com.example.reto1movil.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.reto1movil.Adapter.LeatherAdapterFavorite;
import com.example.reto1movil.LeatherDetailActivity;
import com.example.reto1movil.Model.Leather;
import com.example.reto1movil.R;

public class FavoritosFragment extends Fragment {
    private GridView grilla;
    private LeatherAdapterFavorite leatherAdapter;

    public FavoritosFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.prod_favorite_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        grilla = getView().findViewById(R.id.grillaZapatos);
        leatherAdapter = new LeatherAdapterFavorite(getContext());
        grilla.setAdapter(leatherAdapter);

        grilla.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View view,int position,long id){
                Leather item = (Leather)parent.getItemAtPosition(position);
                //Toast.makeText(getContext(),"Se ha seleccionado " + item.getName(),Toast.LENGTH_LONG).show();
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
