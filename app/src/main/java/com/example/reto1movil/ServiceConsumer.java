package com.example.reto1movil;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.reto1movil.Model.Leather;

import org.json.JSONArray;
import org.json.JSONObject;

public class ServiceConsumer {
    RequestQueue requestQueue;
    private static final String URLGet = "https://gb9c30d75e6d169-mga63ta9e63ect6d.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/CienPies/Shoes";
    public ServiceConsumer(Context context){
        requestQueue = Volley.newRequestQueue(context);
        ObjectRequest(context);
    }
    public void ObjectRequest(Context context){
        //Toast.makeText(context,"Va a consumir",Toast.LENGTH_SHORT).show();
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                URLGet,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(context,"Cargando productos...",Toast.LENGTH_SHORT).show();
                        try{
                            JSONArray jsonArray = response.getJSONArray("items");
                            int size = jsonArray.length();
                            Leather[] ITEMSTemp = new Leather[size];
                            for (int i=0;i<size;i++){
                                try{
                                    JSONObject json = new JSONObject(jsonArray.get(i).toString());
                                    String id = json.getString("id");
                                    String name = json.getString("name");
                                    String description = json.getString("description");
                                    String drawable = json.getString("drawable");
                                    String price = json.getString("price");
                                    ITEMSTemp[i] = new Leather(Integer.valueOf(id),name,description,0,Integer.valueOf(price),drawable);
                                    //Toast.makeText(context,"response: " + ITEMSTemp[i].getName(),Toast.LENGTH_SHORT).show();
                                }catch(Exception err){
                                    Toast.makeText(context,"Error: " + err.getMessage(),Toast.LENGTH_SHORT).show();
                                }
                            }
                            LeatherProducts.leatherProds = ITEMSTemp;
                            //Toast.makeText(context,"response->: " + ITEMSCloud[0].getName() + " - " + ITEMSCloud[1].getName(),Toast.LENGTH_SHORT).show();
                        }catch(Exception err){
                            Toast.makeText(context,"Error: " + err.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        requestQueue.add(request);
    }
}
