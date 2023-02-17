package com.example.actividaduf4_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements OnDatosListener {

    int tam = 24;
    Button btnCambiarTamanio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCambiarTamanio = findViewById(R.id.btnCambiarTamanio);
        btnCambiarTamanio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SizeDialog dd = new SizeDialog();
                dd.setCancelable(false);
                dd.show(getSupportFragmentManager(), "SizeDialog");
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuJava){
            cargarFragmentJava(new JavaFragment());
        }else if (item.getItemId() ==R.id.menuPython){
            cargarFragmentPython(new PythonFragment());
        } else if (item.getItemId() ==R.id.menuSalir) {
            mostrarDialog();
        }

        return super.onOptionsItemSelected(item);
    }

    private void cargarFragmentPython(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, PythonFragment.newInstance(tam))
                .addToBackStack(null).commit();
    }

    private void mostrarDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage(R.string.confirmar_salir);
        builder.setPositiveButton(R.string.btn_aceptar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton(R.string.btn_cancelar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog ad = builder.create();
        ad.setCanceledOnTouchOutside(false);
        ad.show();
    }

    private void cargarFragmentJava(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, fragment)
                .add(R.id.fragmentContainerView, JavaFragment.newInstance(tam)).addToBackStack(null).commit();
    }


    @Override
    public void onAceptarDatosListener(int size) {
        tam = size;
    }

}

