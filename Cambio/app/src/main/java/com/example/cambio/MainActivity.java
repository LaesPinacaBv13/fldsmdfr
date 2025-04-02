package com.example.cambio;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private EditText inputCantidad;
    private TextView resultado;
    private RadioGroup grupoDe, grupoA;
    private Button btnConvertir;
    private HashMap<String, Double> tasasConversion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputCantidad = findViewById(R.id.inputCantidad);
        resultado = findViewById(R.id.resultado);
        grupoDe = findViewById(R.id.grupoDe);
        grupoA = findViewById(R.id.grupoA);
        btnConvertir = findViewById(R.id.btnConvertir);

        tasasConversion = new HashMap<>();
        tasasConversion.put("Dólar-Euro", 0.91);
        tasasConversion.put("Euro-Dólar", 1.1);
        tasasConversion.put("Libra-Dólar", 1.3);
        tasasConversion.put("Dólar-Libra", 0.77);
        tasasConversion.put("Rupia-Dólar", 0.012);
        tasasConversion.put("Dólar-Rupia", 83.2);
        tasasConversion.put("Real-Dólar", 0.19);
        tasasConversion.put("Dólar-Real", 5.3);
        tasasConversion.put("Peso-Dólar", 0.059);
        tasasConversion.put("Dólar-Peso", 17.0);
        tasasConversion.put("Yuan-Dólar", 0.14);
        tasasConversion.put("Dólar-Yuan", 7.1);
        tasasConversion.put("Yen-Dólar", 0.0068);
        tasasConversion.put("Dólar-Yen", 146.7);
        tasasConversion.put("Sol-Dólar", 0.27);
        tasasConversion.put("Dólar-Sol", 3.7);

        btnConvertir.setOnClickListener(v -> convertirMoneda());
    }

    private void convertirMoneda() {
        String de = obtenerSeleccion(grupoDe);
        String a = obtenerSeleccion(grupoA);
        double cantidad = Double.parseDouble(inputCantidad.getText().toString());
        String clave = de + "-" + a;
        double resultadoConversion = tasasConversion.getOrDefault(clave, 1.0) * cantidad;
        resultado.setText(String.format("%.2f %s", resultadoConversion, a));
    }

    private String obtenerSeleccion(RadioGroup grupo) {
        int idSeleccionado = grupo.getCheckedRadioButtonId();
        if (idSeleccionado == -1) return "";
        return ((RadioButton) findViewById(idSeleccionado)).getText().toString();
    }
}
