package com.example.tugasifapps2.View;

import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.viewmodel.CreationExtras;

import com.example.tugasifapps2.FragmentListener;
import com.example.tugasifapps2.Model.Pengumuman;
import com.example.tugasifapps2.Model.RequestPengumuman;
import com.example.tugasifapps2.Presenter.PresenterPengumuman;
import com.example.tugasifapps2.databinding.FragmentTambahPengumumanBinding;

import java.util.ArrayList;
import java.util.List;

public class TambahPengumumanFragment extends Fragment implements View.OnClickListener, PresenterPengumuman.PresenterTagsCallback, PresenterPengumuman.PresenterTambahPengumumanCallback {
    private FragmentTambahPengumumanBinding binding;
    private FragmentManager fragmentManager;
    private FragmentListener fragmentListener;
    private ArrayAdapter<String> adapter;
    private PresenterPengumuman presenter;
    private List<Pengumuman.Data.Tags> tagsData;

    //must-have empty constructor
    public TambahPengumumanFragment() {
    }

    //singleton
    public static TambahPengumumanFragment newInstance() {
        TambahPengumumanFragment fragment = new TambahPengumumanFragment();


        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the Layout for this fragment
        this.binding = FragmentTambahPengumumanBinding.inflate(inflater, container, false);
        View view = this.binding.getRoot();


        return view;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentListener) {
            this.fragmentListener = (FragmentListener) context;
        } else {
            throw new ClassCastException(context.toString() + "Must implement fragment listener");
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new PresenterPengumuman(getContext());
        presenter.getAllTags(this);

        // https://stackoverflow.com/questions/13377361/how-to-create-a-drop-down-list
        List<String> emptyList = new ArrayList<>();

        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, emptyList);
        binding.spinnerTags.setAdapter(adapter);

        TambahPengumumanFragment fragment = this;
        binding.btnSimpanPengumuman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title;
                String content;
                String tagId = "";

                for (Pengumuman.Data.Tags tag : tagsData) {
                    if (binding.spinnerTags.getSelectedItem().toString().equals(tag.getTagName())) {
                        tagId = tag.getId();
                    }
                }

                Log.e("tagsss", binding.spinnerTags.getSelectedItem().toString());
                title = binding.etTambahPengumuman.getText().toString();
                content = binding.etDeskripsiPertemuan.getText().toString();
                List<String> listTags = new ArrayList<>();
                listTags.add(tagId);
                presenter.postAnnouncement(
                        new RequestPengumuman(title,
                                content,
                                listTags),
                        fragment
                );
            }
        });
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void tagsFetched(List<Pengumuman.Data.Tags> tags) {
        tagsData = tags;
        List<String> tagsName = new ArrayList<>();

        for (int i = 0; i < tags.size(); i++) {
            tagsName.add(tags.get(i).getTagName());
        }

        adapter.addAll(tagsName);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void dataFetched(Pengumuman.Data result) {
        Toast.makeText(getActivity().getApplicationContext(), "pengumuman berhasil ditambahkan", Toast.LENGTH_SHORT).show();
        resetAllInput();
    }

    @Override
    public void failFetched() {
        Toast.makeText(getActivity().getApplicationContext(), "pengumuman gagal ditambahkan", Toast.LENGTH_SHORT).show();
        resetAllInput();
    }

    public void resetAllInput() {
        binding.etTambahPengumuman.setText("");
        binding.etDeskripsiPertemuan.setText("");
    }
}
