package com.example.ficha1_tiagoduarte_n3019;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {
    private ArrayList<Jogadoor>jogadoorsList;

    public recyclerAdapter(ArrayList<Jogadoor> jogadoorsList)
    {
        this.jogadoorsList = jogadoorsList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

    private TextView nomeTxT;
    private TextView idadeTxT;
    private TextView posicaoTxT;

    public MyViewHolder(final View view){
        super(view);
        nomeTxT = view.findViewById(R.id.lbnome);
        idadeTxT = view.findViewById(R.id.lbidade);
        posicaoTxT = view.findViewById(R.id.lbposicao);
    }
    }

    @NonNull
    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycler_view,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {
        String name = jogadoorsList.get(position).getNome();
        int idade = jogadoorsList.get(position).getIdade();
        String posicao = jogadoorsList.get(position).getPosicao();
        holder.nomeTxT.setText(name);
        holder.posicaoTxT.setText(posicao);
        holder.idadeTxT.setText(String.valueOf(idade));
    }

    @Override
    public int getItemCount() {
        return jogadoorsList.size();
    }
}
