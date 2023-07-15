package com.albi.tugas_besar_albi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context contex;
    private ArrayList nama, catatan, tgl;


    public MyAdapter(Context contex, ArrayList nama, ArrayList catatan, ArrayList tgl) {
        this.contex = contex;
        this.nama = nama;
        this.catatan = catatan;
        this.tgl = tgl;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(contex).inflate(R.layout.catatanuser,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nama.setText(String.valueOf(nama.get(position)));
        holder.catatan.setText(String.valueOf(catatan.get(position)));
        holder.tgl.setText(String.valueOf(tgl.get(position)));
    }

    @Override
    public int getItemCount() {
        return nama.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nama, catatan, tgl;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.textnama);
            catatan = itemView.findViewById(R.id.textcatatan);
            tgl = itemView.findViewById(R.id.texttgl);
        }
    }
}
