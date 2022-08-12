package com.example.adopcionmifa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

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
    }

    private void irAdop() {
        startActivity(new Intent(MainActivity.this, Mascotas.class));
    }
}