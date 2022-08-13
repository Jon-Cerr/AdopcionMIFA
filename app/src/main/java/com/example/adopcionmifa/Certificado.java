package com.example.adopcionmifa;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Certificado extends AppCompatActivity {

    private EditText txtnCertificado, txteMasCert, txteFechaCert, txteRazaCert, txteSexoCert, txteAdopCert,
            txtnWhaCert, txteCorreoCert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certificado);
        Bundle getDataFromAdoptante = getIntent().getExtras();
        String Raza = getDataFromAdoptante.getString("Raza");
        String FechaAdop = getDataFromAdoptante.getString("FechaAd");
        String SexoMas = getDataFromAdoptante.getString("Sexo");
        String NoCert = getDataFromAdoptante.getString("Certificado");
        String NombreMascota = getDataFromAdoptante.getString("NombreMascota");
        String NombreAdoptante = getDataFromAdoptante.getString("NombreAdoptante");
        String envWhats = getDataFromAdoptante.getString("Whats");
        String envCorreo = getDataFromAdoptante.getString("Correo");
        txtnCertificado = findViewById(R.id.txtnCertificado);
        txteMasCert = findViewById(R.id.txteMasCert);
        txteFechaCert = findViewById(R.id.txteFechaCert);
        txteRazaCert = findViewById(R.id.txteRazaCert);
        txteSexoCert = findViewById(R.id.txteSexoCert);
        txteAdopCert = findViewById(R.id.txteAdopCert);
        txtnWhaCert = findViewById(R.id.txtnWhaCert);
        txteCorreoCert = findViewById(R.id.txteCorreoCert);
        txtnCertificado.setText(NoCert);
        txteMasCert.setText(NombreMascota);
        txteFechaCert.setText(FechaAdop);
        txteRazaCert.setText(Raza);
        txteSexoCert.setText(SexoMas);
        txteAdopCert.setText(NombreAdoptante);
        txtnWhaCert.setText(envWhats);
        txteCorreoCert.setText(envCorreo);
    }
    public void salir(View v){
        finishAffinity();
    }
}