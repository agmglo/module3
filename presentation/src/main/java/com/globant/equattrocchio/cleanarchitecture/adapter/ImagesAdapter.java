package com.globant.equattrocchio.cleanarchitecture.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.globant.equattrocchio.cleanarchitecture.R;
import com.globant.equattrocchio.cleanarchitecture.util.bus.RxBus;
import com.globant.equattrocchio.cleanarchitecture.util.bus.observers.ImageClickObserver;
import com.globant.equattrocchio.domain.response.Image;
import com.globant.equattrocchio.domain.response.Result;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ViewHolder> {
    private Result result;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        ProgressBar progressBar;

        ViewHolder(View root) {
            super(root);
            this.imageView = root.findViewById(R.id.image_adapter);
            this.progressBar = root.findViewById(R.id.progress_adapter);
        }

        void bind(final Image item) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RxBus.post(new ImageClickObserver.ImagePressed(item.getImageId()));
                }
            });
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
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.bind(result.getImages().get(position));
        Picasso.with(holder.imageView.getContext())
                .load(result.getImages().get(position).getUrl())
                .into(holder.imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        holder.progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {
                        holder.progressBar.setVisibility(View.GONE);
                    }
                });
    }

    @Override
    public int getItemCount() {
        return result.getImages().size();
    }
}