package com.example.tsdmh_75s_prac5_lmua;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import Informacion.DatosDTO;

public class PrincipalActivity extends AppCompatActivity {

    EditText txtnombre, txtedad, txtcorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtnombre = findViewById(R.id.txtnombre);
        txtedad = findViewById(R.id.txtedad);
        txtcorreo = findViewById(R.id.txtcorreo);
    }

    public void clickbtn(View v) {
        String nombre = txtnombre.getText().toString().trim();
        String edadStr = txtedad.getText().toString().trim();
        String correo = txtcorreo.getText().toString().trim();

        if (nombre.isEmpty()) {
            txtnombre.setError("Ingrese su nombre");
            return;
        }
        if (edadStr.isEmpty()) {
            txtedad.setError("Ingrese su edad");
            return;
        }
        if (correo.isEmpty()) {
            txtcorreo.setError("Ingrese su correo");
            return;
        }

        int edad;
        try {
            edad = Integer.parseInt(edadStr);
        } catch (NumberFormatException e) {
            txtedad.setError("Edad inválida");
            return;
        }

        DatosDTO datos = new DatosDTO(nombre, edad, correo);
        Intent intent = new Intent(this, RecibeActivity.class);
        intent.putExtra("Datos", datos);
        startActivity(intent);
    }
}