package com.example.andreadellaporta.explainmypain;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by andreadellaporta on 25/01/17.
 */

public class RequestHandlerD {
    private static RequestHandlerD mInstance;
    private RequestQueue mRequestQueue;
    private static Context mCtx;

    private RequestHandlerD(Context context) {
        mCtx = context;
        mRequestQueue = getRequestQueue();

    }

    public static synchronized RequestHandlerD getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new RequestHandlerD(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }


}
