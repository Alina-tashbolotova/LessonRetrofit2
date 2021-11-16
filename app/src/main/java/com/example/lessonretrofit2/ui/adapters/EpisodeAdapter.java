package com.example.lessonretrofit2.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lessonretrofit2.data.models.episode.EpisodeModel;
import com.example.lessonretrofit2.databinding.ItemEpisodeBinding;
import com.example.lessonretrofit2.interfaces.OnItemClickListener;

import java.util.ArrayList;

public class EpisodeAdapter extends RecyclerView.Adapter<EpisodeAdapter.ViewHolder> {

    private ArrayList<EpisodeModel> list = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    @NonNull
    @Override
    public EpisodeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EpisodeAdapter.ViewHolder(
                ItemEpisodeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodeAdapter.ViewHolder holder, int position) {
        holder.onBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addList(ArrayList<EpisodeModel> model) {
        this.list = model;
        notifyDataSetChanged();

    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemEpisodeBinding binding;

        public ViewHolder(@NonNull ItemEpisodeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;


            binding.getRoot().setOnClickListener(v -> {
                onItemClickListener.onItemClick(getAdapterPosition());
            });
        }

        private void onBind(EpisodeModel episodeModel) {
            binding.txtItemName.setText(episodeModel.getName());
            binding.txtItemEpisode.setText(episodeModel.getEpisode());
            binding.txtItemCreated.setText(episodeModel.getCreated());
            binding.txtItemAirDate.setText(episodeModel.getAir_date());

        }
    }
}
