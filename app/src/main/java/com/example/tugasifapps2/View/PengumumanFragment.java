package com.example.tugasifapps2.View;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.viewmodel.CreationExtras;

import com.example.tugasifapps2.Adapter.PengumumanListAdapter;
import com.example.tugasifapps2.FragmentListener;
import com.example.tugasifapps2.Model.Pengumuman;
import com.example.tugasifapps2.Presenter.PresenterPengumuman;
import com.example.tugasifapps2.databinding.FragmentPengumumanBinding;

import java.util.List;

public class PengumumanFragment extends Fragment implements PresenterPengumuman.PresenterCallback, PengumumanListAdapter.PengumumanAdapterInterface {
    private FragmentPengumumanBinding binding;
    private FragmentManager fragmentManager;
    private FragmentListener fragmentListener;
    private PengumumanListAdapter adapter;
    private PresenterPengumuman presenter;
    private String currentQuery = "";
    private boolean isLoading = false;
    private boolean isSearch = false;

    //must-have empty constructor
    public PengumumanFragment() {
    }

    //singleton
    public static PengumumanFragment newInstance() {
        PengumumanFragment fragment = new PengumumanFragment();


        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the Layout for this fragment
        this.binding = FragmentPengumumanBinding.inflate(inflater, container, false);
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
        presenter = new PresenterPengumuman();
        adapter = new PengumumanListAdapter(getActivity(), this);
        binding.lstPengumuman.setAdapter(adapter);

        presenter.getPengumuman("", "", this);

        binding.btnNewPengumuman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentListener.changePage(6);
            }
        });
        binding.lstPengumuman.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                if (isLoading || !presenter.isHasNext())
                    return;
                if (firstVisibleItem + visibleItemCount == totalItemCount && totalItemCount != 0) {
                    loadMore();
                }
            }

        });

        binding.searchBoxPengumuman.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                currentQuery = query;
                isSearch = true;
                presenter.getPengumuman(currentQuery, "", PengumumanFragment.this);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.equals("") && binding.searchBoxPengumuman.getWidth() > 0) {
                    currentQuery = "";
                    isSearch = true;
                    presenter.getPengumuman("", "", PengumumanFragment.this);
                }
                return false;
            }
        });

    }

    private void loadMore() {
        isLoading = true;
        presenter.getPengumuman(currentQuery, presenter.getCurrentCursor(), PengumumanFragment.this);
    }

    @Override
    public void dataFetched(List<Pengumuman.Data> result) {
        if (isSearch) {
            adapter.removeAll();
        }
        adapter.add(result);
        isLoading = false;
        isSearch = false;
    }

    @Override
    public void onItemClick(String announcementId) {
        this.fragmentListener.goToPengumumanDetail(announcementId);
    }

}
