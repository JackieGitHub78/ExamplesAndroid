package com.example.dtit.fragments.com.example.dtit.Fragmentos;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dtit.fragments.R;

/**
 * Created by dtit on 02/03/16.
 */
public class fragment_page extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public static fragment_page newInstance(int page)
    {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        fragment_page fragment = new fragment_page();
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        tvTitle.setText("Fagment #" + mPage);
        return view;
    }
}
