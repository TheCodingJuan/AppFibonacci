package com.example.taller1fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MostrarSecuencia extends AppCompatActivity {

    LinearLayout layoutConScroll;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_secuencia);

        layoutConScroll = (LinearLayout)findViewById(R.id.layoutConScroll);

        Intent intent = getIntent();

        int totalPosiciones = intent.getIntExtra("totalPosiciones",1);

        TextView txtViewNuevo;

        if(totalPosiciones >= 1)
        {
            txtViewNuevo = new TextView(this);
            txtViewNuevo.setText(String.valueOf(0));
            layoutConScroll.addView(txtViewNuevo);
        }
        if(totalPosiciones >= 2) {
            txtViewNuevo = new TextView(this);
            txtViewNuevo.setText(String.valueOf(1));
            layoutConScroll.addView(txtViewNuevo);
        }
        if(totalPosiciones >= 3)
        {

            long num1 = 0, num2 = 1, next;

            for (int i = 0; i < (totalPosiciones - 2); i++)
            {

                next = fibonacci(num1, num2);
                num1 = num2;
                num2 = next;

                txtViewNuevo = new TextView(this);
                txtViewNuevo.setText(String.valueOf(next));
                layoutConScroll.addView(txtViewNuevo);
            }
        }
    }

    long fibonacci(long n1, long n2){
        return n1+n2;
    }
}
