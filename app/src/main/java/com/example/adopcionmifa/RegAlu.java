package com.example.adopcionmifa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.sql.Connection;

public class RegAlu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_alu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.registrar:
                Toast.makeText(this, "Se ha seleccionado registrar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buscar:
                Toast.makeText(this, "Se ha seleccionado buscar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.actualizar:
                Toast.makeText(this, "Se ha seleccionado actualizar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.eliminar:
                Toast.makeText(this, "Se ha seleccionado eliminar", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void registrarUsuario(){
        ConnectionSQLiteHelper conn = new ConnectionSQLiteHelper(this, "bd_usu", null, 1);
    }
}