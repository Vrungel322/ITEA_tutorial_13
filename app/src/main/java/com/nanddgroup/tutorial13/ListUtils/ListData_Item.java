package com.nanddgroup.tutorial13.ListUtils;

import android.net.Uri;

import com.nanddgroup.tutorial13.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikita on 05.02.2016.
 */
public class ListData_Item extends Item {
    private static Uri imageUri= Uri.parse("android.resource://com.nanddgroup.tutorial13/" + R.drawable.def_logo);
    public ListData_Item(String sEmail, String sName, String sSurname, String sTitle, String sData, Uri logoId) {
        super(sEmail, sName, sSurname, sTitle, sData, logoId);
    }

    public static List<Item> initItem(){
        List<Item> items  = new ArrayList<Item>();
        for (int i = 0; i < 20; i++){
            items.add(i, new Item(EMAIL_PREFIX + "_" + i + "@text.com", NAME_PREFIX + "_" + i, SURNAME_PREFIX + "_" + i, "Title_" + i, "" + i + "/" + "" + i + "/" + "" + i, imageUri));
        }
        return items;
    }

}
