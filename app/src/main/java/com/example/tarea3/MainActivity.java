package com.example.tarea3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  Handler.Callback{

    private static final String TAG_FRAGMENTO = "fragmento";
    private Handler handler;
    private RecyclerView recyclerView;
    private RecyclerFragment recyclerFragment;
    AmigosAdapter adapter;

    ArrayList<Amigo> Amigos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler(Looper.getMainLooper(), this);

//        GridLayoutManager glm = new GridLayoutManager(this, 2);

       // recyclerView.setAdapter(adapter);
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
        recyclerFragment = RecyclerFragment.newInstance(Amigos);
   //     cambiarFragmento(recyclerFragment);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.contenedor, recyclerFragment);
        transaction.commit();
    }

    public void cambiarFragmento(Fragment nuevo){
        // como obtener referencia a un fragmento ya agregado
        FragmentManager manager = getSupportFragmentManager();
        Fragment f = manager.findFragmentByTag(TAG_FRAGMENTO);
        FragmentTransaction transaction = manager.beginTransaction();

        // si el fragmento que queremos agregar es el que ya está
        if(nuevo == f)
            return;

        if(f != null){
            transaction.remove(f);
        }

        transaction.add(R.id.contenedor, nuevo, TAG_FRAGMENTO);
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
                Log.wtf("JSON", temp.getString("edad"));
                Log.wtf("JSON", temp.getString("telefono"));
                Log.wtf("JSON", temp.getString("direccion"));
                String nombre       = temp.getString("nombre");
                String hobby        = temp.getString("hobby");
                int edad            = temp.getInt("edad");
                int telefono        = temp.getInt("telefono");
                String direccion    = temp.getString("direccion");
                Amigos.add(new Amigo(nombre,hobby,edad,telefono,direccion));
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
        return true;
    }


}