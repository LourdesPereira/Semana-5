package com.example.myapplication;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class frmContacto extends AppCompatActivity {
    private View btn;
    public EditText pname;
    public EditText pMAil;
    public EditText pComent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frmcontacto);
        Button btn = (Button) findViewById(R.id.btnEnviar);
        pname=(EditText) findViewById(R.id.editName);
        pMAil=(EditText) findViewById(R.id.editMail);
        pComent=(EditText) findViewById(R.id.editComentario);


    btn.setOnClickListener(new View.OnClickListener(){

        @Override
        public void onClick(View view) {


            Intent intent =  new Intent(Intent.ACTION_SEND);

            intent.putExtra(Intent.EXTRA_SUBJECT,pname.getText().toString());
            intent.putExtra(Intent.EXTRA_EMAIL,pMAil.getText().toString());
            intent.putExtra(Intent.EXTRA_TEXT,pComent.getText().toString());
            // Establezco el tipo de Intent
            intent.setType("message/rfc822");

            startActivity(intent.createChooser(intent,"Seleccione la app de mail para enviar este mensaje")); //abro la url en una nueva activity

        }
    });
}
}
