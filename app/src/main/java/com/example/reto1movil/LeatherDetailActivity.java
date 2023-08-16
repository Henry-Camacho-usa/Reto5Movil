package com.example.reto1movil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.reto1movil.Model.Leather;

import com.example.reto1movil.database.DatabaseActions;

public class LeatherDetailActivity extends AppCompatActivity {

    private ImageView leatherImg;
    private TextView leatherTitle;
    private TextView leatherDescription;
    private TextView leatherPrice;
    private Button botonComprar;
    private Button botonVolver;
    private Button botonGuardar;
    private Button botonQuitar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.icons8_shoes_64);

        setContentView(R.layout.leather_detail);

        int id = getIntent().getExtras().getInt("leather_id");
        String leather_name = getIntent().getExtras().getString("leather_name");
        String leather_description = getIntent().getExtras().getString("leather_description");
        //int leather_drawable = getIntent().getExtras().getInt("leather_drawable");
        String leather_drawable = getIntent().getExtras().getString("leather_drawable");
        int leather_price = getIntent().getExtras().getInt("leather_price");

        leatherImg = (ImageView) findViewById(R.id.leatherDetailImage);
        leatherTitle = (TextView) findViewById(R.id.leatherDetailTitle);
        leatherDescription = (TextView) findViewById(R.id.leatherDescription);
        leatherPrice = (TextView) findViewById(R.id.leatherPrice);

        //leatherImg.setImageResource(leather_drawable);
        String base64String = leather_drawable;
        byte[] decodedString = Base64.decode(base64String, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        leatherImg.setImageBitmap(decodedByte);
        leatherTitle.setText(leather_name);
        leatherDescription.setText(leather_description);
        leatherPrice.setText(String.valueOf(leather_price));

        botonComprar = (Button) findViewById(R.id.botonComprar);
        botonVolver = (Button) findViewById(R.id.botonVolver);
        botonGuardar = (Button) findViewById(R.id.botonGuardar);
        botonQuitar = (Button) findViewById(R.id.botonQuitar);

        botonComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Has agregado el producto al carrito", Toast.LENGTH_SHORT).show();
            }
        });

        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    DatabaseActions dataBaseActions = new DatabaseActions();
                    dataBaseActions.idShoes = getIntent().getExtras().getInt("leather_id");
                    dataBaseActions.nameShoes = getIntent().getExtras().getString("leather_name");
                    dataBaseActions.descriptionShoes = getIntent().getExtras().getString("leather_description");
                    dataBaseActions.drawableShoes = getIntent().getExtras().getString("leather_drawable");
                    dataBaseActions.precioShoes = getIntent().getExtras().getInt("leather_price");
                    dataBaseActions.InsertarFavorito(getApplicationContext());
                    //Toast.makeText(getApplicationContext(),"Esta intentando guardar un item en su app", Toast.LENGTH_SHORT).show();
                }catch(Exception err){
                    Toast.makeText(getApplicationContext(),"ERROR " + err.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        botonQuitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    DatabaseActions dataBaseActions = new DatabaseActions();
                    dataBaseActions.idShoes = getIntent().getExtras().getInt("leather_id");
                    Toast.makeText(getApplicationContext(),"Vas a borrar el Item " + dataBaseActions.idShoes, Toast.LENGTH_SHORT).show();
                    /*dataBaseActions.nameShoes = getIntent().getExtras().getString("leather_name");
                    dataBaseActions.descriptionShoes = getIntent().getExtras().getString("leather_description");
                    dataBaseActions.precioShoes = 0;*/
                    dataBaseActions.Quitar(getApplicationContext());
                    //Toast.makeText(getApplicationContext(),"Esta intentando guardar un item en su app", Toast.LENGTH_SHORT).show();
                }catch(Exception err){
                    Toast.makeText(getApplicationContext(),"ERROR " + err.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
