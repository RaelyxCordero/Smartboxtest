package com.smartboxtv.smartboxtest.mvp.views;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartboxtv.smartboxtest.R;
import com.smartboxtv.smartboxtest.bdd.DataModels.EventResponse;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListFragment extends Fragment {
    public final static String TAG = ListFragment.class.getSimpleName();

    static EventResponse data;
    @BindView(R.id.rvList)
    RecyclerView rvList;

    public ListFragment() {
        // Required empty public constructor
    }

    public static ListFragment newInstance(EventResponse data) {
        ListFragment fragment = new ListFragment();
        ListFragment.data = data;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ButterKnife.bind(this, view);

        EventsAdapter adapter = new EventsAdapter(data.getData().getItems(), getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvList.setLayoutManager(linearLayoutManager);
        rvList.setAdapter(adapter);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
