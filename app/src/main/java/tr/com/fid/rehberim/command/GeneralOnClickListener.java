package tr.com.fid.rehberim.command;

import android.view.View;

/**
 * Created by fidel on 24.02.2018.
 */

public class GeneralOnClickListener implements View.OnClickListener {

    private Command command;

    public GeneralOnClickListener(Command command) {
        this.command = command;
    }

    @Override
    public void onClick(View view) {
        command.execute();
    }
}
