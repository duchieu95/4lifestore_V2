package com.example.fls.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fls.R;
import com.example.fls.adapters.HomeData;
import com.example.fls.models.Product;
import com.example.fls.models.SectionDataModel;

import java.util.ArrayList;

/**
 * Created by HieuHo on 3/3/2017.
 */

public class AllKindsOfLists extends Fragment {
    RecyclerView recyclerView;
    ArrayList<SectionDataModel> allSampleData = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fls_004,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        getData();
        return view;
    }
    private void getData(){
        for(int i= 1;i<20;i++){
            ArrayList<Product> list = new  ArrayList<>();
            SectionDataModel dm = new SectionDataModel();
            dm.setHeaderTitle("Loại Danh Mục "+i);
            for(int j = 1;j<20;j++){
                list.add(new Product(10000000,"Sản Phẩm"+j));
            }
            dm.setAllItemsInSection(list);
            allSampleData.add(dm);
        }
        HomeData adapter = new HomeData(getActivity(), allSampleData);
        recyclerView.setAdapter(adapter);
    }
}
