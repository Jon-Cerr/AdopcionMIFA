package com.example.adopcionmifa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class Mascotas extends AppCompatActivity {

    private Spinner spnMas;
    private ListView lstPeGa;
    private ImageView imgvMas;
    private TextView txtmDat;
    private RadioGroup rdgbSex;
    private RadioButton rdbHem, rdbMac;
    private EditText txteFe;
    Mascota mascotas = new Mascota();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas);
        spnMas = findViewById(R.id.spnMas);
        lstPeGa = findViewById(R.id.lstPeGa);
        imgvMas= findViewById(R.id.imgvMas);
        txtmDat= findViewById(R.id.txtmDat);
        rdgbSex= findViewById(R.id.rdgbSex);
        rdbHem= findViewById(R.id.rdbHem);
        rdbMac= findViewById(R.id.rdbMac);
        txteFe= findViewById(R.id.txteFe);
        txtmDat.setKeyListener(null);
        regMas();
    }
    public void regMas(){
        ArrayAdapter Mascotas = ArrayAdapter.createFromResource(com.example.adopcionmifa.Mascotas.this, R.array.Mascota, android.R.layout.simple_spinner_item);
        spnMas.setAdapter(Mascotas);
        spnMas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        imgvMas.setImageResource(R.drawable.spnpega);
                        break;
                    case 1:
                        datPerr();
                        break;
                    case 2:
                        datGat();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void datPerr(){
        ArrayAdapter ListPerr = ArrayAdapter.createFromResource(Mascotas.this, R.array.Perros, android.R.layout.simple_spinner_item);
        lstPeGa.setAdapter(ListPerr);
        imgvMas.setImageResource(R.drawable.spnper);
        lstPeGa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        imgvMas.setImageResource(R.drawable.lstpbul);
                        datosMas(
                                mascotas.raza = "Bulldog",
                                mascotas.color = "Blanco",
                                mascotas.edad = "2 años",
                                mascotas.sexo = "Masculino",
                                mascotas.caracter = "Jugueton");
                        break;
                    case 1:
                        imgvMas.setImageResource(R.drawable.lstpbas);
                        datosMas(
                                mascotas.raza = "Basenji",
                                mascotas.color = "Negro con blanco",
                                mascotas.edad = "1 año",
                                mascotas.sexo = "Hembra",
                                mascotas.caracter = "Juguetona");
                        break;
                    case 2:
                        imgvMas.setImageResource(R.drawable.lstphus);
                        datosMas(
                                mascotas.raza = "Husky",
                                mascotas.color = "Blanco con cafe y negro",
                                mascotas.edad = "1 año",
                                mascotas.sexo = "Macho",
                                mascotas.caracter = "Jugueton y dramatico");
                        break;
                }
            }
        });
    }
    public void datGat(){
        ArrayAdapter ListGat = ArrayAdapter.createFromResource(Mascotas.this, R.array.Gatos, android.R.layout.simple_spinner_item);
        lstPeGa.setAdapter(ListGat);
        imgvMas.setImageResource(R.drawable.spngat);
        lstPeGa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        imgvMas.setImageResource(R.drawable.lstgbom);
                        datosMas(
                                mascotas.raza = "Bombay",
                                mascotas.color = "Negro",
                                mascotas.edad = "1 año",
                                mascotas.sexo = "Macho",
                                mascotas.caracter = "Jugueton");
                        break;
                    case 1:
                        imgvMas.setImageResource(R.drawable.lstgkin);
                        datosMas(
                                mascotas.raza = "Kinkalow",
                                mascotas.color = "Gris con blanco",
                                mascotas.edad = "8 meses",
                                mascotas.sexo = "Hembra",
                                mascotas.caracter = "Reservada y mimada");
                        break;
                    case 2:
                        imgvMas.setImageResource(R.drawable.lstglyk);
                        datosMas(
                                mascotas.raza = "Lykoi",
                                mascotas.color = "Gris",
                                mascotas.edad = "1 año",
                                mascotas.sexo = "Macho",
                                mascotas.caracter = "Jugueton");
                        break;
                }
            }
        });

    }
    public void datosMas(String raza, String color, String edad, String sexo, String caracter){
        txtmDat.setText("Raza: " + raza + "\n\n"+ "Color: " + color + "\n\n"+ "Edad: " + edad + "\n\n" + "Sexo: " + sexo + "\n\n" + "Caracter: " + caracter);
    }
    class Mascota{
        String raza = "";
        String color = "";
        String edad = "";
        String sexo = "";
        String caracter = "";
    }
    public void irAdoptar(View view){
        AdoptarPaso();
    }
    public void AdoptarPaso(){
        rdgbSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                String sexo;
                String fecha;
                Intent envioDatos;
                switch(i){
                    case R.id.rdbHem:
                        sexo = "Hembra";
                        fecha = txteFe.getText().toString().trim();
                        envioDatos = new Intent(Mascotas.this, Adoptante.class);
                        envioDatos.putExtra("Sexo", sexo);
                        envioDatos.putExtra("Sexo", fecha);
                        startActivity(envioDatos);
                        break;
                    case R.id.rdbMac:
                        sexo = "Macho";
                        fecha = txteFe.getText().toString().trim();
                        envioDatos = new Intent(Mascotas.this, Adoptante.class);
                        envioDatos.putExtra("Sexo", sexo);
                        envioDatos.putExtra("Sexo", fecha);
                        startActivity(envioDatos);
                        break;
                }
            }
        });
    }
}