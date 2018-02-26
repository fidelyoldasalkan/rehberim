package tr.com.fid.rehberim.command;

import android.content.Intent;
import android.net.Uri;

import tr.com.fid.rehberim.activity.MainActivity;

/**
 * Created by fidel on 25.02.2018.
 */

public class SendSmsCommand extends BaseCommand {
    public SendSmsCommand(MainActivity activity) {
        super(activity);
    }

    @Override
    public void execute() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + "05423616962"));
//        intent.putExtra("sms_body", "gdfsddadsada");
        activity.startActivity(intent);
    }
}
