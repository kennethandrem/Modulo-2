package com.kennethandre.modulo_2;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.content.Context;
import android.content.SharedPreferences;


public class Inicio extends ActionBarActivity {

    private EditText TextNombre;
    private Button btnAceptar;
    private EditText TextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        String email = prefs.getString("email",null);

        if(email != null) {
            Intent intentInicio = new Intent( Inicio.this, MainActivity.class);
            startActivity(intentInicio);
        }

        //Obtenemos una referencia a los controles de la interfaz
        btnAceptar = (Button)findViewById(R.id.button);
        TextNombre = (EditText)findViewById(R.id.editText);
        TextPassword = (EditText)findViewById(R.id.editText2);

        //Implementamos el evento click del boton
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos un Intent
                SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("email", TextNombre.getText().toString());
                editor.putString("nombre", TextPassword.getText().toString());
                editor.commit();

                Intent intent = new Intent(Inicio.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inicio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}