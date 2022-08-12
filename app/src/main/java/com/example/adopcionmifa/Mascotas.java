package com.example.adopcionmifa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class Mascotas extends AppCompatActivity {

    private Spinner spnMas;
    private ListView lstPeGa;
    private ImageView imgvMas;
    private TextView txtmDat;
    private RadioGroup rdgbSex;
    private RadioButton rdbHem, rdbMac;
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
                        String carac = String.valueOf(i);
                        datosMas("Perro", "Negro", "1 año", "Masculino", carac);
                        break;
                    case 1:
                        imgvMas.setImageResource(R.drawable.lstpbas);
                        carac = String.valueOf(i);
                        datosMas("Perro", "Negro", "1 año", "Masculino", carac);
                        break;
                    case 2:
                        imgvMas.setImageResource(R.drawable.lstphus);
                        carac = String.valueOf(i);
                        datosMas("Perro", "Negro", "1 año", "Masculino", carac);
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
                        break;
                    case 1:
                        imgvMas.setImageResource(R.drawable.lstgkin);
                        break;
                    case 2:
                        imgvMas.setImageResource(R.drawable.lstglyk);
                        break;
                }
            }
        });
        datosMas("Gato", "Cafe", "2 años", "Masculino", "Jugueton");
    }
    public void datosMas(String raza, String color, String edad, String sexo, String caracter){
        txtmDat.setText(raza + "\n"+ color + "\n"+ edad + "\n"+ sexo + "\n"+ caracter);
    }
   public void radioButton(){
        sexoMascota.sexo = ((String.valueOf(rdgbSex.getCheckedRadioButtonId())));
        String sexo = sexoMascota.sexo;
        txtmDat.setText(sexo);
       rdgbSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.rdbHem:
                        String sexoF = rdbHem.toString().trim();
                        break;
                    case R.id.rdbMac:
                        String sexoM = rdbMac.toString().trim();
                        break;
                }
            }
        });
    }
    static class sexoMascota{
        static String sexo = "";
    }
}