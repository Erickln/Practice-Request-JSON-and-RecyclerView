package com.example.tarea3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements  Handler.Callback {
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler(Looper.getMainLooper(), this);
    }

    public void cargar(View v){

        Request request = new Request("https://raw.githubusercontent.com/AbigailGV/Pruebas/main/amigos.json", handler);
        request.start();
    }

    @Override
    public boolean handleMessage(@NonNull Message msg) {

        try {
            JSONArray data = (JSONArray) msg.obj;

            for (int i = 0; i < data.length(); i++) {
                JSONObject temp = data.getJSONObject(i);

                Log.wtf("JSON", "--------------------------------------");
                Log.wtf("JSON", temp.getString("nombre"));
                Log.wtf("JSON", temp.getString("hobby"));
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
        return true;
    }
}