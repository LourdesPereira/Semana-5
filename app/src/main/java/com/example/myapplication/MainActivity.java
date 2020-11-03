package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;


public class MainActivity extends AppCompatActivity  {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerviewMascota);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar_main);
        setSupportActionBar(myToolbar);

        @SuppressLint("WrongViewCast") ImageView btnHuesoAmarillo = (ImageView) findViewById(R.id.hueso_amarillo);
        @SuppressLint("WrongViewCast") ImageView btnHuesoBlanco = (ImageView) findViewById(R.id.hueso_blanco);


        ArrayList<Mascotas> nameMascota= new ArrayList<>();
        nameMascota.add(new Mascotas("Catty",R.drawable.perro,0));
        nameMascota.add(new Mascotas("Ronny",R.drawable.lobo, 0));

        recyclerView.setHasFixedSize(true);


        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyAdapter(nameMascota);
        recyclerView.setAdapter(mAdapter);

        }
    // Pone los iconos en el menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    //Controla los clicks desde la toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuContacto:
                Intent intentmenuContacto =  new Intent(this, frmContacto.class);
                startActivity(intentmenuContacto);//abro el formualario nueva activity
                return true;

            case R.id.menuAcerca:
                Intent intentmenuAcerca =  new Intent(this, BioActivity.class);
                startActivity(intentmenuAcerca);//abro el formualario nueva activity
                return true;

            case R.id.menuEstrella:

                return true;
            case R.id.menuHuella:

                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }

    };



// Controla los clicks desde las imagenes hueso

    public void OnClickHuesoAmarillo(View v) {

        Mascotas btn = new Mascotas();
        btn.setFavoriteMascote(btn.getFavoriteMascote() + 1);
        TextView MasLikes=(TextView) findViewById(R.id.likes);
        MasLikes.setText(String.valueOf(btn.getFavoriteMascote()));
    };

    public void OnClickHuesoBlanco(View view) {
        Mascotas btn = new Mascotas();
        btn.setVisibleMascota(false);
    };

// Controla los clicks en la barra de menus

}