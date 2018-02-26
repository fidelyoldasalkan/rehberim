package tr.com.fid.rehberim.fragment;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.Vector;

import tr.com.fid.rehberim.R;
import tr.com.fid.rehberim.activity.MainActivity;
import tr.com.fid.rehberim.adapter.CallHistoryAdapter;
import tr.com.fid.rehberim.adapter.PersonListAdapter;
import tr.com.fid.rehberim.model.Person;
import tr.com.fid.rehberim.repository.FragmentTagRepository;

/**
 * Created by fidel on 25.02.2018.
 */

public class CallHistoryFragment extends BaseFragment {

    private RecyclerView callHistoriesRecyclerView;
    private CallHistoryAdapter callHistoryAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void setFragmentView(View fragmentView) {
        callHistoriesRecyclerView = fragmentView.findViewById(R.id.recycler_view_call_history);
        MainActivity activity = (MainActivity) getActivity();
        callHistoryAdapter = new CallHistoryAdapter(activity);
        layoutManager = new LinearLayoutManager(activity);
        callHistoriesRecyclerView.setLayoutManager(layoutManager);
        callHistoriesRecyclerView.setItemAnimator(new DefaultItemAnimator());
        callHistoriesRecyclerView.setAdapter(callHistoryAdapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_call_history;
    }

    @Override
    public String getFragmentTag() {
        return FragmentTagRepository.CALL_HISTORY_FRAGMENT;
    }

    @Override
    public String getSubTitle() {
        return "call history";
    }
}
