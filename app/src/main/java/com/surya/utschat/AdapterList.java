package com.surya.utschat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class AdapterList extends RecyclerView.Adapter<AdapterList.ViewHolder> {
    private List<ItemList> itemList;

    public AdapterList(List<ItemList> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public AdapterList.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat, null);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterList.ViewHolder holder, int position) {
        ItemList item = itemList.get(position);
        holder.nama.setText(item.getNama());
        holder.displayText.setText(item.getDisplayText());
        holder.displayTime.setText(item.getDisplayTime());
        Glide.with(holder.fotoProfile.getContext()).load(item.getImageUrl()).into(holder.fotoProfile);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView fotoProfile;
        public TextView nama, displayTime, displayText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fotoProfile = itemView.findViewById(R.id.fotoProfile);
            nama = itemView.findViewById(R.id.nama);
            displayText = itemView.findViewById(R.id.displayText);
            displayTime = itemView.findViewById(R.id.displayTime);
        }
    }
}
