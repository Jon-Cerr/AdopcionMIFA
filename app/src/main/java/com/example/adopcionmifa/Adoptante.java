package com.example.adopcionmifa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class Adoptante extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adoptante);
    }
    public void Programador(View v){
        LayoutInflater caratula = getLayoutInflater();
        Toast programador = new Toast(getApplicationContext());
        View show = caratula.inflate(R.layout.inflate_programacion, null);
        programador.setDuration(Toast.LENGTH_LONG);
        programador.setView(show);
        programador.show();
    }
}