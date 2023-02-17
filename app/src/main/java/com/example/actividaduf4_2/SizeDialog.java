package com.example.actividaduf4_2;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.snackbar.Snackbar;

public class SizeDialog extends DialogFragment {

    TextView tvTamanio;
    EditText etTamanio;
    OnDatosListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View v = getActivity().getLayoutInflater().inflate(R.layout.dialog_size, null);
        etTamanio = v.findViewById(R.id.etTamanio);


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(v);

        builder.setTitle(R.string.title).setPositiveButton(R.string.btn_aceptar, null)
                .setNegativeButton(R.string.btn_cancelar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

        AlertDialog ad = builder.create();
        ad.setCanceledOnTouchOutside(false);


        ad.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                Button btn = ((AlertDialog) dialogInterface).getButton(DialogInterface.BUTTON_POSITIVE);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String size = etTamanio.getText().toString();

                        if (size.isEmpty() || Integer.parseInt(size) < 1) {
                            Snackbar.make(btn, R.string.error_datos, Snackbar.LENGTH_LONG).show();
                        } else {
                            dialogInterface.dismiss();
                            //invocamos al metodo cuando los campos estan llenos o correctos
                            listener.onAceptarDatosListener(Integer.parseInt(size));
                        }
                    }
                });
            }
        });
        return ad;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnDatosListener) {
            listener = (OnDatosListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnDatosListener ");
        }

    }


    @Override
    public void onDetach() {
        if (listener != null){
            listener = null;
        }
        super.onDetach();
    }


}
