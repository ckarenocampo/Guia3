package org.dev4u.hv.guia3_ejemplo;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MensajeActivity extends AppCompatActivity {

    private AdaptadorMensaje adaptadorMensaje;
    private Button btnEnviar;
    private ArrayList<Mensaje> mensajeArrayList;
    private TextView contenido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje2);

        contenido = findViewById(R.id.txtEntrada);
        btnEnviar  = findViewById(R.id.btnEnviar);
        mensajeArrayList = new ArrayList<>();
        //Inicializando el adaptador
        adaptadorMensaje = new AdaptadorMensaje(this,  mensajeArrayList);
        //Inicializando el listView
        ListView listView = (ListView) findViewById(R.id.lstMensaje);
        //seteando el adaptador al listview
        listView.setAdapter(adaptadorMensaje);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                Date date = new Date();
                Mensaje m = new Mensaje(contenido.getText().toString(), dateFormat.format(date));
                //TODO agrego a la lista y luego actualizo el adaptador, de lo contrario no se mostraria el cambio
                mensajeArrayList.add(m);
                adaptadorMensaje.notifyDataSetChanged();

            }
        });

    }
}
