package tr.com.fid.rehberim.command;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;

import tr.com.fid.rehberim.activity.MainActivity;
import tr.com.fid.rehberim.repository.IntentRequestRepository;

/**
 * Created by fidel on 25.02.2018.
 */

public class SendCallCommand extends BaseCommand {
    public SendCallCommand(MainActivity activity) {
        super(activity);
    }

    @Override
    public void execute() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + "05423616962"));
//        intent.setData(Uri.parse("tel:" + MainRepository.activity.getPerson().getTelefonNo()));
        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CALL_PHONE}, IntentRequestRepository.REQUEST_PHONE_CALL);
            return;
        }
        activity.startActivity(intent);

    }
}
