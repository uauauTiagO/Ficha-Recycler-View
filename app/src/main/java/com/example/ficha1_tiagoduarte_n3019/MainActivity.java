package com.example.ficha1_tiagoduarte_n3019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnRegistar;
    EditText txtNome,txtIdade;
    Spinner spinner_posicao;
    String nome,idadetexto,posicao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Jogadoor> jogadoorsList = new ArrayList<Jogadoor>();
        btnRegistar=findViewById(R.id.btnRegistar);
        txtIdade=findViewById(R.id.txtIdade);
        txtNome=findViewById(R.id.txtNome);
        spinner_posicao=findViewById(R.id.spinner_posicao);



        btnRegistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(txtNome.getText().toString().equals("") || txtIdade.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Tem de preencher ambos os campos para registar", Toast.LENGTH_SHORT).show();
                }
                nome=txtNome.getText().toString();
                idadetexto=txtIdade.getText().toString();
                posicao = spinner_posicao.getSelectedItem().toString();

                Jogadoor j1 = new Jogadoor(nome ,Integer.parseInt(idadetexto),posicao);
                jogadoorsList.add(j1);

                Intent intent = new Intent(MainActivity.this,Lista_Activity.class);
                intent.putExtra("lista", jogadoorsList);
                startActivity(intent);


            }
        });

    }
    public void onItemSelected(AdapterView<?> parent, View view, int Posicao, long id){
        parent.getItemAtPosition(Posicao);
    }
    public void onNothingSelected(AdapterView<?>parent){

    }


}