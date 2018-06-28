package com.globant.equattrocchio.cleanarchitecture.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.globant.equattrocchio.cleanarchitecture.R;
import com.globant.equattrocchio.domain.response.Result;
import com.squareup.picasso.Picasso;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ViewHolder> {
    private Result result;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        ViewHolder(View root) {
            super(root);
            this.imageView = root.findViewById(R.id.image_adapter);
        }
    }

    public ImagesAdapter(Result result) {
        this.result = result;
    }

    @Override
    public ImagesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_images, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.with(holder.imageView.getContext())
                .load(result.getImages().get(position).getUrl())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return result.getImages().size();
    }
}