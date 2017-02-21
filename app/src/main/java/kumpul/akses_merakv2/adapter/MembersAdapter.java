package kumpul.akses_merakv2.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import kumpul.akses_merakv2.R;
import kumpul.akses_merakv2.databaseobject.SpaceMember;

/**
 * Created by Arjen on 20-2-2017.
 */

public class MembersAdapter extends ArrayAdapter<SpaceMember> {
    public MembersAdapter(Context context, int resource, List<SpaceMember> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.memberlist_item, parent, false);
        }

        TextView messageTextView = (TextView) convertView.findViewById(R.id.memberName);
        TextView authorTextView = (TextView) convertView.findViewById(R.id.memberEmail);

        SpaceMember spaceMember = getItem(position);

        messageTextView.setText(spaceMember.getName());
        authorTextView.setText(spaceMember.getEmail());

        return convertView;
    }
}
