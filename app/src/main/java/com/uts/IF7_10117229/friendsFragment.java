package com.uts.IF7_10117229;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.uts.IF7_10117229.Model.User;
import com.uts.IF7_10117229.presenter.IPresenter;
import com.uts.IF7_10117229.presenter.Presenter;
import com.uts.IF7_10117229.view.IView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*nama : mufti alfarisy
  nim : 10117229
  kelas : IF7
  tgl : 8-5-2020
* */
public class friendsFragment extends Fragment {
    private FloatingActionButton fab1;
    TextView nim, nama, kelas, des;
    public static friendsFragment fF;
    DatabaseOpenHelper dbcenter;
    protected Cursor cursor;
    String[] daftar;
    private ArrayList<String> ListData;
ListView lv;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friends, container, false);
//mainpresenterimpl = Presenter
        //mainpresenter = IPresenter
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar_teman);
        getActivity().setTitle("List Teman");

        fF = this;

        lv = (ListView) view.findViewById(R.id.lv_friends);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    for (int count = 0; count < cursor.getCount(); count++) {

                        cursor.moveToPosition(position);
                        String nime = cursor.getString(0);
                        String namae = ListData.get(position).toString();
                        String kelase = cursor.getString(2);
                        String telpe = cursor.getString(3);
                        String emaile = cursor.getString(4);
                        String sosmede = cursor.getString(5);
                        Toast.makeText(getActivity(), "lihat", Toast.LENGTH_SHORT).show();


                        Intent intent = (new Intent(getActivity(), tampil.class));

                        // Sending value to another activity using intent.
                        intent.putExtra("nim",nime);
                        intent.putExtra("nama", namae);
                        intent.putExtra("kelas", kelase);
                        intent.putExtra("telp", telpe);
                        intent.putExtra("email", emaile);
                        intent.putExtra("sosmed", sosmede);

                        startActivity(intent);
                    }

                }


        });


        fab1 = (FloatingActionButton) view.findViewById(R.id.fab1);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), tambah.class));
            }
        });
        dbcenter = new DatabaseOpenHelper(getContext());
        RefreshList();


        return view;



    }

    public void RefreshList() {

        ListData = new ArrayList<>();



        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM teman", null);
        daftar = new String[cursor.getCount()];

        cursor.moveToFirst();
        for(int count=0; count < cursor.getCount(); count++){

            cursor.moveToPosition(count);//Berpindah Posisi dari no index 0 hingga no index terakhir
            ListData.add(cursor.getString(1));
            cursor.getColumnIndex("nama");
            //Menambil Data Dari Kolom 1 (Nama)
            //Lalu Memasukan Semua Datanya kedalam ArrayList
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, ListData);
            lv.setAdapter(adapter);

        }

    }
public void  tampil_duluan(){
    SQLiteDatabase db = dbcenter.getWritableDatabase();

    RefreshList();
}
public void hapus_list(int position){
        ListData.remove(position);
}

}
