package com.example.taller1fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ActivityListaPaises extends AppCompatActivity {

    ListView listViewPaises;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_paises);

        listViewPaises = (ListView) findViewById(R.id.listViewPaises);

        JSONObject json = null;
        JSONArray paisesJsonArray = null;
        final ArrayList<Pais> listaPaises = new ArrayList<Pais>();
        ArrayList<String> listaNombresPaises = new ArrayList<String>();
        Pais pais = null;

        try {
            json = new JSONObject(loadJSONFromAsset());
            paisesJsonArray = json.getJSONArray("paises");

            for(int i=0; i<paisesJsonArray.length();i++)
            {
                pais = new Pais();
                JSONObject jsonObject = paisesJsonArray.getJSONObject(i);
                pais.setNombrePais(jsonObject.getString("nombre_pais"));
                pais.setNombrePaisIngles(jsonObject.getString("nombre_pais_int"));
                pais.setCapital(jsonObject.getString("capital"));
                pais.setSigla(jsonObject.getString("sigla"));
                listaNombresPaises.add(pais.getNombrePais());
                listaPaises.add(pais);
            }
        } catch (JSONException e)
        {
            e.printStackTrace();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listaNombresPaises);

        listViewPaises.setAdapter(adapter);

        listViewPaises.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Intent intent = new Intent(getBaseContext(), ActivityDetallePais.class);
                Pais paisElegido = listaPaises.get(i);

                Bundle bundle = new Bundle();
                bundle.putString("nombrePais", paisElegido.getNombrePais());
                bundle.putString("nombrePaisIngles", paisElegido.getNombrePaisIngles());
                bundle.putString("capital", paisElegido.getCapital());
                bundle.putString("sigla", paisElegido.getSigla());

                intent.putExtra("bundle", bundle);
                startActivity(intent);
            }
        });
    }

    public String loadJSONFromAsset(){
        String json = null;
        try {
            InputStream is = this.getAssets().open("paises.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
