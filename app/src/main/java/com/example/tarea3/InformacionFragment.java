package com.example.tarea3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InformacionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InformacionFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private static final String ARG_PARAM1 = "amigo";

    // TODO: Rename and change types of parameters
    private Amigo amigo;

    public InformacionFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param amigo Parameter 1.
     * @return A new instance of fragment InformacionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InformacionFragment newInstance(Amigo amigo) {
        InformacionFragment fragment = new InformacionFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, amigo);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            amigo = (Amigo) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_informacion, container, false);
        TextView nombre     = v.findViewById(R.id.nombreText);
        TextView hobby      = v.findViewById(R.id.hobbyText);
        TextView edad       = v.findViewById(R.id.edadText);
        TextView telefono   = v.findViewById(R.id.telefonoText);
        TextView direccion  = v.findViewById(R.id.direccionText);
        nombre.setText(amigo.nombre);
        hobby.setText(amigo.hobby);
        edad.setText(amigo.edad+"");
        telefono.setText(amigo.telefono+"");
        direccion.setText(amigo.direccion);

        return v;
    }
}