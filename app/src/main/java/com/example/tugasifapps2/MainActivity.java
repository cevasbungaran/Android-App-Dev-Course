package com.example.tugasifapps2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.tugasifapps2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements FragmentListener {
    private ActivityMainBinding binding;
    protected LandingPageFragment landingPageFragment;
    protected LoginFragment loginFragment;
    protected MainFragment mainFragment;
    protected PengumumanFragment pengumumanFragment;
    protected TambahPengumumanFragment tambahPengumumanFragment;
    protected PertemuanFragment pertemuanFragment;
    protected TambahPertemuanFragment tambahPertemuanFragment;
    protected JadwalDosenFragment jadwalDosenFragment;
    protected FrsFragment frsFragment;

    protected FragmentManager fragmentManager;
    protected FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //inisiasi fragments
        this.landingPageFragment = LandingPageFragment.newInstance(this.getSupportFragmentManager());
        this.loginFragment = LoginFragment.newInstance();
        this.mainFragment = MainFragment.newInstance();
        this.pengumumanFragment = PengumumanFragment.newInstance();
        this.tambahPengumumanFragment = TambahPengumumanFragment.newInstance();
        this.pertemuanFragment = PertemuanFragment.newInstance();
        this.tambahPertemuanFragment = TambahPertemuanFragment.newInstance();
        this.jadwalDosenFragment = JadwalDosenFragment.newInstance();
        this.frsFragment = FrsFragment.newInstance();


        //set halaman pertama fragment = home page
        this.fragmentManager = this.getSupportFragmentManager();
        this.ft = this.fragmentManager.beginTransaction();
        this.ft.add(binding.fragmentContainer.getId(), this.landingPageFragment).addToBackStack(null).commit();
    }

    public void changePage(int page) {
        ft = this.fragmentManager.beginTransaction();

        if (page == 0) {
            Log.d("debug", "changePage: page1");
            ft.replace(R.id.fragment_container, this.landingPageFragment).addToBackStack(null);
        } else if (page == 1) {
            ft.replace(R.id.fragment_container, this.loginFragment).addToBackStack(null);
        } else if (page == 2) {
            ft.replace(R.id.fragment_container, this.mainFragment).addToBackStack(null);
        } else if (page == 3) {
            ft.replace(R.id.fragment_container, this.pengumumanFragment).addToBackStack(null);
        } else if (page == 4) {
            ft.replace(R.id.fragment_container, this.pertemuanFragment).addToBackStack(null);
        } else if (page == 5) {
            ft.replace(R.id.fragment_container, this.frsFragment).addToBackStack(null);
        }  else if (page == 7) {
            ft.replace(R.id.fragment_container, this.tambahPertemuanFragment).addToBackStack(null);
        } else if (page == 8) {
            ft.replace(R.id.fragment_container, this.jadwalDosenFragment).addToBackStack(null);
        }
        this.ft.commit();
        binding.drawerLayout.closeDrawers();
    }

    @Override
    public void closeApplication() {
        this.moveTaskToBack(true);
        this.finish();
    }
}