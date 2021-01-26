package com.example.tarea3;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AmigosAdapter extends RecyclerView.Adapter<AmigosAdapter.AmigosViewHolder> {

    // definir un view holder
    // - un objeto que se encarga de administrar una vista de renglón
    public class AmigosViewHolder extends RecyclerView.ViewHolder {

        public TextView texto1, texto2;

        public AmigosViewHolder(@NonNull View itemView) {
            super(itemView);
            texto1 = itemView.findViewById(R.id.nameText);
            texto2 = itemView.findViewById(R.id.hobbyText);

        }
    }

    // extremadamente común, casi regla
    // referencia a fuente de datos
    private ArrayList<Amigo> Amigos;
    private View.OnClickListener listener;

    public AmigosAdapter(ArrayList<Amigo> Amigos, View.OnClickListener listener){
        this.Amigos = Amigos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AmigosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // crear view específica de renglón
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.fila, parent, false);
        Button b = v.findViewById(R.id.imageView2);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.wtf("BOTONAZO", "BOTON PRESIONADO");
            }
        });

        v.setOnClickListener(listener);

        AmigosViewHolder pvh = new AmigosViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull AmigosViewHolder holder, int position) {

        // asocia un viewholder con datos en particular
        holder.texto1.setText(Amigos.get(position).nombre);
        holder.texto2.setText(Amigos.get(position).hobby);
    }

    @Override
    public int getItemCount() {
        return Amigos.size();
    }


}
