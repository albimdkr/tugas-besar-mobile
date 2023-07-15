package com.albi.tugas_besar_albi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class HomeActivity extends AppCompatActivity {
    EditText nama, catatan, tgl;
    Button insert, update, delete, view;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        nama = findViewById(R.id.nama);
        catatan = findViewById(R.id.catatan);
        tgl = findViewById(R.id.tgl);
        insert = findViewById(R.id.btnInsert);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnView);
        DB = new DBHelper(this);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namaTXT = nama.getText().toString();
                String catatanTXT = catatan.getText().toString();
                String tglTXT = tgl.getText().toString();

                Boolean checkinsertdata = DB.insertdatacatatan(namaTXT, catatanTXT, tglTXT);
                if(checkinsertdata==true)
                    Toast.makeText(HomeActivity.this, "Data Berhasil Ditambahkan!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(HomeActivity.this, "Data Gagal Ditambahkan!", Toast.LENGTH_SHORT).show();
            }        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = nama.getText().toString();
                String contactTXT = catatan.getText().toString();
                String tglTXT = tgl.getText().toString();

                Boolean checkupdatedata = DB.updatedatacatatan(nameTXT, contactTXT, tglTXT);
                if(checkupdatedata==true)
                    Toast.makeText(HomeActivity.this, "Data berhasil Update!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(HomeActivity.this, "Data Gagal DiUpdate!", Toast.LENGTH_SHORT).show();
            }        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = nama.getText().toString();
                Boolean checkudeletedata = DB.deletedatacatatan(nameTXT);
                if(checkudeletedata==true)
                    Toast.makeText(HomeActivity.this, "Data Berhasil Terhapus!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(HomeActivity.this, "Data Gagal Terhapus!", Toast.LENGTH_SHORT).show();
            }        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, listCatatanActivity.class));
            }
        });
    }}