package kumpul.akses_merakv2.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import kumpul.akses_merakv2.MainActivity;
import kumpul.akses_merakv2.R;
import kumpul.akses_merakv2.firebase.FireBaseInstaller;

/**
 * Created by Arjen on 21-2-2017.
 */
// In this case, the fragment displays simple text based on the page
public class PageFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public static PageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        if (mPage == 1){
            view = inflater.inflate(R.layout.active_members, container, false);
            new FireBaseInstaller(PageFragment.this.getContext(), (ListView) view.findViewById(R.id.memberListView));
        } else if (mPage == 2){
            view = inflater.inflate(R.layout.page_fragement_layout, container, false);
        } else if (mPage == 3) {
            view = inflater.inflate(R.layout.page_fragement_layout, container, false);
        } else {
            startActivity(new Intent(PageFragment.this.getContext(), MainActivity.class));
            return null;
        }
        return view;
    }
}