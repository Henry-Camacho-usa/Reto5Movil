package com.example.reto1movil.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Toast;

import com.example.reto1movil.AdminBDSQLite;
import com.example.reto1movil.Model.Leather;

public class DatabaseActions {

    public int idShoes;
    public String nameShoes;
    public String descriptionShoes;
    //public int drawableShoes;
    public String drawableShoes;
    public int precioShoes;

    public void InsertarFavorito(Context context){
        AdminBDSQLite admin = new AdminBDSQLite(context,"administracion",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        try {
            ContentValues registro = new ContentValues();
            registro.put("idshoes", idShoes);
            registro.put("name", nameShoes);
            registro.put("description", descriptionShoes);
            registro.put("drawable", drawableShoes);
            registro.put("price", precioShoes);

            bd.insertOrThrow("FavoriteShoes", null, registro);
            bd.close();

            Toast.makeText(context, "Este producto ahora es parte de tus favoritos", Toast.LENGTH_SHORT).show();
        }catch (Exception err){
            Toast.makeText(context, "Este item ya hace parte de tus favoritos " + err.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public Leather[] ConsultarFavoritos(Context context){
        AdminBDSQLite admin = new AdminBDSQLite(context,"administracion",null,1);
        SQLiteDatabase bd = admin.getReadableDatabase();
        Leather[] favoriteReturn = null;
        try{
            String cod = String.valueOf(idShoes);
            Cursor fila = bd.rawQuery("SELECT idshoes, name, description, drawable, price FROM FavoriteShoes",null);
            int cont = 0;
            favoriteReturn = new Leather[fila.getCount()];
            while (fila.moveToNext()){
                String idShoes = fila.getString(0);
                String name = fila.getString(1);
                String desc = fila.getString(2);
                String drawable = fila.getString(3);
                String prec = fila.getString(4);
                //Leather ltr = new Leather(Integer.valueOf(idShoes),name,desc,Integer.valueOf(drawable),Integer.valueOf(prec));
                Leather ltr = new Leather(Integer.valueOf(idShoes),name,desc,0,Integer.valueOf(prec),drawable);
                favoriteReturn[cont] = ltr;
                cont += 1;
            }
            fila.close();
            return favoriteReturn;
        }catch(Exception err){
            Toast.makeText(context, "ERROR " + err.getMessage(), Toast.LENGTH_SHORT).show();
        }
        bd.close();
        return favoriteReturn;
    }

    public void Quitar(Context context){
        AdminBDSQLite admin = new AdminBDSQLite(context,"administracion",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        try{
            String id = String.valueOf(idShoes);
            int cantidad = bd.delete("FavoriteShoes","idshoes=" + id,null);
            if (cantidad >= 1){
                Toast.makeText(context, "Este Item ya no es uno de tus favoritos", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context, "Este Item no es parte de tus favoritos", Toast.LENGTH_SHORT).show();
            }
        }catch(Exception err){
            Toast.makeText(context, "ERROR " + err.getMessage(), Toast.LENGTH_SHORT).show();
        }
        bd.close();
    }
}
