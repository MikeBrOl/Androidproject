package dk.ucn.androidproject.activities;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import dk.ucn.androidproject.R;
import dk.ucn.androidproject.model.ItemCategory;
import dk.ucn.androidproject.model.ItemDescription;

/**
 * Created by ki on 23-10-2015.
 */
public class ExpandableItemListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<ItemCategory> listDataHeader;
    private HashMap<String, List<ItemDescription>> listDataChild;

    public ExpandableItemListAdapter(Context context, HashMap<String, List<ItemDescription>> listDataChild, List<ItemCategory> listDataHeader) {
        this.context = context;
        this.listDataChild = listDataChild;
        this.listDataHeader = listDataHeader;
    }

    @Override
    public int getGroupCount() {
        return this.listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        String header = listDataHeader.get(groupPosition).getTitle();
        return this.listDataChild.get(header).size();
    }

    @Override
    public ItemCategory getGroup(int groupPosition) {
        return this.listDataHeader.get(groupPosition);
    }

    @Override
    public ItemDescription getChild(int groupPosition, int childPosition) {
        String header = this.listDataHeader.get(groupPosition).getTitle();
        return this.listDataChild.get(header).get(childPosition);
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
        GroupViewHolder viewHolder;
        String headerTitle = (String)getGroup(groupPosition).getTitle();

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.expandable_list_group, null);
            viewHolder = new GroupViewHolder();
            viewHolder.txtGroupHeader = (TextView)convertView.findViewById(R.id.lblListHeader);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (GroupViewHolder)convertView.getTag();
        }

        //TextView lblListHeader = (TextView)convertView.findViewById(R.id.lblListHeader);
        viewHolder.txtGroupHeader.setTypeface(null, Typeface.BOLD);
        viewHolder.txtGroupHeader.setText(headerTitle);
        return convertView;

    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        //TODO Holderpattern
        final String childText = (String)getChild(groupPosition, childPosition).getDescription();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.expandable_list_item, null);
        }
        TextView txtListChild = (TextView) convertView.findViewById(R.id.lblListItem);
        txtListChild.setText(childText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public static class GroupViewHolder {
        private TextView txtGroupHeader;
    }

    public static class ChildViewHolder {
        private TextView txtChildText;
    }
}

