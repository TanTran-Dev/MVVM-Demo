package com.trantan.mvvm_demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.trantan.mvvm_demo.R;
import com.trantan.mvvm_demo.model.NicePlace;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<NicePlace> nicePlaces;

    public RecyclerViewAdapter(Context context, List<NicePlace> nicePlaces) {
        this.context = context;
        this.nicePlaces = nicePlaces;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_nice_place, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NicePlace nicePlace = nicePlaces.get(position);
        ((ViewHolder) holder).txtTitle.setText(nicePlace.getTittle());

        RequestOptions requestOptions = new RequestOptions()
                .error(R.drawable.ic_launcher_background);

        Glide.with(context)
                .setDefaultRequestOptions(requestOptions)
                .load(nicePlace.getImageUrl())
                .into(((ViewHolder) holder).imgNicePlace);
    }

    @Override
    public int getItemCount() {
        return nicePlaces.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_nice_place)
        CircleImageView imgNicePlace;

        @BindView(R.id.txt_title)
        TextView txtTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
