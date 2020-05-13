package com.uts.IF7_10117229;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.uts.IF7_10117229.Model.User;
import com.uts.IF7_10117229.presenter.IPresenter;
import com.uts.IF7_10117229.view.IView;

import java.util.ArrayList;
import java.util.List;
/*nama : mufti alfarisy
  nim : 10117229
  kelas : IF7
  tgl : 8-5-2020
* */
public class profileFragment extends Fragment {
    TextView nimm,namaa,kelass,descc;
    DatabaseOpenHelper dbupdate;
    protected Cursor cursor;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        dbupdate = new DatabaseOpenHelper(getContext());

        nimm =  view.findViewById(R.id.nim);
        namaa = view.findViewById(R.id.nama);
        kelass = view.findViewById(R.id.kelas);
        descc = view.findViewById(R.id.desc);
    tampil_profile();
            SQLiteDatabase db = dbupdate.getReadableDatabase();

            cursor = db.rawQuery("SELECT * FROM profile", null);
        for(int count=0; count < cursor.getCount(); count++) {
            cursor.moveToFirst();
            cursor.moveToPosition(count);
            String NIM = cursor.getString(0);
            String nama = cursor.getString(1);
            String kelas = cursor.getString(2);
            String desc = cursor.getString(3);

            nimm.setText(NIM);
            namaa.setText(nama);
            kelass.setText(kelas);
            descc.setText(desc);
        }
        return view;

    }

public void tampil_profile(){

    SQLiteDatabase db = dbupdate.getWritableDatabase();
    db.execSQL("INSERT INTO profile (NIM,nama,kelas,description) VALUES ('10117229', 'Mufti Alfarisy', 'IF7', 'Seorang mahasiswa Di UNIKOM')");
}
}
