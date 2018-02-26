package tr.com.fid.rehberim.command;

import tr.com.fid.rehberim.activity.MainActivity;

/**
 * Created by fidel on 25.02.2018.
 */

public class PersonListCommand implements Command {

    MainActivity activity;

    public PersonListCommand(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void execute() {
        activity.setPersonVector(activity.getPerson().list());
    }

}
