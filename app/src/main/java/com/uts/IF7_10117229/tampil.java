package com.uts.IF7_10117229;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/*nama : mufti alfarisy
  nim : 10117229
  kelas : IF7
  tgl : 8-5-2020
* */
public class tampil extends AppCompatActivity {
    EditText nim,nama,kelas,telp,email,sosmed;
    Button update,delete;
    DatabaseOpenHelper dbupdate;
    int position;
    protected Cursor cursor;
    public static tampil Tt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil);
        Tt = this;
        dbupdate = new DatabaseOpenHelper(this);
        nim = (EditText)findViewById(R.id.nimtampil);
        nama = (EditText)findViewById(R.id.namatampil);
        kelas = (EditText)findViewById(R.id.kelastampil);
        telp = (EditText)findViewById(R.id.telptampil);
        email = (EditText)findViewById(R.id.emailtampil);
        sosmed = (EditText)findViewById(R.id.sosmedtampil);
        update = (Button)findViewById(R.id.btn_update);
        delete = (Button)findViewById(R.id.btn_hapus);
        // Receiving value into activity using intent.
        String nimi = getIntent().getStringExtra("nim");
        String namai = getIntent().getStringExtra("nama");
        String kelasi = getIntent().getStringExtra("kelas");
        String telpi = getIntent().getStringExtra("telp");
        String emaili = getIntent().getStringExtra("email");
        String sosmedi = getIntent().getStringExtra("sosmed");

        // Setting up received value into EditText.
        nim.setText(nimi);
        nama.setText(namai);
        kelas.setText(kelasi);
        telp.setText(telpi);
        email.setText(emaili);
        sosmed.setText(sosmedi);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbupdate.getWritableDatabase();
                db.execSQL("update teman set nama ='"+nama.getText().toString()+"',kelas ='"+kelas.getText().toString()
                        +"',telpon ='"+telp.getText().toString()+"',email = '"+email.getText().toString()+"',socialMedia = '"
                        +sosmed.getText().toString()+"'WHERE NIM = '" +
                        getIntent().getStringExtra("nim") + "'");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                friendsFragment.fF.RefreshList();
                finish();
                RefreshList();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hapus();
                friendsFragment.fF.hapus_list(position);
                startActivity(new Intent(tampil.this, MainActivity.class));
                finish();
            }
        });
    }
    public void RefreshList(){
        SQLiteDatabase db = dbupdate.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM teman", null);
        cursor.moveToFirst();
        String nimi = getIntent().getStringExtra("nim");
        String namai = getIntent().getStringExtra("nama");
        String kelasi = getIntent().getStringExtra("kelas");
        String telpi = getIntent().getStringExtra("telp");
        String emaili = getIntent().getStringExtra("email");
        String sosmedi = getIntent().getStringExtra("sosmed");

        // Setting up received value into EditText.
        nim.setText(nimi);
        nama.setText(namai);
        kelas.setText(kelasi);
        telp.setText(telpi);
        email.setText(emaili);
        sosmed.setText(sosmedi);
    }
    public void hapus(){
        SQLiteDatabase db = dbupdate.getWritableDatabase();
        db.execSQL("delete from teman where NIM =" +
                nim.getText().toString());
        friendsFragment.fF.RefreshList();
        finish();



    }
}
