package com.example.tarea3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
//necesitamos que aqui los datos, guardarlos en arrylist y enviarlos al adapter
public class  RecyclerFragment extends Fragment implements View.OnClickListener  {
    private RecyclerView recyclerView;
    private ArrayList<Amigo> Amigos;
    private static final String ARG_PARAM1 = "array";
    private static final String ARG_PARAM2 = "adapter";
    private AmigosAdapter amigosAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Amigos = (ArrayList<Amigo>) getArguments().getSerializable(ARG_PARAM1);
            amigosAdapter = (AmigosAdapter) getArguments().getSerializable(ARG_PARAM2);
        }
        for (int i = 0; i < Amigos.size(); i++) {
            Log.wtf("Amigo", Amigos.get(i).toString());
        }
        amigosAdapter = new AmigosAdapter(Amigos, this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_recycler, container, false);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
 //               Toast.makeText(getActivity(), "BOTON 1 PRESIONADO", Toast.LENGTH_SHORT).show();
            }
        });


        recyclerView = v.findViewById(R.id.recyclerView);
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

    public void onClick(View v) {
        int pos = recyclerView.getChildLayoutPosition(v);
        Toast.makeText(getContext(), Amigos.get(pos).toString(), Toast.LENGTH_SHORT).show();
        InformacionFragment informacionFragment = InformacionFragment.newInstance(Amigos.get(pos));

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.contenedor, informacionFragment ); // give your fragment container id in first parameter
        transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
        transaction.commit();
    }


}