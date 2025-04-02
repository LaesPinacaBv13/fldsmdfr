package com.example.moneda;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;
import android.content.Context;


public class MainActivity extends AppCompatActivity {
    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText) findViewById(R.id.editTextText);

        @SuppressLint("MissingInflatedId") GridView gridView = (GridView) findViewById(R.id.dinamico);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void miClicManejador(View view) {
        if (view.getId() == R.id.btnConvertir) {
            RadioButton dolaresButton = (RadioButton)
                    findViewById(R.id.radio0);
            RadioButton solesButton = (RadioButton)
                    findViewById(R.id.radio1);
            if (text.getText().length() == 0) {
                Toast.makeText(this, "Ingresa un número válido",
                        Toast.LENGTH_LONG).show();
                return;
            }
            float inputValue = Float.parseFloat(text.getText().toString());
            if (dolaresButton.isChecked()) {
                text.setText(String
                        .valueOf(convierteDolaresASoles(inputValue)));
                dolaresButton.setChecked(false);
                solesButton.setChecked(true);
            } else {
                text.setText(String
                        .valueOf(convierteSolesADolares(inputValue)));
                solesButton.setChecked(false);
                dolaresButton.setChecked(true);
            }
        }
    }

    private double convierteSolesADolares(float soles) {
        return (soles/3.8);
    }
    // Convierte a soles
    private double convierteDolaresASoles(float dolares) {
        return (dolares*3.8);
    }

    public class ImageAdapter extends BaseAdapter {
        private Context mContexto;

        public ImageAdapter(Context c) {
            mContexto = c;
        }

        public int getCount() {
            return mListaIds.length;
        }

        public Object getItem(int posicion) {
            return null;
        }

        public long getItemId(int posicion) {
            return 0;
        }

        public View getView(int posicion, View converVista, ViewGroup padre) {
            ImageView imgVista = new ImageView(mContexto);
            imgVista.setImageResource(mListaIds[posicion]);
            return imgVista;
        }

        private Integer[] mListaIds = {
                R.drawable.cel1,
                R.drawable.cel2,
                R.drawable.cel3
        };
    }

}

