package com.example.tugasifapps2.Adapter;


import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.tugasifapps2.Model.Pengumuman;
import com.example.tugasifapps2.Model.Pertemuan;
import com.example.tugasifapps2.databinding.ItemListPengumumanBinding;
import com.example.tugasifapps2.databinding.ItemListPertemuanBinding;

import java.util.ArrayList;
import java.util.List;

public class PengumumanListAdapter extends BaseAdapter {
    private List<Pengumuman.Data> listItems;
    private Activity activity;
    private PengumumanAdapterInterface listener;
    ItemListPengumumanBinding binding;

    public PengumumanListAdapter(Activity activity, PengumumanAdapterInterface listener) {
        this.activity = activity;
        this.listItems = new ArrayList<Pengumuman.Data>();
        this.listener = listener;
    }

    public void add(List<Pengumuman.Data> data) {
        this.listItems.addAll(data);
        this.notifyDataSetChanged();
    }

    public void removeAll() {
        this.listItems.clear();
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        binding = ItemListPengumumanBinding.inflate(this.activity.getLayoutInflater());
        View itemView = binding.getRoot();
        Pengumuman.Data pengumuman = (Pengumuman.Data) this.getItem(position);
        this.binding.txtTitle.setText(pengumuman.getTitle());
        StringBuilder tags = new StringBuilder();
        List<Pengumuman.Data.Tags> tagList = pengumuman.getTags();
        for (int i = 0; i < tagList.size(); i++) {
            tags.append(tagList.get(i).getTagName()).append(" ");
        }

        this.binding.txtTag.setText(tags);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(pengumuman.getId());
            }
        });
        return itemView;

    }


    public interface PengumumanAdapterInterface {
        void onItemClick(String announcementId);
    }
}
