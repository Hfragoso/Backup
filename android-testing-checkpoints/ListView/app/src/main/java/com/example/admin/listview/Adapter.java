package com.example.admin.listview;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Admin on 8/21/2017.
 */

public class Adapter extends ArrayAdapter<String> {
    public Adapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    public Adapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<String> items) {
        super(context, resource, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder v = new ViewHolder();

        LayoutInflater adapInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        convertView = adapInflater.inflate(R.layout.row_layout,parent,false);



        v.vhName = (TextView) convertView.findViewById(R.id.rowText);



        v.vhName.setText(myList.get(position));



        convertView.setTag(v);

        return convertView;
    }

    static class ViewHolder{
        TextView vhName;
    }
}
