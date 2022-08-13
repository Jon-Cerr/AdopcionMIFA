package com.example.adopcionmifa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Adoptante extends AppCompatActivity {

    public CheckBox chkWha, chkCorr;
    private EditText txtnCer, txteNoAd, txteWhat, txteCorreo, txteNoMas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adoptante);
        chkWha = findViewById(R.id.chkWha);
        chkCorr = findViewById(R.id.chkCorr);
        txtnCer = findViewById(R.id.txtnCer);
        txteNoAd = findViewById(R.id.txteNoAd);
        txteWhat = findViewById(R.id.txteWhat);
        txteCorreo = findViewById(R.id.txteCorreo);
        txteNoMas = findViewById(R.id.txteNoMas);
    }
    public void Programador(View v){
        LayoutInflater caratula = getLayoutInflater();
        Toast programador = new Toast(getApplicationContext());
        View show = caratula.inflate(R.layout.inflate_programacion, null);
        programador.setDuration(Toast.LENGTH_LONG);
        programador.setView(show);
        programador.show();
    }
    public void Certi(View v){
        if(chkWha.isChecked() && chkCorr.isChecked()){
            String WhatsApp = txteWhat.getText().toString().trim();
            String Correo = txteCorreo.getText().toString().trim();
            almacenarDatos(WhatsApp, Correo);
        }else if(chkCorr.isChecked()){
            String Correo = txteCorreo.getText().toString().trim();
            almacenarDatos("", Correo);
        }else if(chkWha.isChecked()){
            String WhatsApp = txteWhat.getText().toString().trim();
            almacenarDatos(WhatsApp, "");
        }else if(!chkWha.isChecked() || !chkCorr.isChecked()){
            almacenarDatos("", "");
        }
    }
    public void almacenarDatos(String Whats, String Correo){
        Bundle recibirDatos = getIntent().getExtras();
        String SexoMas = recibirDatos.getString("Sexo");
        String FechaAdop = recibirDatos.getString("Fecha");
        String raza = recibirDatos.getString("Raza");;
        String fecha = FechaAdop;
        String sexo = SexoMas;
        String NoCert = txtnCer.getText().toString().trim();
        String NombreMascota = txteNoMas.getText().toString().trim();
        String NombreAdoptante = txteNoAd.getText().toString().trim();
        String envWhats = Whats;
        String envCorreo = Correo;
        Intent sendData = new Intent(Adoptante.this, Certificado.class);
        sendData.putExtra("Raza", raza);
        sendData.putExtra("FechaAd", fecha);
        sendData.putExtra("Sexo", sexo);
        sendData.putExtra("Certificado", NoCert);
        sendData.putExtra("NombreMascota", NombreMascota);
        sendData.putExtra("NombreAdoptante", NombreAdoptante);
        sendData.putExtra("Whats", envWhats);
        sendData.putExtra("Correo", envCorreo);
        startActivity(sendData);
    }
}