package com.example.fls.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.fls.R;
import com.example.fls.models.Cart;
import com.example.fls.utils.LoadImage;

import java.util.List;

/**
 * Created by HieuHo on 3/4/2017.
 */

public class CustomCart extends RecyclerView.Adapter<CustomCart.Holder>{


    private List<Cart> List;
    public Context context;

    public CustomCart(Context context,List<Cart> List){
        this.context = context;
        this.List = List;
    }

    public class Holder extends RecyclerView.ViewHolder {
        public NetworkImageView hinh;
        public TextView ten, danhmuc, tongtien;
        public EditText soluong;
        public ImageButton imbGiam,imbTang,btnxoa;
        public Holder(View view) {
            super(view);
            hinh = (NetworkImageView) view.findViewById(R.id.imgGiohang);
            ten = (TextView) view.findViewById(R.id.tenTV);
            danhmuc = (TextView) view.findViewById(R.id.DanhMucTV);
            soluong = (EditText) view.findViewById(R.id.edtSoLuong);
            tongtien = (TextView) view.findViewById(R.id.Tongtien);
            imbGiam = (ImageButton) view.findViewById(R.id.bttru);
            imbTang = (ImageButton) view.findViewById(R.id.btcong);
            btnxoa = (ImageButton) view.findViewById(R.id.btnxoa);
        }
    }
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_cart, parent, false);

        return new Holder(itemView);
    }

    @Override
    public void onBindViewHolder(final Holder holder, final int position) {
        View v;
        final Cart GioHang = List.get(position);

        holder.ten.setText(GioHang.getProductName());
/*        holder.danhmuc.setText(GioHang.getPriceProduct());*/
        holder.soluong.setText(GioHang.getNumberProduct()+"");
        holder.tongtien.setText(GioHang.getTotalCash()+"");
        ImageLoader imageLoader = LoadImage.getInstance(context).getImageLoader();
        imageLoader.get("https://cdn.tgdd.vn/Products/Images/42/87840/iphone-7-plus-256gb-2-400x460.png",ImageLoader.getImageListener(holder.hinh,R.mipmap.ic_launcher,R.mipmap.ic_launcher));
        holder.hinh.setImageUrl("https://cdn.tgdd.vn/Products/Images/42/87840/iphone-7-plus-256gb-2-400x460.png",imageLoader);

        holder.imbTang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer  s1 = Integer.parseInt(holder.soluong.getText().toString());
                int tong = s1 + 1;
                holder.soluong.setText(tong + "");
                int tongtien = GioHang.getPriceProduct() * tong;
                holder.tongtien.setText(tongtien+"");
                holder.soluong.setText(tong+"");


            }
        });

        holder.imbGiam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sl =1;
                sl = Integer.parseInt(holder.soluong.getText().toString());

                if(sl <= 1){
                    Toast.makeText(context,"Không Được Giảm",Toast.LENGTH_SHORT).show();
                    holder.imbGiam.setEnabled(false);
                    holder.imbTang.setEnabled(true);
                }else{
                    holder.imbTang.setEnabled(true);
                    int tong = sl - 1 ;
                    holder.soluong.setText(tong+"");
                    int tongtien =GioHang.getPriceProduct()* tong;
                    holder.tongtien.setText(tongtien);

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return List.size();
    }

}
