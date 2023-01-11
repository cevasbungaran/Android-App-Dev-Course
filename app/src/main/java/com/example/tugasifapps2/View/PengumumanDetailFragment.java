package com.example.tugasifapps2.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tugasifapps2.Model.Pengumuman;
import com.example.tugasifapps2.Presenter.PresenterPengumuman;
import com.example.tugasifapps2.R;
import com.example.tugasifapps2.databinding.FragmentPengumumanBinding;
import com.example.tugasifapps2.databinding.FragmentPengumumanDetailBinding;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PengumumanDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PengumumanDetailFragment extends Fragment implements PresenterPengumuman.PresenterDetailCallback {

    String announcementid;
    FragmentPengumumanDetailBinding binding;
    PresenterPengumuman presenter;

    public PengumumanDetailFragment() {
        // Required empty public constructor
    }

    public static PengumumanDetailFragment newInstance(String announcementId) {
        PengumumanDetailFragment fragment = new PengumumanDetailFragment();
        Bundle args = new Bundle();
        args.putString("announcementid", announcementId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            announcementid = getArguments().getString("announcementid");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.binding = FragmentPengumumanDetailBinding.inflate(inflater, container, false);
        View view = this.binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new PresenterPengumuman();

        presenter.getPengumumanDetail(announcementid, this);
    }

    @Override
    public void dataFetched(Pengumuman.Data result) {
        binding.tvContentPengumuman.setText(result.getContent());
        binding.tvTitlePengumuman.setText(result.getTitle());

        StringBuilder tags = new StringBuilder();
        for (int i = 0; i < result.getTags().size(); i++) {
            tags.append(result.getTags().get(i).getTagName()).append(", ");
        }

        binding.tvTagPengumuman.setText(tags.toString());
    }

}