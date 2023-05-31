package com.example.lab2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ProducViewHolder> {

    private Context mContext;
    private List<Product> mListProduct;
    private ItemClickListener mClickListener;

    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
    public MyRecyclerViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<Product> list) {
        this.mListProduct = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProducViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview,parent,false);
        return new ProducViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProducViewHolder holder, int position) {
        Product product = mListProduct.get(position);
        if (product == null) {
            return;
        }
        holder.imageP.setImageResource(product.getImage());
        holder.nameP.setText(product.getName());
    }

    @Override
    public int getItemCount() {
        if (mListProduct != null) {
            return mListProduct.size();
        }
        return 0;
    }

    Product getItem(int id) {
        return mListProduct.get(id);
    }

    public class ProducViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView nameP;
        private ImageView imageP;

        public ProducViewHolder(View itemView) {
            super(itemView);

            imageP = itemView.findViewById(R.id.image_product);
            nameP = itemView.findViewById(R.id.text_product);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null)
                mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
}