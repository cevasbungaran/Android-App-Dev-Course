package com.example.tugasifapps2.Adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.tugasifapps2.Model.Pertemuan;
import com.example.tugasifapps2.databinding.ItemListPertemuanBinding;

import java.util.ArrayList;
import java.util.List;

public class PertemuanListAdapter extends BaseAdapter {
    private List<Pertemuan> listItems;
    private Activity activity;
    ItemListPertemuanBinding binding;

    public PertemuanListAdapter(Activity activity){
        this.activity = activity;
        this.listItems = new ArrayList<Pertemuan>();
    }

    public void add(List<Pertemuan> title){
        this.listItems = (List<Pertemuan>) title;
        this.notifyDataSetChanged();
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
        binding = ItemListPertemuanBinding.inflate(this.activity.getLayoutInflater());
        View itemView = binding.getRoot();
        Pertemuan pertemuan = (Pertemuan) this.getItem(position);
        this.binding.tvTitleListPertemuan.setText(pertemuan.getTitle());
        this.binding.tvDate.setText(pertemuan.getDate());
        return itemView;

    }
}
