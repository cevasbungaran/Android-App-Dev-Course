package com.example.tugasifapps2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.tugasifapps2.databinding.FragmentLoginBinding;
import com.example.tugasifapps2.databinding.FragmentMainBinding;

public class MainFragment extends Fragment implements View.OnClickListener {
    private FragmentMainBinding binding;
    private FragmentManager fragmentManager;
    private FragmentListener fragmentListener;

    //must-have empty constructor
    public MainFragment(){}

    //singleton
    public static MainFragment newInstance(){
        MainFragment fragment = new MainFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        // Inflate the Layout for this fragment
        this.binding = FragmentMainBinding.inflate(inflater, container, false);
        View view = this.binding.getRoot();

        this.binding.btnMenuPengumuman.setOnClickListener(this::onClick);
        this.binding.btnMenuPertemuan.setOnClickListener(this::onClick);
        this.binding.btnMenuFrs.setOnClickListener(this::onClick);
        this.binding.btnMenuPengaturan.setOnClickListener(this::onClick);

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
        if(v == binding.btnMenuPengumuman){
            this.fragmentListener.changePage(3);
        }else if(v == binding.btnMenuPertemuan){
            this.fragmentListener.changePage(4);
        }else if(v == binding.btnMenuFrs){
            this.fragmentListener.changePage(5);
        }
    }
}
