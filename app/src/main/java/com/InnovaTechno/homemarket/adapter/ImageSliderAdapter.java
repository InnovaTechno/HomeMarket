package com.InnovaTechno.homemarket.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.InnovaTechno.homemarket.R;
import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class ImageSliderAdapter extends SliderViewAdapter<ImageSliderAdapter.SliderAdapterVH> {

    private Context context;

    public ImageSliderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {
        //viewHolder.textViewDescription.setText("This is slider item " + position);

        switch (position) {
            case 0:
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.athome)
                        .into(viewHolder.imageView);
                break;
            case 1:
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.freshfruits)
                        .into(viewHolder.imageView);
                break;
            case 2:
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.freshboisson)
                        .into(viewHolder.imageView);
                break;

            case 3:
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.methoddpayment)
                        .into(viewHolder.imageView);
                break;
            case 4:
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.homemerkett)
                        .into(viewHolder.imageView);
                break;
            case 5:
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.fastdelivery)
                        .into(viewHolder.imageView);
                break;
            case 6:
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.phone)
                        .into(viewHolder.imageView);
            default:


        }

    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return 7;
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {
        View itemView;
        ImageView imageView;


        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            this.itemView = itemView;
        }
    }
}

