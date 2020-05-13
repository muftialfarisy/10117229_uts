package com.uts.IF7_10117229;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
/*nama : mufti alfarisy
  nim : 10117229
  kelas : IF7
  tgl : 8-5-2020
* */
public class MainActivity extends AppCompatActivity{
    ViewPager viewPager;
    MenuItem prevMenuItem;
    contactFragment fragcontact ;
    friendsFragment fragfriends;
    profileFragment fragprofile;
    private Menu _menu = null;
    ListView listView;
    ArrayAdapter arrayAdapter;
    DatabaseOpenHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.pager);
        mydb = new DatabaseOpenHelper(this);
        /*setupViewPager(viewPager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView toolbarText = (TextView) findViewById(R.id.toolbar_text);
        if(toolbarText!=null && toolbar!=null) {
            toolbarText.setText(getTitle());
            setSupportActionBar(toolbar);
        }*/

        // kita set default nya Home Fragment
        loadFragment(new friendsFragment());
// inisialisasi BottomNavigaionView
        final BottomNavigationView bottomNavigationView = findViewById(R.id.bn_main);

// beri listener pada saat item/menu bottomnavigation terpilih
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.contact_menu:
                        viewPager.setCurrentItem(0);
                        //fragment = new contactFragment();
                        break;
                    case R.id.friends_menu:
                        viewPager.setCurrentItem(1);
                        //fragment = new friendsFragment();
                        break;
                    case R.id.profile_menu:
                        viewPager.setCurrentItem(2);
                        //fragment = new profileFragment();
                        break;
                }
                return false;
            }
        });
                viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {
                        if (prevMenuItem != null)
                            prevMenuItem.setChecked(false);
                        else
                            bottomNavigationView.getMenu().getItem(0).setChecked(false);

                        bottomNavigationView.getMenu().getItem(position).setChecked(true);
                        prevMenuItem = bottomNavigationView.getMenu().getItem(position);
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });

    setupViewPager(viewPager);
        /*DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();

        listView = (ListView) findViewById(R.id.lv_friends);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, databaseAccess.getList());
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Was clicked " + position, Toast.LENGTH_SHORT).show();
            }
        });*/


    }



    private boolean loadFragment(Fragment fragment){
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.pager, fragment)
                    .commit();
            return true;
        }
        return false;
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        fragcontact = new contactFragment();
        fragfriends = new friendsFragment();
        fragprofile = new profileFragment();


        adapter.addFragment(fragcontact);
        adapter.addFragment(fragfriends);
        adapter.addFragment(fragprofile);

        viewPager.setAdapter(adapter);
    }


}


