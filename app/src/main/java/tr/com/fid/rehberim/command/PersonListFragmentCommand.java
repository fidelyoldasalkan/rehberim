package tr.com.fid.rehberim.command;

import tr.com.fid.rehberim.activity.MainActivity;
import tr.com.fid.rehberim.fragment.PersonListFragment;

/**
 * Created by fidel on 25.02.2018.
 */

public class PersonListFragmentCommand implements Command {
    MainActivity activity;

    public PersonListFragmentCommand(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void execute() {
        activity.showFragment(new PersonListFragment(), false);
    }
}
