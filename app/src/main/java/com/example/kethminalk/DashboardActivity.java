package com.example.kethminalk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardActivity extends AppCompatActivity {

    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        toolbar = getSupportActionBar();

        BottomNavigationView navigation = findViewById(R.id.navigationView);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

//       toolbar.setTitle("Uno");
        loadFragment(new UnoFragment());
        loadFragment(new TresFragment());
        loadFragment(new DosFragment());
        loadFragment(new CautroFragment());


    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.uno:
//                    toolbar.setTitle("Uno");
                    loadFragment(new UnoFragment());
                    return true;
                case R.id.dos:
//                    toolbar.setTitle("Dos");
                    loadFragment(new DosFragment());
                    return true;
                case R.id.tres:
                    //toolbar.setTitle("Tres");
                    loadFragment(new TresFragment());
                    return true;
                case R.id.cautro:
                    //                 toolbar.setTitle("Cautro");
                    loadFragment(new CautroFragment());
                    return true;
            }
            return false;
        }
    };




    private void loadFragment(Fragment fragment) {

       //  load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}
