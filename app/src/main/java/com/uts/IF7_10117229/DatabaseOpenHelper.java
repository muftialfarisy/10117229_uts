package com.uts.IF7_10117229;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
/*nama : mufti alfarisy
  nim : 10117229
  kelas : IF7
  tgl : 8-5-2020
* */
public class DatabaseOpenHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "datauts.db";
    public static final String TABLE_NAME = "teman";
    public static final String COL_1 = "NIM";
    public static final String COL_2 = "nama";
    public static final String COL_3 = "kelas";
    public static final String COL_4 = "telepon";
    public static final String COL_5 = "email";
    public static final String COL_6 = "socialMedia";
    public static final String TABLE_PROFILE = "profile";
    public static final String COL_1_1 = "NIM";
    public static final String COL_2_1 = "nama";
    public static final String COL_3_1 = "kelas";
    public static final String COL_4_1 = "description";
    private static final int DATABASE_VERSION = 1;
    public DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
        SQLiteDatabase db = this.getWritableDatabase();
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL("create table "+ TABLE_NAME +"(NIM integer not null, nama text not null, kelas text not null, " +
                "telpon text not null, email text not null, socialMedia text not null);");
        db.execSQL("INSERT INTO teman (NIM, nama, kelas, telpon, email, socialMedia) VALUES ('10117229', 'Mufti Alfarisy', 'IF7', '082110942653','alfabjp@gmail.com','@mftalfrsy')");
        db.execSQL("INSERT INTO teman (NIM, nama, kelas, telpon, email, socialMedia) VALUES ('10117208', 'Guntur Prakasa', 'IF7', '082116565959 ','gunturprakasairwan@gmail.com','@guntur82_')");
        db.execSQL("create table "+ TABLE_PROFILE +"(NIM integer  not null, nama text not null, kelas text not null, " +
                "description text not null);");



        /*String tabel_profile = "create table "+ TABLE_PROFILE +"(NIM integer primary key not null, nama text not null, kelas text not null, " +
                "description text not null);";
        db.execSQL(tabel_profile);
        String insert_profile = "INSERT INTO profile (NIM, nama, kelas,description) VALUES ('10117229', 'Mufti Alfarisy', 'IF7', 'Seorang mahasiswa Di UNIKOM');";
        db.execSQL(insert_profile);

        //Log.d("Data", "onCreate: " + db);
        //db.execSQL(sql);

        /*sql = "INSERT INTO teman (NIM, nama, tgl, kelas, telp, email, sosmed) VALUES ('10117229', 'Mufti Alfarisy', 'IF7', '082110942653','alfabjp@gmail.com','@mftalfrsy');";
        db.execSQL(sql);*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);

        onCreate(db);
    }
}