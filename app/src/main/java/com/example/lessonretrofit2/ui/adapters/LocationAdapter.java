package com.example.lessonretrofit2.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lessonretrofit2.data.models.location.LocationModel;
import com.example.lessonretrofit2.databinding.ItemLocationBinding;
import com.example.lessonretrofit2.interfaces.OnItemClickListener;

import java.util.ArrayList;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.ViewHolder> {

    private ArrayList<LocationModel> list = new ArrayList<>();
    private OnItemClickListener itemClickListener;

    @NonNull
    @Override
    public LocationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LocationAdapter.ViewHolder(
                ItemLocationBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull LocationAdapter.ViewHolder holder, int position) {
        holder.onBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addList(ArrayList<LocationModel> models) {
        this.list = models;
        notifyDataSetChanged();
    }

    public void setItemClickListener(OnItemClickListener listener) {
        this.itemClickListener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemLocationBinding binding;

        public ViewHolder(@NonNull ItemLocationBinding binding) {
            super(binding.getRoot());
            this.binding = binding;


            binding.getRoot().setOnClickListener(v -> {
                itemClickListener.onItemClick(getAdapterPosition());
            });
        }

        private void onBind(LocationModel locationModel) {
            binding.txtItemName.setText(locationModel.getName());
            binding.txtItemDimension.setText(locationModel.getDimension());
            binding.txtItemCreated.setText(locationModel.getCreated());
            binding.txtItemType.setText(locationModel.getType());

        }


    }
}
