package tr.com.fid.rehberim.command;

import android.support.v7.widget.RecyclerView;

import tr.com.fid.rehberim.activity.MainActivity;
import tr.com.fid.rehberim.fragment.PersonShowFragment;
import tr.com.fid.rehberim.holder.BaseHolder;
import tr.com.fid.rehberim.holder.PersonHolder;
import tr.com.fid.rehberim.model.Person;

/**
 * Created by fidel on 25.02.2018.
 */

public class PersonShowFragmentCommand extends BaseCommand {

    private BaseHolder personHolder;
    public PersonShowFragmentCommand(MainActivity activity, BaseHolder personHolder) {
        super(activity);
        this.personHolder = personHolder;
    }

    @Override
    public void execute() {
        activity.setPerson(personHolder.getPerson());
        activity.showFragment(new PersonShowFragment(), true);
        activity.closeBottomNavigationView();
    }
}
