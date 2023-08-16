package com.example.reto1movil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import com.example.reto1movil.Adapter.LeatherAdapter;
import com.example.reto1movil.Fragment.ProductosFragment;
import com.example.reto1movil.Fragment.ServiciosFragment;
import com.example.reto1movil.Fragment.SucursalesFragment;
import com.example.reto1movil.Fragment.FavoritosFragment;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private LeatherAdapter leatherAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*try{
        Thread.sleep(1000);}catch(InterruptedException err){
            throw new RuntimeException(err);
        }*/
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.icons8_shoes_64);

        setContentView(R.layout.activity_main);

        Fragment productosFragment = new ProductosFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, productosFragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.MenuOptionProductos) {
            Fragment productFragment = new ProductosFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment,productFragment).addToBackStack(null).commit();
            //Toast.makeText(getApplicationContext(),"Seleccion de Productos",Toast.LENGTH_LONG).show();
        }
        if(id == R.id.MenuOptionServicios) {
            Fragment serviciosFragment = new ServiciosFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment,serviciosFragment).addToBackStack(null).commit();
            //Toast.makeText(getApplicationContext(),"Seleccion de Servicios",Toast.LENGTH_LONG).show();
        }
        if(id == R.id.MenuOptionSucursales) {
            /*Fragment sucursalesFragment = new SucursalesFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment,sucursalesFragment).addToBackStack(null).commit();*/
            Fragment mapsFragment = new MapsFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment,mapsFragment).addToBackStack(null).commit();
        }
        if(id == R.id.MenuOptionFavoritos) {
            Fragment favoritosFragment = new FavoritosFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment,favoritosFragment).addToBackStack(null).commit();
        }
        return super.onOptionsItemSelected(item);
    }
}