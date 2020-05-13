package com.uts.IF7_10117229;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
/*nama : mufti alfarisy
  nim : 10117229
  kelas : IF7
  tgl : 8-5-2020
* */
public class home extends AppCompatActivity {
    private int waktu_loading=1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //setelah loading maka akan langsung berpindah ke home activity
                Intent home=new Intent(home.this, MainActivity.class);
                startActivity(home);
                finish();

            }
        },waktu_loading);
    }
}
