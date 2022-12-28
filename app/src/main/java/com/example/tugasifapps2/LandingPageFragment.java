package com.example.tugasifapps2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.tugasifapps2.databinding.FragmentLandingPageBinding;

public class LandingPageFragment extends Fragment implements View.OnClickListener {
    private FragmentLandingPageBinding binding;
    private FragmentManager fragmentManager;
    private FragmentListener fragmentListener;

    //must-have empty constructor
    public LandingPageFragment(){}

    //singleton
    public static LandingPageFragment newInstance(FragmentManager fragmentManager){
        LandingPageFragment fragment = new LandingPageFragment();
        fragment.fragmentManager = fragmentManager;

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        // Inflate the Layout for this fragment
        this.binding = FragmentLandingPageBinding.inflate(inflater, container, false);
        View view = this.binding.getRoot();

        this.binding.btnLoginMain.setOnClickListener(this);
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
        if(v==binding.btnLoginMain) {
            this.fragmentListener.changePage(1);
        }
    }
}
