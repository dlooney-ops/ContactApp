package com.example.contactapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactAdapter extends BaseAdapter {

    Activity mActivity;
    AddressBook addressBook;

    public ContactAdapter(Activity mActivity, AddressBook addressBook) {
        this.mActivity = mActivity;
        this.addressBook = addressBook;
    }

    @Override
    public int getCount() {
        return addressBook.getContactList().size();
    }

    @Override
    public Object getItem(int position) {
        return addressBook.getContactList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View oneContactLine;
        LayoutInflater inflater = (LayoutInflater)mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        oneContactLine = inflater.inflate(R.layout.one_contact_line, parent, false);

        TextView tv_contactName = oneContactLine.findViewById(R.id.tv_contactName);
        TextView tv_contactPhone = oneContactLine.findViewById(R.id.tv_contactPhone);
        ImageView iv_icon = oneContactLine.findViewById(R.id.iv_icon);

        BaseContact p = (BaseContact) this.getItem(position);

        tv_contactName.setText(p.getName());
        tv_contactPhone.setText(p.getPhone());

        int icon_resource_numbers [] = {
                R.drawable.icon04,
                R.drawable.icon08,
                R.drawable.icon09,
                R.drawable.icon10,
                R.drawable.icon11,
                R.drawable.icon12,
                R.drawable.icon13,
                R.drawable.icon14,
                R.drawable.icon15,
                R.drawable.icon16,
                R.drawable.icon17,
                R.drawable.icon18
        };

        iv_icon.setImageResource(icon_resource_numbers[position]);

        return oneContactLine;
    }
}
