package com.manuelgarcia.pt12;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
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

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            startActivity(new Intent(this, Preferences.class));
            return true;
        } else if (id == R.id.help) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://escoladeltreball.org"));
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void setMayus(View view) {
        EditText edit = findViewById(R.id.text);
        String message = edit.getText().toString();
        edit.setText(message.toUpperCase());

    }

    //Convierte el texto introducido en minúsculas.
    public void setMinus(View view) {
        EditText edit = findViewById(R.id.text);
        String message = edit.getText().toString();
        edit.setText(message.toLowerCase());
    }

    //Convierte la primera letra de cada palabra el texto introducido en mayúsculas.
    public void setCaps(View view) {
        EditText edit = findViewById(R.id.text);
        String message = edit.getText().toString().toLowerCase();
        if (message.isEmpty()) {
            String messn = "El valor del text és null";
            Toast.makeText(this, messn, Toast.LENGTH_LONG).show();
        } else {
            char[] caracteres = message.toCharArray();
            caracteres[0] = Character.toUpperCase(caracteres[0]);
            for (int i = 0; i < message.length(); i++)
                // Es 'palabra'
                if (caracteres[i] == ' ' || caracteres[i] == '.' || caracteres[i] == ',')
                    // Reemplazamos
                    caracteres[i + 1] = Character.toUpperCase(caracteres[i + 1]);

            edit.setText(new String(caracteres));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences sharPref = PreferenceManager.getDefaultSharedPreferences(this);
        String mess = sharPref.getString("preference_message", "Benvingut");
        Toast.makeText(this, mess, Toast.LENGTH_LONG).show();

        try {
            Log.i("MainActivity", mess);

            LinearLayout layout = findViewById(R.id.prefLayout);

            if (sharPref.getBoolean("preference_color", false)) {
                layout.setBackgroundColor(Color.BLUE);
            } else {
                layout.setBackgroundColor(Color.GREEN);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

    }

}
