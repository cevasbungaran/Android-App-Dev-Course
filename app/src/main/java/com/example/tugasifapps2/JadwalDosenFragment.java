package com.example.tugasifapps2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.tugasifapps2.databinding.FragmentJadwalDosenBinding;
import com.example.tugasifapps2.databinding.FragmentTambahPertemuanBinding;

public class JadwalDosenFragment extends Fragment implements View.OnClickListener {
    private FragmentJadwalDosenBinding binding;
    private FragmentListener fragmentListener;

    public JadwalDosenFragment(){}

    //singleton
    public static JadwalDosenFragment newInstance(){
        JadwalDosenFragment fragment = new JadwalDosenFragment();


        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        // Inflate the Layout for this fragment
        this.binding = FragmentJadwalDosenBinding.inflate(inflater, container, false);
        View view = this.binding.getRoot();

        return view;
    }

    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof FragmentListener){
            this.fragmentListener = (FragmentListener) context;
        }
        else{
            throw new ClassCastException(context.toString()+"Must implement fragment listener");
        }
    }

    @Override
    public void onClick(View v) {
        if(v == binding.btnKembali){
            this.fragmentListener.changePage(7);
        }
    }
}
