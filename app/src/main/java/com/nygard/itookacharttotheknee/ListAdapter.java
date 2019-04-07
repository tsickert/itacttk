package com.nygard.itookacharttotheknee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by thoma on 7/13/2016.
 */

public class ListAdapter extends BaseAdapter {
    private ArrayList<Item> items;
    private Context context;
    private LayoutInflater inflater;

    public ListAdapter(Context context, ArrayList<Item> items) {
        this.items = items;
        this.context = context;
        inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem (int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder {
        TextView textView;
        ImageView imageView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.grid_image_row, null);
        holder.textView = (TextView) rowView.findViewById(R.id.gridItemName);
        holder.imageView = (ImageView) rowView.findViewById(R.id.gridItemImage);
        holder.textView.setText(items.get(position).getName());
        holder.imageView.setImageDrawable(items.get(position).getImage());
//        rowView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context,"Clicked Item", Toast.LENGTH_LONG).show();
//            }
//        });
        return rowView;
    }
}
