package com.uts.IF7_10117229;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
/*nama : mufti alfarisy
  nim : 10117229
  kelas : IF7
  tgl : 8-5-2020
* */
import androidx.appcompat.widget.Toolbar;

public class tambah extends AppCompatActivity {
    private Button btntambah, btncancel;
    private EditText txtnimT, txtnamaT, txtkelasT, txttelpT, txtemailT, txtsosmedT;
    DatabaseOpenHelper dbHelper;
    TextView textT_teman;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        btntambah = findViewById(R.id.btn_tambah);
        btncancel = findViewById(R.id.btn_cancel);
        txtnimT = findViewById(R.id.nim_tambah);
        txtnamaT = findViewById(R.id.nama_tambah);
        txtkelasT = findViewById(R.id.kelas_tambah);
        txttelpT = findViewById(R.id.telp_tambah);
        txtemailT = findViewById(R.id.email_tambah);
        txtsosmedT = findViewById(R.id.sosmed_tambah);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_teman);
        setSupportActionBar(toolbar);

        TextView toolbarText = (TextView)
                findViewById(R.id.textT_teman);
        if (toolbarText != null && toolbar != null) {
            toolbarText.setText(getTitle());
            setSupportActionBar(toolbar);
        }
        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(tambah.this, MainActivity.class);
                startActivity(i);
            }
        });
        btntambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validasi();
                tambah_data();
            }
        });
    }


    public boolean validasi() {

        if (txtnimT.getText().toString().equals("")) {
            Toast.makeText(tambah.this, "NIM TIDAK BOLEH KOSONG", Toast.LENGTH_SHORT).show();
        }
        if (txtnamaT.getText().toString().equals("")) {
            Toast.makeText(tambah.this, "NAMA TIDAK BOLEH KOSONG", Toast.LENGTH_SHORT).show();
        }
        if (txtkelasT.getText().toString().equals("")) {
            Toast.makeText(tambah.this, "KELAS TIDAK BOLEH KOSONG", Toast.LENGTH_SHORT).show();
        }
        if (txtemailT.getText().toString().equals("")) {
            Toast.makeText(tambah.this, "EMAIL TIDAK BOLEH KOSONG", Toast.LENGTH_SHORT).show();
        }
        if (txttelpT.getText().toString().equals("")) {
            Toast.makeText(tambah.this, "TELPON TIDAK BOLEH KOSONG", Toast.LENGTH_SHORT).show();
        }
        if (txtsosmedT.getText().toString().equals("")) {
            Toast.makeText(tambah.this, "INSTAGRAM TIDAK BOLEH KOSONG", Toast.LENGTH_SHORT).show();
        } else if (!txtsosmedT.getText().toString().equals("") && (!txttelpT.getText().toString().equals("")) && !txtemailT.getText().toString().equals("") &&
        !txtkelasT.getText().toString().equals("") && !txtnamaT.getText().toString().equals("") && !txtnimT.getText().toString().equals("") ) {
            Toast.makeText(tambah.this, "DATA BERHASIL DI ISI", Toast.LENGTH_SHORT).show();
        }

        return true;
    }
    public void tambah_data(){
        dbHelper = new DatabaseOpenHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("insert into teman(NIM, nama, kelas, telpon, email,socialMedia) values('" +
                txtnimT.getText().toString() + "','" +
                txtnamaT.getText().toString() + "','" +
                txtkelasT.getText().toString() + "','" +
                txttelpT.getText().toString() + "','" +
                txtemailT.getText().toString() + "','" +
                txtsosmedT.getText().toString()+ "')");
        Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
        friendsFragment.fF.RefreshList();
        finish();
    }
}

