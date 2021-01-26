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
    private ArrayList<String> datos;
    private static final String ARG_PARAM1 = "nombre";
    private static final String ARG_PARAM2 = "hobby";
    private static final String ARG_PARAM3 = "edad";
    private static final String ARG_PARAM4 = "telefono";
    private static final String ARG_PARAM5 = "direccion";


    private String  nombre;
    private String  hobby;
    private int     edad;
    private int     telefono;
    private String  direccion;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            nombre      = getArguments().getString(ARG_PARAM1);
            hobby       = getArguments().getString(ARG_PARAM2);
            edad        = Integer.parseInt(getArguments().getString(ARG_PARAM2));
            telefono    = Integer.parseInt(getArguments().getString(ARG_PARAM2));
            direccion   = getArguments().getString(ARG_PARAM2);
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

    public static RecyclerFragment newInstance(ArrayList<String> datos) { //ArrayList<Amigo>

        RecyclerFragment fragment = new RecyclerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, datos.get(0));
        args.putString(ARG_PARAM2, datos.get(1));
        args.putString(ARG_PARAM3, datos.get(2));
        args.putString(ARG_PARAM4, datos.get(3));
        args.putString(ARG_PARAM5, datos.get(4));
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onClick(View v) {
    //podriamos hacer que este metodo cambie al fragmento de informacion y que envie la informacion
    //que necesitamos desplegar (investigar si el adapter lo hace o este método)
    }

}