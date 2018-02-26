package tr.com.fid.rehberim.command;

import android.app.Activity;

import tr.com.fid.rehberim.activity.MainActivity;
import tr.com.fid.rehberim.fragment.PersonSaveFragment;

/**
 * Created by fidel on 25.02.2018.
 */

public class PersonSaveFragmentCommand extends BaseCommand{

    public PersonSaveFragmentCommand(Activity activity) {
        super(activity);
    }

    @Override
    public void execute() {
        activity.getPerson().setRecored(false);
        activity.showFragment(new PersonSaveFragment(), true);
        activity.closeBottomNavigationView();
    }
}
