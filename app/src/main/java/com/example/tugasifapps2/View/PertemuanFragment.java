package com.example.tugasifapps2.View;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.tugasifapps2.Adapter.PertemuanListAdapter;
import com.example.tugasifapps2.FragmentListener;
import com.example.tugasifapps2.Model.Pertemuan;
import com.example.tugasifapps2.Presenter.PresenterPertemuan;
import com.example.tugasifapps2.databinding.FragmentPertemuanBinding;

import java.util.List;

public class PertemuanFragment extends Fragment implements View.OnClickListener, PresenterPertemuan.IMainActivity {
    private FragmentPertemuanBinding binding;
    private FragmentManager fragmentManager;
    private FragmentListener fragmentListener;
    PertemuanListAdapter adapter;
    PresenterPertemuan presenterPertemuan;

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

        this.binding.btnTambahPertemuan.setOnClickListener(this::onClick);


        this.adapter = new PertemuanListAdapter(getActivity());
        this.binding.lstPertemuan.setAdapter(this.adapter);
//        this.presenterPertemuan = new PresenterPertemuan((PresenterPertemuan.IMainActivity) getContext());


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

    @Override
    public void updateList(List<Pertemuan> pertemuans) {
        this.adapter.add(pertemuans);
    }
}
