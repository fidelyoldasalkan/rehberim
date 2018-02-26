package tr.com.fid.rehberim.command;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.telephony.PhoneNumberUtils;
import android.widget.Toast;

import tr.com.fid.rehberim.R;
import tr.com.fid.rehberim.activity.MainActivity;

/**
 * Created by fidel on 25.02.2018.
 */

public class SendWhatsappMessageCommand extends BaseCommand {

    public SendWhatsappMessageCommand(MainActivity activity) {
        super(activity);
    }

    @Override
    public void execute() {

        Intent waIntent = new Intent("android.intent.action.MAIN");

//            String text = "YOUR TEXT HERE";
        waIntent.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
        waIntent.putExtra("jid", PhoneNumberUtils.stripSeparators("05332675350") + "@s.whatsapp.net");
        waIntent.setPackage("com.whatsapp");
        waIntent.setType("text/plain");

//            waIntent.putExtra(Intent.EXTRA_TEXT, text);
        activity.startActivity(Intent.createChooser(waIntent, "Share with"));

    }
}
