package com.nanddgroup.tutorial13.ListUtils;

import android.net.Uri;

/**
 * Created by Nikita on 05.02.2016.
 */
public class Item {
    protected String sName;
    protected String sSurname;
    protected String sEmail;
    protected String sTitle;
    protected String sData;
    protected Uri logoId;
    protected static final String NAME_PREFIX = "Name_";
    protected static final String SURNAME_PREFIX = "Surname_";
    protected static final String EMAIL_PREFIX = "email_";

    public Item(String sEmail, String sName, String sSurname, String sTitle, String sData, Uri logoId) {
        this.sEmail = sEmail;
        this.sName = sName;
        this.sSurname = sSurname;
        this.sTitle = sTitle;
        this.sData = sData;
        this.logoId = logoId;
    }
}
