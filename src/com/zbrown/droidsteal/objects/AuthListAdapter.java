/*
 * AuthListAdapter.java shows the captured authentications within a list
 * Copyright (C) 2013 Zach Brown <Zbob75x@gmail.com>
 * 
 * This software was supported by the University of Trier
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package com.zbrown.droidsteal.objects;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zbrown.droidsteal.R;
import com.zbrown.droidsteal.activities.ListenActivity;
import com.zbrown.droidsteal.auth.Auth;

public class AuthListAdapter extends BaseAdapter {

    private Context context;

    public AuthListAdapter(Context context) {
        this.context = context;
    }

    public int getCount() {
        return ListenActivity.authList.size();
    }

    public Auth getItem(int position) {
        return ListenActivity.authList.get(position);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LinearLayout itemLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.listelement, parent, false);

        if (position >= ListenActivity.authList.size())
            return itemLayout;

        if (ListenActivity.authList == null || ListenActivity.authList.get(position) == null) {
            return itemLayout;
        }
        Auth auth = ListenActivity.authList.get(position);

        TextView tv1 = (TextView) itemLayout.findViewById(R.id.listtext1);
        TextView tv2 = (TextView) itemLayout.findViewById(R.id.listtext2);
        ImageView imgView = (ImageView) itemLayout.findViewById(R.id.image);

        tv1.setText(auth.getName());

        if (auth.isGeneric()) {
            tv1.setTextColor(Color.BLACK);
        } else {
            tv1.setTextColor(Color.BLACK);
        }

        if (auth.isGeneric() || auth.getName() == null || auth.getName().equals("")) {
            tv2.setText(auth.getIp() + " ID: " + auth.getId() + (auth.isSaved() ? " << SAVED >>" : ""));
        } else {
            tv2.setText(auth.getIp() + " " + auth.getName() + "@" + auth.getUrl());
        }

        if (auth.isSaved()) {
            itemLayout.setBackgroundColor(Color.argb(150, 155, 166, 166));
            tv2.setTextColor(Color.BLACK);
        }

        if (auth.getUrl().contains("amazon")) {
            imgView.setImageDrawable(context.getResources().getDrawable(R.drawable.amazon));
        } else if (auth.getUrl().contains("ebay")) {
            imgView.setImageDrawable(context.getResources().getDrawable(R.drawable.ebay));
        } else if (auth.getUrl().contains("facebook")) {
            imgView.setImageDrawable(context.getResources().getDrawable(R.drawable.facebook));
        } else if (auth.getUrl().contains("flickr")) {
            imgView.setImageDrawable(context.getResources().getDrawable(R.drawable.flickr));
        } else if (auth.getUrl().contains("google")) {
            imgView.setImageDrawable(context.getResources().getDrawable(R.drawable.google));
        } else if (auth.getUrl().contains("linkedin")) {
            imgView.setImageDrawable(context.getResources().getDrawable(R.drawable.linkedin));
        } else if (auth.getUrl().contains("twitter")) {
            imgView.setImageDrawable(context.getResources().getDrawable(R.drawable.twitter));
        } else if (auth.getUrl().contains("youtube")) {
            imgView.setImageDrawable(context.getResources().getDrawable(R.drawable.youtube));
        } else if (auth.getUrl().contains("reddit")) {
            imgView.setImageDrawable(context.getResources().getDrawable(R.drawable.reddit));
        } else if (auth.getUrl().contains("edmodo")) {
            imgView.setImageDrawable(context.getResources().getDrawable(R.drawable.edmodo));
        } else {
            imgView.setImageDrawable(context.getResources().getDrawable(R.drawable.carrots));
        }

        return itemLayout;
    }

    public long getItemId(int position) {
        return position;
    }

}
