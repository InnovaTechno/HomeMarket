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

import com.InnovaTechno.homemarket.GlideApp;
import com.InnovaTechno.homemarket.Models.Card;
import com.InnovaTechno.homemarket.Models.CardInfo;
import com.InnovaTechno.homemarket.R;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class CardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //private final int VIEW_TYPE_IMAGE = "0" ;
   // final int VIEW_TYPE_INFO = "1";

    private Context context;
   private List<Card> mData;
   private List<CardInfo> mInfo;


    public CardAdapter(Context context, List<Card> mData, List<CardInfo> mInfo) {
        this.context = context;
        this.mData = mData;
        this.mInfo = mInfo;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        if(viewType == 0){
            itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_card,parent,false);
            return new ImageViewHolder(itemView);
        }

        if(viewType == 1) {
            itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.credit_card_info,parent,false);
            return new InfoViewHolder(itemView);

        }
        return null;
        // return new ViewHolder(itemView)

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof ImageViewHolder) {
            ((ImageViewHolder) viewHolder).populate(mData.get(position));
        }

        if (viewHolder instanceof InfoViewHolder) {
            ((InfoViewHolder) viewHolder).populate(mInfo.get(position - mData.size()));

        }
    }

    //@Override
   // public void onBindViewHolder(@NonNull CardAdapter.ViewHolder holder, int position) {
             // holder.cardIcon.setImageResource(mData.get(position).getImage());
            //CardInfo cardInfo = info.get(position);
            // holder.bind(cardInfo);

    @Override
    public int getItemCount() {
       return mData.size() + mInfo.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position < mData.size()){
            return 0;
        }

        if(position - mData.size() < mInfo.size()){
            return 1;
        }

        return -1;
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{
        ImageView cardIcon;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            cardIcon = itemView.findViewById(R.id.cardIcon);

        }
        public void populate(Card card){
            GlideApp.with(context)
                    .load(card.getImage())
                    .into(cardIcon) ;
        }
    }

    public class InfoViewHolder extends RecyclerView.ViewHolder{
        TextView tvCardNumber, tvCardName, tvExpDate;

        public InfoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCardName = itemView.findViewById(R.id.tvCardName);
            tvCardNumber = itemView.findViewById(R.id.tvCardNumber);
            tvExpDate = itemView.findViewById(R.id.tvExpDate);
        }
        public void populate(CardInfo cardInfo){
            tvCardNumber.setText(cardInfo.getNumber());
            tvCardName.setText(cardInfo.getName());
            tvExpDate.setText(cardInfo.getDate());

        }

        //  public class ViewHolder extends RecyclerView.ViewHolder {
      //  ImageView cardIcon;
       // TextView tvCardNumber, tvCardName, tvExpDate;

        // public ViewHolder(@NonNull View itemView) {
        //    super(itemView);
          // context = itemView.getContext();
          //  cardIcon = itemView.findViewById(R.id.cardIcon);
           // tvCardName = itemView.findViewById(R.id.tvCardName);
        //    tvCardNumber = itemView.findViewById(R.id.tvCardNumber);
      //      tvExpDate = itemView.findViewById(R.id.tvExpDate); }

       // public void bind(CardInfo cardInfo) {
       //     tvCardNumber.setText(cardInfo.getNumber());
       //     tvCardName.setText(cardInfo.getName());
         //   tvExpDate.setText(cardInfo.getDate());

        }
   // }


}
