package com.example.taller1fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityDetallePais extends AppCompatActivity {

    TextView textViewPais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pais);

        Bundle bundle = getIntent().getBundleExtra("bundle");
        String nombrePais = bundle.getString("nombrePais");
        String nombrePaisIngles = bundle.getString("nombrePaisIngles");
        String capital = bundle.getString("capital");
        String sigla = bundle.getString("sigla");
        String detallesPais = "Nombre país: "+nombrePais+"\n"+
                "Country name: "+nombrePaisIngles+"\n"+
                "Capital: "+capital+"\n"+
                "Sigla: "+sigla+"\n";

        textViewPais = (TextView)findViewById(R.id.textViewDatosPais);
        textViewPais.setText(detallesPais);
    }
}
