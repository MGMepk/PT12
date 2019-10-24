package com.manuelgarcia.pt12;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


    public void setMayus(View view){
        EditText edit = (EditText) findViewById(R.id.text);
        String message = edit.getText().toString();
        edit.setText(message.toUpperCase());

    }

    //Convierte el texto introducido en minúsculas.
    public void setMinus(View view){
        EditText edit = (EditText) findViewById(R.id.text);
        String message = edit.getText().toString();
        edit.setText(message.toLowerCase());
    }

    //Convierte la primera letra de cada palabra el texto introducido en mayúsculas.
    public void setCaps(View view){
        EditText edit = (EditText) findViewById(R.id.text);
        String message = edit.getText().toString().toLowerCase();
        if(message.length() <= 0){
            String messn = "El valor del text és null";
            Toast toast = Toast.makeText(this,messn,Toast.LENGTH_LONG);
            toast.show();
        } else {
            char[] caracteres = message.toCharArray();
            caracteres[0] = Character.toUpperCase(caracteres[0]);
            for (int i = 0; i < message.length(); i++)
                // Es 'palabra'
                if (caracteres[i] == ' ' || caracteres[i] == '.' || caracteres[i] == ',')
                    // Reemplazamos
                    caracteres[i + 1] = Character.toUpperCase(caracteres[i + 1]);

            String text = new String(caracteres);
            edit.setText(text);
        }
    }

}
