package com.example.adopcionmifa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button btnIrRegis;
    private ImageButton imgbAdop;
    private ImageView imgvAni;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgbAdop = findViewById(R.id.imgbAdop);
        imgvAni = findViewById(R.id.imgvAni);
        imgbAdop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irAdop();
            }
        });
        AnimationDrawable animarAdop = new AnimationDrawable();
        int duracion = 500;
        animarAdop.addFrame(getResources().getDrawable(R.drawable.ani01), duracion);
        animarAdop.addFrame(getResources().getDrawable(R.drawable.ani02), duracion);
        animarAdop.addFrame(getResources().getDrawable(R.drawable.ani03), duracion);
        animarAdop.addFrame(getResources().getDrawable(R.drawable.ani04), duracion);
        animarAdop.addFrame(getResources().getDrawable(R.drawable.ani05), duracion);
        imgvAni.setBackground(animarAdop);
        animarAdop.start();
        btnIrRegis = findViewById(R.id.btnIrRegis);
        btnIrRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegAlu.class));
            }
        });
    }

    private void irAdop() {
        startActivity(new Intent(MainActivity.this, Mascotas.class));
    }
}