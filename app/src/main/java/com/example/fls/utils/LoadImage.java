package com.example.fls.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.ImageLoader;

/**
 * Created by HieuHo on 3/2/2017.
 */

public class LoadImage {
    public static LoadImage customImageLoader;
    public static Context context;
    public   RequestQueue requestQueue;
    public static  ImageLoader imageLoader;


    public LoadImage(Context context){
        this.context = context;
        this.requestQueue = getRequestQueue();

        imageLoader = new ImageLoader(requestQueue, new ImageLoader.ImageCache() {
            private final LruCache<String,Bitmap> cache = new LruCache<String,Bitmap>(20);


            @Override
            public Bitmap getBitmap(String url) {
                return cache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                cache.put(url,bitmap);
            }
        });
    }

    public static synchronized LoadImage getInstance(Context context){
        if(customImageLoader == null){
            customImageLoader = new LoadImage(context);
        }
        return customImageLoader;
    }

    public RequestQueue getRequestQueue(){
        if(requestQueue == null){
            Cache cahe = new DiskBasedCache(context.getCacheDir(),10 * 1024 * 1024);
            Network network = new BasicNetwork(new HurlStack());
            requestQueue = new RequestQueue(cahe,network);
            requestQueue.start();
        }
        return requestQueue;
    }
    public ImageLoader getImageLoader(){
        return imageLoader;
    }
}
