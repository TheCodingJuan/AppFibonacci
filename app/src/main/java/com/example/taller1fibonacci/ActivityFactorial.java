package com.example.taller1fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityFactorial extends AppCompatActivity {

    TextView textViewFactorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factorial);

        Intent intent = getIntent();
        int factorial = intent.getIntExtra("factorial",10);

        String multiplicacion = multiplicacionFactorial(factorial);
        int resultado = resultadoFactorial(factorial);

        String cadena = "Multiplicación = "+multiplicacion+"\nResultado: "
                +String.valueOf(resultado);

        textViewFactorial = (TextView)findViewById(R.id.textViewFactorial);
        textViewFactorial.setText(cadena);
    }

    public int resultadoFactorial(int numero){
        int resultado = 1;
        for (int i = 2; i <= numero; i++) {
            resultado = resultado * i;
        }
        return resultado;
    }

    public String multiplicacionFactorial(int numero)
    {
        if(numero == 1)
        {
            return "1";
        }else {
            String resultado = "1";
            for (int i = 2; i <= numero; i++)
            {
                resultado = resultado + "*" + String.valueOf(i);
            }
            return resultado;
        }
    }
}
