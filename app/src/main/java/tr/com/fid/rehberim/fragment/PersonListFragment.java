package tr.com.fid.rehberim.fragment;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import tr.com.fid.rehberim.R;
import tr.com.fid.rehberim.activity.MainActivity;
import tr.com.fid.rehberim.adapter.PersonListAdapter;
import tr.com.fid.rehberim.command.GeneralOnClickListener;
import tr.com.fid.rehberim.command.PersonListCommand;
import tr.com.fid.rehberim.command.PersonSaveFragmentCommand;
import tr.com.fid.rehberim.repository.FragmentTagRepository;
import tr.com.fid.rehberim.repository.SubTitleRepository;

/**
 * Created by fidel on 24.02.2018.
 */

public class PersonListFragment extends BaseFragment {

    private RecyclerView personListRecyclerView;
    private PersonListAdapter personAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton actionButton;

    @Override
    protected void setFragmentView(View fragmentView) {
        personListRecyclerView = fragmentView.findViewById(R.id.recycler_view_person_list);
//        setListItem();

        MainActivity activity = (MainActivity) getActivity();
        new PersonListCommand(activity).execute();

        personAdapter = new PersonListAdapter(activity.getPersonVector(), (MainActivity) getActivity());
        layoutManager = new LinearLayoutManager(getActivity());
        personListRecyclerView.setLayoutManager(layoutManager);
        personListRecyclerView.setItemAnimator(new DefaultItemAnimator());
        personListRecyclerView.setAdapter(personAdapter);
        actionButton = fragmentView.findViewById(R.id.button_add_person);
        actionButton.setOnClickListener(new GeneralOnClickListener(new PersonSaveFragmentCommand((MainActivity) getActivity())));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_person_list;
    }

    @Override
    public String getFragmentTag() {
        return FragmentTagRepository.PERSON_LIST_FRAGMENT;
    }

    @Override
    public String getSubTitle() {
        return SubTitleRepository.KISILERIM;
    }

//    private void setListItem(){
//        personVector.add(new Person("Fidel Yoldaş", "Alkan", "05423616962","fidely.alkan@gmail.com"));
//        personVector.add(new Person("Fidel Yoldaş", "Alkan", "05423616962","fidely.alkan@gmail.com"));
//        personVector.add(new Person("Fidel Yoldaş", "Alkan", "05423616962","fidely.alkan@gmail.com"));
//        personVector.add(new Person("Fidel Yoldaş", "Alkan", "05423616962","fidely.alkan@gmail.com"));
//        personVector.add(new Person("Fidel Yoldaş", "Alkan", "05423616962","fidely.alkan@gmail.com"));
//        personVector.add(new Person("Fidel Yoldaş", "Alkan", "05423616962","fidely.alkan@gmail.com"));
//        personVector.add(new Person("Fidel Yoldaş", "Alkan", "05423616962","fidely.alkan@gmail.com"));
//        personVector.add(new Person("Fidel Yoldaş", "Alkan", "05423616962","fidely.alkan@gmail.com"));
//        personVector.add(new Person("Fidel Yoldaş", "Alkan", "05423616962","fidely.alkan@gmail.com"));
//    }

}
