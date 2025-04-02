package com.example.interfaceregistroestudiante;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputEditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText etNombre, etApellido, etDni, etCodigo;
    private TextView tvMensaje;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        etNombre = findViewById(R.id.nombre);
        etApellido = findViewById(R.id.apellido);
        etDni = findViewById(R.id.dni);
        etCodigo = findViewById(R.id.codigo);
        tvMensaje = findViewById(R.id.tvMensaje);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvMensaje.setVisibility(View.VISIBLE);

                etNombre.setText("");
                etApellido.setText("");
                etDni.setText("");
                etCodigo.setText("");

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        tvMensaje.setVisibility(View.GONE);
                    }
                }, 3000);
            }
        });
    }
}
