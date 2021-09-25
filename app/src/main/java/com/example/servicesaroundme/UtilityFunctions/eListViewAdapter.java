package com.example.servicesaroundme.UtilityFunctions;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class eListViewAdapter extends BaseExpandableListAdapter {

    ArrayList<String> level1Node;
    HashMap<String, ArrayList<String>> level2Node;

    public eListViewAdapter(ArrayList<String> level1Node, HashMap<String, ArrayList<String>> level2Node) {
        this.level1Node = level1Node;
        this.level2Node = level2Node;
    }

    @Override
    public int getGroupCount() {
        return level1Node.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return level2Node.get(level1Node.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return level1Node.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return level2Node.get(level1Node.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_expandable_list_item_1, parent, false);

        TextView textView = convertView.findViewById(android.R.id.text1);
        String strLevel1Node = String.valueOf(getGroup(groupPosition));
        textView.setText(strLevel1Node);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setTextColor(Color.BLUE);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_selectable_list_item, parent, false);
        TextView textView = convertView.findViewById(android.R.id.text1);
        String strLevel2Node = String.valueOf(getChild(groupPosition, childPosition));
        textView.setText(strLevel2Node);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(parent.getContext(), strLevel2Node, Toast.LENGTH_LONG).show();
            }
        });

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
