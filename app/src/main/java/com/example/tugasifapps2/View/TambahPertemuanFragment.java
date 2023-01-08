package com.example.tugasifapps2.View;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.tugasifapps2.FragmentListener;
import com.example.tugasifapps2.databinding.FragmentTambahPertemuanBinding;

public class TambahPertemuanFragment extends Fragment implements View.OnClickListener {
    private FragmentTambahPertemuanBinding binding;
    private FragmentListener fragmentListener;

    public TambahPertemuanFragment(){}

    //singleton
    public static TambahPertemuanFragment newInstance(){
        TambahPertemuanFragment fragment = new TambahPertemuanFragment();


        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        // Inflate the Layout for this fragment
        this.binding = FragmentTambahPertemuanBinding.inflate(inflater, container, false);
        View view = this.binding.getRoot();

        this.binding.btnJadwalDosen.setOnClickListener(this::onClick);
        this.binding.btnSimpanPertemuan.setOnClickListener(this::onClick);

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
        if(v == binding.btnJadwalDosen){
            this.fragmentListener.changePage(8);
        }
    }
}
