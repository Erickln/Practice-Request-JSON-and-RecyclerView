package com.example.tarea3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
//necesitamos que aqui los datos, guardarlos en arrylist y enviarlos al adapter
public class  RecyclerFragment extends Fragment implements View.OnClickListener {
    private RecyclerView recyclerView;
    private ArrayList<Amigo> amigos;
    private static final String ARG_PARAM1 = "array";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            amigos = (ArrayList<Amigo>) getArguments().getSerializable(ARG_PARAM1);
        }
        for (int i = 0; i < amigos.size(); i++) {
            Log.wtf("Amigo",amigos.get(i).toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recycler, container, false);
        recyclerView = v.findViewById(R.id.recyclerView);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        return v;
    }

    public static RecyclerFragment newInstance(ArrayList<Amigo> datos) { //ArrayList<Amigo>

        RecyclerFragment fragment = new RecyclerFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1,datos);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onClick(View v) {
    //podriamos hacer que este metodo cambie al fragmento de informacion y que envie la informacion
    //que necesitamos desplegar (investigar si el adapter lo hace o este método)
    }

}