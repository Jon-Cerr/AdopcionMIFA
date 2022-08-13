package com.example.adopcionmifa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;

public class Mascotas extends AppCompatActivity {

    private Spinner spnMas;
    private ListView lstPeGa;
    private ImageView imgvMas;
    private TextView txtmDat;
    private RadioGroup rdgbSex;
    private RadioButton rdbHem, rdbMac;
    private ImageButton imgbIrAdoptar;
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
        txtmDat.setKeyListener(null);
        imgbIrAdoptar = findViewById(R.id.imgbIrAdoptar);
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
                Mascota mascotasPerros = new Mascota();
                switch(i){
                    case 0:
                        imgvMas.setImageResource(R.drawable.lstpbul);
                        datosMas(
                                mascotasPerros.raza = "Bulldog",
                                mascotasPerros.color = "Blanco",
                                mascotasPerros.edad = "2 años",
                                mascotasPerros.sexo = "Masculino",
                                mascotasPerros.caracter = "Jugueton");
                        break;
                    case 1:
                        imgvMas.setImageResource(R.drawable.lstpbas);
                        datosMas(
                                mascotasPerros.raza = "Basenji",
                                mascotasPerros.color = "Negro con blanco",
                                mascotasPerros.edad = "1 año",
                                mascotasPerros.sexo = "Hembra",
                                mascotasPerros.caracter = "Juguetona");
                        break;
                    case 2:
                        imgvMas.setImageResource(R.drawable.lstphus);
                        datosMas(
                                mascotasPerros.raza = "Husky",
                                mascotasPerros.color = "Blanco con cafe y negro",
                                mascotasPerros.edad = "1 año",
                                mascotasPerros.sexo = "Macho",
                                mascotasPerros.caracter = "Jugueton y dramatico");
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
                Mascota mascotasGatos = new Mascota();
                switch(i){
                    case 0:
                        imgvMas.setImageResource(R.drawable.lstgbom);
                        datosMas(
                                mascotasGatos.raza = "Bombay",
                                mascotasGatos.color = "Negro",
                                mascotasGatos.edad = "1 año",
                                mascotasGatos.sexo = "Macho",
                                mascotasGatos.caracter = "Jugueton");
                        break;
                    case 1:
                        imgvMas.setImageResource(R.drawable.lstgkin);
                        datosMas(
                                mascotasGatos.raza = "Kinkalow",
                                mascotasGatos.color = "Gris con blanco",
                                mascotasGatos.edad = "8 meses",
                                mascotasGatos.sexo = "Hembra",
                                mascotasGatos.caracter = "Reservada y mimada");
                        break;
                    case 2:
                        imgvMas.setImageResource(R.drawable.lstglyk);
                        datosMas(
                                mascotasGatos.raza = "Lykoi",
                                mascotasGatos.color = "Gris",
                                mascotasGatos.edad = "1 año",
                                mascotasGatos.sexo = "Macho",
                                mascotasGatos.caracter = "Jugueton");
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
}