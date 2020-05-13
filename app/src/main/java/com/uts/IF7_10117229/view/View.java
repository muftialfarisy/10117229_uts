package com.uts.IF7_10117229.view;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.uts.IF7_10117229.MainActivity;
import com.uts.IF7_10117229.Model.User;
import com.uts.IF7_10117229.presenter.Presenter;
import com.uts.IF7_10117229.R;

import java.util.ArrayList;
import java.util.List;

import com.uts.IF7_10117229.presenter.IPresenter;

public class View extends AppCompatActivity implements IView {
TextView nim,nama,kelas,des;
    private List<User> users = new ArrayList<>();
    private String nim1 = "10117229";
    private IPresenter mainView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile);


    }

    @Override
    public void onLoad(List<User> users) {

    }

    @Override
    public void onSave() {
        User alfa = new User();

        nim = findViewById(R.id.nim);
        nama = findViewById(R.id.nama);
        kelas = findViewById(R.id.kelas);
        des = findViewById(R.id.desc);

        nim.setText(alfa.getNIM());
        nama.setText(alfa.getNama());
        kelas.setText(alfa.getKelas());
        des.setText(alfa.getDesc());
    }

    @Override
    public void onDelete() {

    }

    @Override
    public void onUpdate() {

    }
}
