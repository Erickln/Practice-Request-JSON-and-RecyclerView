package com.example.tarea3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
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
public class  RecyclerFragment extends Fragment  {
    private RecyclerView recyclerView;
    private ArrayList<Amigo> amigos;
    private static final String ARG_PARAM1 = "array";
    private static final String ARG_PARAM2 = "adapter";
    private AmigosAdapter amigosAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            amigos = (ArrayList<Amigo>) getArguments().getSerializable(ARG_PARAM1);
            amigosAdapter = (AmigosAdapter) getArguments().getSerializable(ARG_PARAM2);
        }
        for (int i = 0; i < amigos.size(); i++) {
            Log.wtf("Amigo",amigos.get(i).toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_recycler, container, false);
        recyclerView = v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(amigosAdapter);
        return v;
    }

    public static RecyclerFragment newInstance(ArrayList<Amigo> datos,AmigosAdapter amigosAdapter) { //ArrayList<Amigo>

        RecyclerFragment fragment = new RecyclerFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1,datos);
        args.putSerializable(ARG_PARAM2,amigosAdapter);
        fragment.setArguments(args);
        return fragment;
    }

}