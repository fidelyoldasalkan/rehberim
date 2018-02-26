package tr.com.fid.rehberim.command;

import android.content.Intent;

import tr.com.fid.rehberim.activity.MainActivity;

/**
 * Created by fidel on 25.02.2018.
 */

public class SendMailCommand extends BaseCommand {

    public SendMailCommand(MainActivity activity) {
        super(activity);
    }

    @Override
    public void execute() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"recipient@example.com"});
//        i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
//        i.putExtra(Intent.EXTRA_TEXT   , "body of email");
        activity.startActivity(i);
    }
}
