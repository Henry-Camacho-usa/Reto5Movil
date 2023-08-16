package com.example.reto1movil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminBDSQLite extends SQLiteOpenHelper {

    public AdminBDSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL("create table FavoriteShoes (idshoes int primary key,name text, description text, drawable text, price int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int version_anterior, int version_nueva) {

    }
}
