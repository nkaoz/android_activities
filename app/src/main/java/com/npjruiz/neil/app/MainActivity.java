package com.npjruiz.neil.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList <Contacto> contactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto("Neil Ruiz", "989898900", "nkaoz_0@hotmail.com"));
        contactos.add(new Contacto("Paul Ruiz", "912345678", "nkaoz_1@hotmail.com"));
        contactos.add(new Contacto("John Ruiz", "912345678", "nkaoz_2@hotmail.com"));
        contactos.add(new Contacto("Jose Ruiz", "999999999", "nkaoz_3@hotmail.com"));
        contactos.add(new Contacto("Hidu", "981218900", "nkaoz_4@hotmail.com"));

        ArrayList<String> nombresContacto= new ArrayList<>();
        for (Contacto contacto:contactos) {
            nombresContacto.add(contacto.getNombre());
        }

        ListView lstContactos = (ListView) findViewById(R.id.listView);
        lstContactos.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombresContacto));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre),contactos.get(i).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono),contactos.get(i).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail),contactos.get(i).getEmail());
                startActivity(intent);
                finish();
            }
        });
    }
}
