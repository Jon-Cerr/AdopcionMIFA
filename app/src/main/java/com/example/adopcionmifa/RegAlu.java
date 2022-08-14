package com.example.adopcionmifa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.sql.Connection;

public class RegAlu extends AppCompatActivity {

    private EditText txtnNoCliente, txteNombreCliente, txtnWhatsApp, txteCorreoReg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_alu);
        txtnNoCliente = findViewById(R.id.txtnNoCliente);
        txteNombreCliente = findViewById(R.id.txteNombreCliente);
        txtnWhatsApp = findViewById(R.id.txtnWhatsApp);
        txteCorreoReg = findViewById(R.id.txteCorreoReg);
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
                registrarUsuario();
                break;
            case R.id.buscar:
                Buscar();
                break;
            case R.id.actualizar:
                Actualizar();
                break;
            case R.id.eliminar:
                Eliminar();
                break;
            case R.id.salir:
                finishAffinity();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void Eliminar() {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "adopcion",
                null, 1);
        SQLiteDatabase DataBase = admin.getWritableDatabase();
        String no_cliente = txtnNoCliente.getText().toString();
        if(!no_cliente.isEmpty()){
            int valor = DataBase.delete("usuarios", "no_cliente = " + no_cliente, null);
            DataBase.close();
            ClearText();
            if (valor == 1){
                Toast.makeText(this, "Usuario eliminado exitosamente", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "No existe el usuario", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Tienes que introducir el numero de cliente", Toast.LENGTH_SHORT).show();
        }
    }

    private void Actualizar(){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "adopcion",
                null, 1);
        SQLiteDatabase DataBase = admin.getWritableDatabase();
        String no_cliente = txtnNoCliente.getText().toString();
        String nombre_cliente = txteNombreCliente.getText().toString();
        String whatsapp = txtnWhatsApp.getText().toString();
        String correo_cliente = txteCorreoReg.getText().toString();
        if(!no_cliente.isEmpty() && !nombre_cliente.isEmpty() && !whatsapp.isEmpty() && !correo_cliente.isEmpty()){
            ContentValues valuesUpdate = new ContentValues();
            valuesUpdate.put("no_cliente", no_cliente);
            valuesUpdate.put("nombre_cliente", nombre_cliente);
            valuesUpdate.put("whatsapp", whatsapp);
            valuesUpdate.put("correo_cliente", correo_cliente);
            int valor = DataBase.update("usuarios", valuesUpdate, "no_cliente = " + no_cliente, null);
            DataBase.close();
            if (valor == 1){
                Toast.makeText(this, "El usuario se modifico correctamente", Toast.LENGTH_SHORT).show();
                ClearText();
            }else{
                Toast.makeText(this, "No existe el usuario", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Tienes que introducir el numero de cliente", Toast.LENGTH_SHORT).show();
        }
    }

    private void Buscar() {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "adopcion",
                null, 1);
        SQLiteDatabase DataBase = admin.getWritableDatabase();
        String no_cliente = txtnNoCliente.getText().toString();
        if (!no_cliente.isEmpty()){
            Cursor cursor = DataBase.rawQuery("select nombre_cliente, whatsapp, correo_cliente from usuarios" +
                    " where no_cliente = " +no_cliente, null);
            if(cursor.moveToFirst()){
                txteNombreCliente.setText(cursor.getString(0));
                txtnWhatsApp.setText(cursor.getString(1));
                txteCorreoReg.setText(cursor.getString(2));
                DataBase.close();
            }else{
                Toast.makeText(this, "No existe el usuario", Toast.LENGTH_SHORT).show();
                DataBase.close();
            }
        }else{
            Toast.makeText(this, "Tienes que introducir el numero de cliente", Toast.LENGTH_SHORT).show();
        }
    }

    private void registrarUsuario() {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "adopcion", null, 1);
        SQLiteDatabase DataBase = admin.getWritableDatabase();

        String no_cliente = txtnNoCliente.getText().toString();
        String nombre_cliente = txteNombreCliente.getText().toString();
        String whatsapp = txtnWhatsApp.getText().toString();
        String correo_cliente = txteCorreoReg.getText().toString();
        if(!no_cliente.isEmpty() &&  !nombre_cliente.isEmpty() && !whatsapp.isEmpty() && !correo_cliente.isEmpty()){
            ContentValues values = new ContentValues();
            values.put("no_cliente", no_cliente);
            values.put("nombre_cliente", nombre_cliente);
            values.put("whatsapp", whatsapp);
            values.put("correo_cliente", correo_cliente);
            DataBase.insert("usuarios", null, values);
            DataBase.close();
            ClearText();
            Toast.makeText(this, "Registro exitoso!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "No deje ningun campo vacio", Toast.LENGTH_SHORT).show();
        }
    }


    private void ClearText(){
        txtnNoCliente.setText("");
        txteNombreCliente.setText("");
        txtnWhatsApp.setText("");
        txteCorreoReg.setText("");
    }
}