package com.InnovaTechno.homemarket.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.InnovaTechno.homemarket.Models.Card;
import com.InnovaTechno.homemarket.Models.CardInfo;
import com.InnovaTechno.homemarket.R;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private Context context;
   private List<Card> mData;
    private  List<CardInfo> info;


    public CardAdapter(Context context, List<Card> mData, List<CardInfo> data) {
        this.context = context;
        this.mData = mData;
        this.info = info;
    }

    @NonNull
    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(context);
        view = mInflater.inflate(R.layout.cardview_card, parent, false);
        return new ViewHolder(view);

    }



    @Override
    public void onBindViewHolder(@NonNull CardAdapter.ViewHolder holder, int position) {
        holder.cardIcon.setImageResource(mData.get(position).getImage());
        CardInfo cardInfo = info.get(position);
        holder.bind(cardInfo);

    }

    @Override
    public int getItemCount() {
        return info.size() + mData.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView cardIcon;
        TextView tvCardNumber, tvCardName, tvExpDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            cardIcon = itemView.findViewById(R.id.cardIcon);
            tvCardName = itemView.findViewById(R.id.tvCardName);
            tvCardNumber = itemView.findViewById(R.id.tvCardNumber);
            tvExpDate = itemView.findViewById(R.id.tvExpDate);
        }

        public void bind(CardInfo cardInfo) {
            tvCardNumber.setText(cardInfo.getNumber());
            tvCardName.setText(cardInfo.getName());
            tvExpDate.setText(cardInfo.getDate());

        }
    }


}
