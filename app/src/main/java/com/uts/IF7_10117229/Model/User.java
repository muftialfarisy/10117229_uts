package com.uts.IF7_10117229.Model;

public class User implements IUser {
    private String NIM,Nama,Kelas,Desc;



    public void setNIM(String NIM) {
        this.NIM = NIM;
    }

    public void setNama(String nama) {
        this.Nama = nama;
    }

    public void setKelas(String kelas) {
        this.Kelas = kelas;
    }

    public void setDesc(String desc) {
        this.Desc = desc;
    }

    @Override
    public String getNIM() {
        return this.NIM;
    }

    @Override
    public String getNama() {
        return this.Nama;
    }

    @Override
    public String getKelas() {
        return this.Kelas;
    }

    @Override
    public String getDesc() {
        return this.Desc;
    }
}

