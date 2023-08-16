package com.example.reto1movil.Model;

import com.example.reto1movil.R;

//import static android.os.Build.VERSION_CODES.R;

public class Leather {
    private int id;
    private String name;
    private String description;
    private int idDrawable;
    private int price;
    private Leather[] FavoriteItems;
    private String base64Drawable;

    public Leather(int id,String name,String description,int idDrawable, int price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.idDrawable = idDrawable;
        this.price = price;
    }

    public Leather(int id,String name,String description,int idDrawable, int price, String base64Drawable) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.idDrawable = idDrawable;
        this.price = price;
        this.base64Drawable = base64Drawable;
    }

    public Leather(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdDrawable() {
        return idDrawable;
    }

    public void setIdDrawable(int idDrawable) { this.idDrawable = idDrawable; }

    public String getBase64Drawable(){ return base64Drawable; }

    public void setBase64Drawable(String base64Drawable) { this.base64Drawable = base64Drawable; }

    public Leather getFavoriteItems(int pos){
        return FavoriteItems[pos];
    }
    public void setFavoriteItems(Leather[] leather){
        this.FavoriteItems = leather;
    }
    public int getFavoriteCount(){
        return FavoriteItems.length;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public int getPrice() {
        return price;
    }
    public static Leather[] ITEMS = {
            /*new Leather(1,"Clásico negro","Zapato de cuero clásico color negro",R.drawable.formal01,180000),
            new Leather(2,"Clasico marrón","Zapato marrón de cuero clasico",R.drawable.formal02,160000),
            new Leather(3,"Rare","Zapato punta redonda suela blanca",R.drawable.formal03,140000),
            new Leather(4,"Clasico café","Zapato café clásico",R.drawable.formal04,120000),
            new Leather(5,"Mix","Zapato casual suela informal",R.drawable.casual01,140000),
            new Leather(6,"Tenis","Tennis de cuero color miel",R.drawable.casual02,100000),
            new Leather(7,"zapato 7","Zapato sencillo informal",R.drawable.casual03,160000),
            new Leather(8,"Botas","Botas de cuero color miel",R.drawable.casual04,210000),
            new Leather(9,"Gamuza","Zapato de gamuza color café",R.drawable.casual05,180000),
            new Leather(10,"Gánster","Zapato de Gánster de principios del siglo XIX",R.drawable.crazy01,350000),*/
    };

    public static Leather getItem(int id){
        for (Leather leatherActual: ITEMS){
            if(leatherActual.getId() == id){
                return leatherActual;
            }
        }
        return null;
    }
}
