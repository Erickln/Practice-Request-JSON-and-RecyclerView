package com.example.tarea3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  Handler.Callback {
    private Handler handler;
    private RecyclerView recyclerView;
    private RecyclerFragment recyclerFragment;

    private String nombre;
    private String hobby;
    private int edad;
    private int telefono;
    private String direccion;

    ArrayList<Amigo> array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler(Looper.getMainLooper(), this);

        /*recyclerView = findViewById(R.id.recyclerView);
        InformacionFragment IF = new InformacionFragment();


        // layout manager
        // define cómo se van a organizar los elementos en el recycler view
/*        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        GridLayoutManager glm = new GridLayoutManager(this, 2);

        recyclerView.setLayoutManager(llm);*/

    }

    public void cargar(View v){
        Request request = new Request("https://raw.githubusercontent.com/AbigailGV/Pruebas/main/amigos.json", handler);
        request.start();
        recyclerFragment = RecyclerFragment.newInstance(array);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.contenedor,recyclerFragment,"recyclerFragmento");
        transaction.commit();
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