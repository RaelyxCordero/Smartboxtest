package com.smartboxtv.smartboxtest.mvp.views;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartboxtv.smartboxtest.R;
import com.smartboxtv.smartboxtest.bdd.DataModels.EventResponse;
import com.smartboxtv.smartboxtest.utils.MessageEventType;
import com.smartboxtv.smartboxtest.utils.Utils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListFragment extends Fragment {
    public final static String TAG = ListFragment.class.getSimpleName();

    static EventResponse data;
    @BindView(R.id.rvList)
    RecyclerView rvList;
    EventsAdapter adapter;
    private int currentPage = 1;
    private boolean isLastPage = false;
    private boolean isLoading = false;

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
        EventBus.getDefault().register(this);

        loadListEvent(data.getData().getPagination().getPage(),
                data.getData().getPagination().getLast());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvList.setLayoutManager(linearLayoutManager);
        rvList.setHasFixedSize(true);
        rvList.addOnScrollListener(new PaginationScrollListener(linearLayoutManager) {
            @Override
            protected void loadMoreItems() {
                isLoading = true;
                EventBus.getDefault().post(new Object[]{MessageEventType.HEY_PRESENTER_GET_EVENTS, currentPage+1});
            }

            @Override
            public boolean isLastPage() {
                return isLastPage;
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }
        });
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

    public void loadListEvent( int page, int last) {
        if (page == 1)
            adapter = new EventsAdapter(data.getData().getItems(), getContext());
            rvList.setAdapter(adapter);

        if (page < last){
            adapter.addLoadingFooter();
            adapter.notifyDataSetChanged();
        }
        else {
            isLastPage = true;
            adapter.removeLoadingFooter();
            adapter.notifyDataSetChanged();
        }
        currentPage = page;
    }

    @Subscribe
    public void onEvent(Object[] args) {
        if (!(args[0] instanceof Integer)) return;

        int type = (int) args[0];

        switch (type) {
            case MessageEventType.HEY_VIEW_ADD_EVENTS:
                EventResponse data = (EventResponse) args[1];
                adapter.addAll(data.getData().getItems());
                loadListEvent(data.getData().getPagination().getPage(),
                        data.getData().getPagination().getLast());
                break;
        }
    }
}
