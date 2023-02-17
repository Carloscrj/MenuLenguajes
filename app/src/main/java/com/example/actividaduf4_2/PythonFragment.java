package com.example.actividaduf4_2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PythonFragment extends Fragment {

    TextView tvPython;
    private static final String ARG_TAM = "TAMANIO";
    private int tamFragment;


    public PythonFragment() {

    }

    public static PythonFragment newInstance(int ptam) {
        PythonFragment fragment = new PythonFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_TAM, ptam);;
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
        View vista = inflater.inflate(R.layout.fragment_python, container, false);
        tvPython = vista.findViewById(R.id.tvPython);
        tvPython.setTextSize(TypedValue.COMPLEX_UNIT_SP, tamFragment);
        tvPython.setText(R.string.tv_python);

        return vista;
    }
}