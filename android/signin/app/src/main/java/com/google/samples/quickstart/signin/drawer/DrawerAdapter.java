package com.google.samples.quickstart.signin.drawer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.samples.quickstart.signin.R;

import java.util.List;

/**
 * Created by ShentuoZhan on 9/5/16.
 */
public class DrawerAdapter extends BaseAdapter {

    private List<String> titleList;

    public DrawerAdapter(List<String> titleList) {
        this.titleList = titleList;
    }

    @Override
    public int getCount() {
        return this.titleList.size();
    }

    @Override
    public String getItem(int position) {
        return this.titleList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_drawer, parent, false);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            if (viewHolder.title == null){
                viewHolder.title = (TextView) convertView.findViewById(R.id.drawer_title);
            }
        }

        String title = getItem(position);

        viewHolder.title.setText(title);

        return convertView;
    }

    public class ViewHolder {
        TextView title;
        //ImageView button;
        //ImageView icon;

        public ViewHolder(View view) {
            //icon = (ImageView) view.findViewById(R.id.drawer_icon);
            title = (TextView) view.findViewById(R.id.drawer_title);
            //button = (ImageView) view.findViewById(R.id.drawer_button);
        }
    }
}
