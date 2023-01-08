package com.example.tugasifapps2.Presenter;

import com.example.tugasifapps2.Model.Pertemuan;

import java.util.ArrayList;
import java.util.List;

public class PresenterPertemuan {
    protected List<Pertemuan> pertemuans;
    protected IMainActivity UI;

    public PresenterPertemuan(IMainActivity ui){
        this.pertemuans = new ArrayList<>();
        this.UI = ui;
    }

    public void addList(String title, String date){
        this.pertemuans.add(new Pertemuan(title,date));
        this.UI.updateList(this.pertemuans);
    }

    public interface IMainActivity{
        void updateList(List<Pertemuan> pertemuans);
    }
}
