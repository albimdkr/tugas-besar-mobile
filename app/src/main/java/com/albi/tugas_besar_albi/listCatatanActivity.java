package com.albi.tugas_besar_albi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class listCatatanActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> nama, catatan, tgl;
    DBHelper DB;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_catatan);
        DB = new DBHelper(this);
        nama = new ArrayList<>();
        catatan = new ArrayList<>();
        tgl = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new MyAdapter(this, nama, catatan, tgl);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
    }

    private void displaydata() {
        Cursor cursor = DB.getdata();
            if(cursor.getCount()==0){
                Toast.makeText(listCatatanActivity.this, "Tidak ada data!", Toast.LENGTH_SHORT).show();
                return;
            } else {
                while (cursor.moveToNext()){
                    nama.add(cursor.getString(0));
                    catatan.add(cursor.getString(1));
                    tgl.add(cursor.getString(2));
                };
            }
    }
}