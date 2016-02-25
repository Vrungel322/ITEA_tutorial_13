package com.nanddgroup.tutorial13;


import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.DialogFragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.nanddgroup.tutorial13.Fragments.FriendListFragment;
import com.nanddgroup.tutorial13.ListUtils.Item;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyDialogFragment extends DialogFragment {
    private EditText etName;
    private EditText etSurname;
    private EditText etEmail_dialog;
    private EditText etData;
    private ImageView ivLogo;
    private Button bCancel;
    public static Button bOk;
    public static String newName;
    public static String newSurname;
    public static String newEmail;
    public static String newData;
    public static Uri newImage;
    private Uri imageUri;


    public MyDialogFragment() {
        // Required empty public constructor
    }


    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_fragment_layout, container, false);
        ivLogo = (ImageView) view.findViewById(R.id.ivLogo);
        ivLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*"); // to open gallery
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Contact Image"), 1);
            }
        });
        newImage = Uri.parse("android.resource://com.nanddgroup.tutorial13/" + R.drawable.def_logo);
        etName = (EditText) view.findViewById(R.id.etName);
        etSurname = (EditText) view.findViewById(R.id.etSurname);
        etEmail_dialog = (EditText) view.findViewById(R.id.etEmail_dialog);
        etData = (EditText) view.findViewById(R.id.etData);
        bOk = (Button) view.findViewById(R.id.bOk);
        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = FriendListFragment.data.size();
                Item newItem = new Item(getNewEmail(), getNewName(), getNewSurname(),
                        "New Title", getNewData(), getNewImage());
                FriendListFragment.data.add(index, newItem);
                FriendListFragment.cardViewAdapter.notifyDataSetChanged();
                Log.d("TAG", String.valueOf(FriendListFragment.data.size()));
                dismiss();
            }
        });
        bCancel = (Button) view.findViewById(R.id.bCancel);
        bCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return view;
    }

    @SuppressLint("LongLogTag")
    public void onActivityResult(int reqCode, int resCode, Intent data) {
            if (reqCode == 1) {
                imageUri = data.getData();
                ivLogo.setImageURI(data.getData());// set image that was chosen
                newImage = data.getData();

            }
    }

    public String getNewSurname() {
        newSurname = String.valueOf(etSurname.getText());
        return newSurname;
    }

    public  String getNewName() {
        newName = String.valueOf(etName.getText());
        return newName;
    }

    public static Uri getNewImage() {
        return newImage;
    }

    public  String getNewEmail() {
        newEmail = String.valueOf(etEmail_dialog.getText());
        return newEmail;
    }

    public  String getNewData() {
        newData = String.valueOf(etData.getText());
        return newData;
    }

}
