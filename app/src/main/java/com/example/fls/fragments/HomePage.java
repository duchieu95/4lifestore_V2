package com.example.fls.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.fls.R;
import com.example.fls.adapters.HomeData;
import com.example.fls.models.Product;
import com.example.fls.models.SectionDataModel;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;


public class HomePage extends BaseFragment {
    CarouselView carouselView;
    CollapsingToolbarLayout collapsingToolbar;
    AppBarLayout appBarLayout;
    int[] sampleImages = {R.drawable.cong, R.drawable.dathang, R.drawable.email};
    RecyclerView recyclerView;
    ArrayList<SectionDataModel> allSampleData = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fls_002,container,false);
        carouselView = (CarouselView) view.findViewById(R.id.carouselView);
        collapsingToolbar =
                (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        appBarLayout = (AppBarLayout) view.findViewById(R.id.appbar);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);

        recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        getData();
        return view;
    }

    private void getData(){
        for(int i= 1;i<5;i++){
            ArrayList<Product> list = new  ArrayList<>();
            SectionDataModel dm = new SectionDataModel();
            dm.setHeaderTitle("Sản Phẩm Đang Khuyến Mãi "+i);
            for(int j = 1;j<10;j++){
                list.add(new Product(100,"Product"+j));
            }
            dm.setAllItemsInSection(list);
            allSampleData.add(dm);
        }
        HomeData adapter = new HomeData(getActivity(), allSampleData);
        recyclerView.setAdapter(adapter);
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
