package com.example.taller1fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button btnCalcularFibonacci, btnFactorial, btnPaises;
    EditText editTextNSecuencia;
    Spinner spinnerFactorial;
    TextView textViewContador;

    ImageView imgFibonacci;

    String currentTime;
    int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnCalcularFibonacci = (Button)findViewById(R.id.btnCalcular);
        imgFibonacci = findViewById(R.id.imgFibonacci);
        btnFactorial = (Button)findViewById(R.id.btnFactorial);
        btnPaises = (Button)findViewById(R.id.btnPaises);
        editTextNSecuencia = (EditText)findViewById(R.id.editTxtNSolicitado);
        spinnerFactorial = (Spinner)findViewById(R.id.spinnerFactorial);
        textViewContador = (TextView)findViewById(R.id.textViewContador);

        // If we have a saved state then we can restore it now
        if (savedInstanceState != null)
        {
            contador = savedInstanceState.getInt("contadorState", 0);
            currentTime = savedInstanceState.getString("timeState");
            textViewContador.setText(String.valueOf(contador) + " veces, en "+ currentTime);
        }else
            {
            contador = 0;
            currentTime = Calendar.getInstance().getTime().toString();
            textViewContador.setText("0 veces, en " + currentTime);
        }

        imgFibonacci.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, WebViewFibonacci.class);
                startActivity(intent);
            }
        });

        btnCalcularFibonacci.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                currentTime = Calendar.getInstance().getTime().toString();
                contador = contador+1;

                String userInput = editTextNSecuencia.getText().toString();

                if (!userInput.matches(""))
                {
                    Intent intent = new Intent(MainActivity.this, MostrarSecuencia.class);

                    String totalPosicionesString = editTextNSecuencia.getText().toString();
                    int totalPosiciones = Integer.parseInt(totalPosicionesString);
                    intent.putExtra("totalPosiciones", totalPosiciones);
                    startActivity(intent);

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"No se ha ingresado ningun valor",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnFactorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                currentTime = Calendar.getInstance().getTime().toString();
                contador = contador+1;

                Intent intent = new Intent(MainActivity.this, ActivityFactorial.class);

                String factorialString = spinnerFactorial.getSelectedItem().toString();
                int factorial = Integer.parseInt(factorialString);
                intent.putExtra("factorial", factorial);
                startActivity(intent);
            }
        });

        btnPaises.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityListaPaises.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();

        if(contador == 1){
            textViewContador.setText("1 vez, en "+currentTime);
        }else if (contador>1) {
            textViewContador.setText(String.valueOf(contador) + " veces, en "+ currentTime);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("contadorState", contador);
        outState.putString("timeState", currentTime);
    }
}
