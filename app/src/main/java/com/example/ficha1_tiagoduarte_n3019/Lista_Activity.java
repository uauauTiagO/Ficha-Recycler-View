package com.example.ficha1_tiagoduarte_n3019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class Lista_Activity extends AppCompatActivity {

    RecyclerView rcLista;
    ArrayList<Jogadoor> jogadoorsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rclista);
        recyclerView.setLayoutManager(linearLayoutManager);
        Intent intent = new Intent(Lista_Activity.this,MainActivity.class);
        jogadoorsList = (ArrayList<Jogadoor>)getIntent().getSerializableExtra("lista");
        rcLista=findViewById(R.id.rclista);
        setAdapter();
    }

    private void setAdapter(){
        recyclerAdapter adapter = new recyclerAdapter(jogadoorsList);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getApplicationContext());
        rcLista.setLayoutManager(layoutManager);
        rcLista.setItemAnimator(new DefaultItemAnimator());
        rcLista.setAdapter(adapter);
    }
}