package com.example.tarea3;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

public class AmigosAdapter extends RecyclerView.Adapter<AmigosAdapter.AmigoViewHolder> implements Serializable {

    public class AmigoViewHolder extends RecyclerView.ViewHolder implements Serializable {

        public TextView nombre, hobby;

        public AmigoViewHolder(@NonNull View itemView) {
            super(itemView);

            nombre = itemView.findViewById(R.id.nameText);
            hobby = itemView.findViewById(R.id.hobyText);
        }
    }

    private ArrayList<Amigo> amigos;
    private View.OnClickListener listener;

    public AmigosAdapter(ArrayList<Amigo> amigos, View.OnClickListener listener){
        this.amigos     = amigos;
        this.listener   = listener;
    }

    @NonNull
    @Override
    public AmigoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.fila, parent, false);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //cambia al fragmento de info
            }
        });

        v.setOnClickListener(listener);

        AmigoViewHolder pvh = new AmigoViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull AmigoViewHolder holder, int position) {

        //asociar con datos de amigos recibidos del RecyclerFragment
        holder.nombre.setText(amigos.get(position).nombre);
        holder.hobby.setText(amigos.get(position).hobby);
    }

    @Override
    public int getItemCount() {
        return amigos.size();
    }


}

