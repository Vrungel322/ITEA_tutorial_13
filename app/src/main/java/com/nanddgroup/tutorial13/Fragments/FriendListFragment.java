package com.nanddgroup.tutorial13.Fragments;


import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.nanddgroup.tutorial13.ListUtils.Item;
import com.nanddgroup.tutorial13.ListUtils.ItemAdapter;
import com.nanddgroup.tutorial13.ListUtils.ListData_Item;
import com.nanddgroup.tutorial13.MainActivity;
import com.nanddgroup.tutorial13.MyDialogFragment;
import com.nanddgroup.tutorial13.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FriendListFragment extends ListFragment {
    public static List<Item> data;
    public static ItemAdapter cardViewAdapter;
    MyDialogFragment dfNewPerson;
    public static ListAdapter listAdapter;


    public FriendListFragment() {
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MainActivity.fabAdd.setVisibility(View.VISIBLE);
        MainActivity.fabAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.HardRockColor)));
        MainActivity.fabClearAll.setVisibility(View.VISIBLE);
        MainActivity.fabClearAll.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.HardRockColor)));
        data = ListData_Item.initItem();
        cardViewAdapter = new ItemAdapter(getActivity(), R.layout.each_item, data);
        setListAdapter(cardViewAdapter);
        listAdapter = this.getListAdapter();

        MainActivity.fabClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.clear();
                cardViewAdapter.notifyDataSetChanged();
            }
        });

        MainActivity.fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dfNewPerson = new MyDialogFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                dfNewPerson.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
                dfNewPerson.show(ft, "dfNewPerson");

            }
        });
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        data.remove(position);
        cardViewAdapter.notifyDataSetChanged();
    }

}
