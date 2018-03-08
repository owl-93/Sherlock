package com.example.android.sherlock.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.sherlock.R;
import com.example.android.sherlock.model.Item;
import com.example.android.sherlock.model.Store;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

/**
 * Created by stephen on 3/7/18.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<Item> itemData;
    private Map<Long, Store> storeMap;
    private Context c;
    private NumberFormat formatter = NumberFormat.getCurrencyInstance();
    private Random r = new Random();


    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView nameText;
        TextView descText;
        TextView priceText;
        TextView distanceText;
        TextView storeText;
        ImageView image;

        public ViewHolder(View itemView ) {
            super(itemView);
            cv =  itemView.findViewById(R.id.product_card);
            nameText =  itemView.findViewById(R.id.card_productName);
            descText = itemView.findViewById(R.id.card_productDescription);
            priceText = itemView.findViewById(R.id.card_productPrice);
            distanceText= itemView.findViewById(R.id.card_productDistance);
            storeText = itemView.findViewById(R.id.card_productStore);
            image = itemView.findViewById(R.id.card_productImage);
        }
    }

    public RecyclerAdapter(Context c, List<Item> itemData, Map<Long, Store> storeMap) {
        this.itemData = itemData;
        this.storeMap = storeMap;
        this.c = c;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_card, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item i = itemData.get(position);
        Store s = storeMap.get(i.getStoreId());
        holder.nameText.setText(i.getName());
        holder.descText.setText(i.getDescription());
        holder.priceText.setText(formatter.format(i.getPrice()));
        if(s != null){
            holder.storeText.setText(s.getStoreName());
        }
        holder.distanceText.setText("0.3mi");
        Picasso.with(c).load(i.getImageUrl()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return this.itemData.size();
    }
}