package com.example.fls.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fls.R;
import com.example.fls.models.Product;

import java.util.ArrayList;

/**
 * Created by HieuHo on 3/1/2017.
 */

public class SectionListHomeData extends RecyclerView.Adapter<SectionListHomeData.SingleItemRowHolder> {
    public ArrayList<Product> itemsList;
    public Context mContext;
    public SectionListHomeData(Context context, ArrayList<Product> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_card, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(SectionListHomeData.SingleItemRowHolder holder, int position) {
        View view = null;
        Product product = itemsList.get(position);
        holder.tvTitle.setText(product.getNameProduct());
        holder.tvPrice.setText(product.getPriceProduct()+"");
    }

    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView tvTitle,tvPrice;

        protected ImageView itemImage;


        public SingleItemRowHolder(View view) {
            super(view);

            this.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            this.itemImage = (ImageView) view.findViewById(R.id.itemImage);
            this.tvPrice = (TextView) view.findViewById(R.id.tvPrice);
        }

    }
}
