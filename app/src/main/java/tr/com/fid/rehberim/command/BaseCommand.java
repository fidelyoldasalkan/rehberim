package tr.com.fid.rehberim.command;

import android.app.Activity;

import tr.com.fid.rehberim.activity.MainActivity;

/**
 * Created by fidel on 25.02.2018.
 */

abstract class BaseCommand implements Command {

    MainActivity activity;

    BaseCommand(Activity activity) {
        this.activity = (MainActivity) activity;
    }
}
