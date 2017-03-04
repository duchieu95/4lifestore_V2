package com.example.fls.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.fls.R;
import com.example.fls.adapters.CustomCart;
import com.example.fls.models.Cart;

import java.util.ArrayList;
import java.util.List;

public class CartOfUsers extends AppCompatActivity {
    private List<Cart> list = new ArrayList<>();
    private RecyclerView recycleGiohang;
    private CustomCart adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Giỏ Hàng");
        setContentView(R.layout.fls_006);
        recycleGiohang = (RecyclerView) findViewById(R.id.recycle_giohang);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recycleGiohang.setLayoutManager(mLayoutManager);
        recycleGiohang.setItemAnimator(new DefaultItemAnimator());
        Getdata();
    }

    private void Getdata(){
        for(int i = 1;i<10;i++){
        list.add(new Cart("Danh Muc "+i,10000,10000));
        }
        adapter = new CustomCart(getApplication(),list);
        recycleGiohang.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
