package com.example.lessonretrofit2.ui.adapters;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lessonretrofit2.data.models.character.CharacterModel;
import com.example.lessonretrofit2.databinding.ItemCharacterBinding;
import com.example.lessonretrofit2.interfaces.OnItemClickListener;

import java.util.ArrayList;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> {

    private ArrayList<CharacterModel> list = new ArrayList<>();
    private OnItemClickListener clickListener;

    @NonNull
    @Override
    public CharacterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CharacterAdapter.ViewHolder(
                ItemCharacterBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterAdapter.ViewHolder holder, int position) {
        holder.onBind(list.get(position));

    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.clickListener = listener;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addList(ArrayList<CharacterModel> characterModels) {
        this.list = characterModels;
        notifyDataSetChanged();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemCharacterBinding binding;

        public ViewHolder(@NonNull ItemCharacterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        private void onBind(CharacterModel model) {
            Glide.with(binding.imageItemCharacter).load(model.getImage()).into(binding.imageItemCharacter);
            binding.txtItemCharacterName.setText(model.getName());
            binding.getRoot().setOnClickListener(v -> {
                clickListener.onItemClick(model.getId());
            });


        }
    }


}
