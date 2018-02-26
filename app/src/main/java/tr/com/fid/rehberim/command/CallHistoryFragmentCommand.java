package tr.com.fid.rehberim.command;

import tr.com.fid.rehberim.activity.MainActivity;
import tr.com.fid.rehberim.fragment.CallHistoryFragment;

/**
 * Created by fidel on 25.02.2018.
 */

public class CallHistoryFragmentCommand implements Command {
    MainActivity activity;

    public CallHistoryFragmentCommand(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void execute() {
        activity.showFragment(new CallHistoryFragment(), false);
    }
}
