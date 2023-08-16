package com.example.reto1movil;

import android.content.Context;

public class ThreadWebService extends Thread{
    Context context;
    public void run(){
        ServiceConsumer SC = new ServiceConsumer(context);
    }
}
