package com.uts.IF7_10117229;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
/*nama : mufti alfarisy
  nim : 10117229
  kelas : IF7
  tgl : 8-5-2020
* */
public class contactFragment extends Fragment {
ImageButton insta,face,telpp;
    private static final int REQUEST_CALL = 1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);


        insta = view.findViewById(R.id.ig);
        face = view.findViewById(R.id.fb);
        telpp = view.findViewById(R.id.call);
        telpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:085155117327"));

                if (ContextCompat.checkSelfPermission(getContext(),
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
                } else {
                    startActivity(callIntent);
                }
            }
        });

        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.instagram.com/mftalfrsy/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        face.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.facebook.com/mufti.alfarisy1");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        return view;
    }
}
