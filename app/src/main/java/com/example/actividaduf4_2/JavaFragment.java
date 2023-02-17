package com.example.actividaduf4_2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class JavaFragment extends Fragment {

    TextView tvJava;
    private static final String ARG_TAM = "TAMANIO";
    private int tamFragment;


    public JavaFragment() {

    }

    public static JavaFragment newInstance(int ptam) {
        JavaFragment fragment = new JavaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_TAM, ptam);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            tamFragment = getArguments().getInt(ARG_TAM);;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_java, container, false);
        tvJava = vista.findViewById(R.id.tvJava);
        tvJava.setTextSize(TypedValue.COMPLEX_UNIT_SP, tamFragment);
        tvJava.setText(R.string.tv_java);

        return vista;
    }
}