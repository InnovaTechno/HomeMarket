package com.InnovaTechno.homemarket.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.InnovaTechno.homemarket.R;
import com.InnovaTechno.homemarket.fragments.HomeFragment;

public class HomeAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private String[] categoriesWord;
    private int[] categoriesImage;

    public HomeAdapter(Context c, String[] categoriesWord, int[] categoriesImage){
        context = c;
        this.categoriesWord = categoriesWord;
        this.categoriesImage = categoriesImage;
    }


    //public HomeAdapter(HomeFragment homeFragment, String[] categoriesWord, int[] categoriesImage) {}

    @Override
    public int getCount() {
        return categoriesWord.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater ==null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null){
            convertView = inflater.inflate(R.layout.row_item, null);
        }

        ImageView imageView= convertView.findViewById(R.id.image_view);
        TextView textView = convertView.findViewById(R.id.text_view);

        imageView.setImageResource(categoriesImage[position]);
        textView.setText(categoriesWord[position]);
        return convertView;
    }
}
