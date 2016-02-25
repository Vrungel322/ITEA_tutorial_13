package com.nanddgroup.tutorial13.ListUtils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nanddgroup.tutorial13.R;

import java.util.List;

/**
 * Created by Nikita on 05.02.2016.
 */
public class ItemAdapter extends ArrayAdapter<Item> {
    Context context;
    List<Item> items;

    public ItemAdapter(Context context, int resource, List<Item> items) {
        super(context, resource, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rootView = null;
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rootView = inflater.inflate(R.layout.each_item, parent, false);
        }
        else {
            rootView = convertView;
        }

        TextView tvTitle = (TextView) rootView.findViewById(R.id.title);
        tvTitle.setText(items.get(position).sTitle);
        ImageView ivLogo = (ImageView) rootView.findViewById(R.id.ivLogo);
        ivLogo.setImageURI(items.get(position).logoId);
        TextView tvName = (TextView) rootView.findViewById(R.id.txtName);
        tvName.setText(items.get(position).sName);
        TextView tvSurname = (TextView) rootView.findViewById(R.id.txtSurname);
        tvSurname.setText(items.get(position).sSurname);
        TextView tvEmail = (TextView) rootView.findViewById(R.id.txtEmail);
        tvEmail.setText(items.get(position).sEmail);
        TextView tvData = (TextView) rootView.findViewById(R.id.txtData);
        tvData.setText(items.get(position).sData);
        return rootView;
    }
}
