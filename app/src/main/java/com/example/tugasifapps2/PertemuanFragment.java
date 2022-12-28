package com.example.tugasifapps2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.tugasifapps2.databinding.FragmentPengumumanBinding;
import com.example.tugasifapps2.databinding.FragmentPertemuanBinding;

public class PertemuanFragment extends Fragment implements View.OnClickListener {
    private FragmentPertemuanBinding binding;
    private FragmentManager fragmentManager;
    private FragmentListener fragmentListener;

    //must-have empty constructor
    public PertemuanFragment(){}

    //singleton
    public static PertemuanFragment newInstance(){
        PertemuanFragment fragment = new PertemuanFragment();


        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        // Inflate the Layout for this fragment
        this.binding = FragmentPertemuanBinding.inflate(inflater, container, false);
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
        if(v == binding.btnTambahPertemuan){
            this.fragmentListener.changePage(7);
        }

    }
}
