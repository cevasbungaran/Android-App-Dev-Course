package com.example.tugasifapps2.View;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.tugasifapps2.FragmentListener;
import com.example.tugasifapps2.databinding.FragmentPengumumanBinding;

public class PengumumanFragment extends Fragment implements View.OnClickListener {
    private FragmentPengumumanBinding binding;
    private FragmentManager fragmentManager;
    private FragmentListener fragmentListener;

    //must-have empty constructor
    public PengumumanFragment(){}

    //singleton
    public static PengumumanFragment newInstance(){
        PengumumanFragment fragment = new PengumumanFragment();


        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        // Inflate the Layout for this fragment
        this.binding = FragmentPengumumanBinding.inflate(inflater, container, false);
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
        if(v == binding.btnNewPengumuman){
            this.fragmentListener.changePage(6);
        }
    }
}
