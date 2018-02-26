package tr.com.fid.rehberim.command;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.File;

import tr.com.fid.rehberim.fragment.BaseFragment;
import tr.com.fid.rehberim.repository.IntentRequestRepository;

/**
 * Created by fidel on 25.02.2018.
 */

public class LoadImageCommand extends BaseCommand {

    BaseFragment fragment;
    public LoadImageCommand(Activity activity, BaseFragment fragment) {
        super(activity);
        this.fragment = fragment;
    }

    @Override
    public void execute() {
//        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        File file = new File(Environment.getExternalStorageDirectory(), "deneme.jpg");
//        Uri uri = Uri.fromFile(file);
//        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
//        cameraIntent.putExtra("return-data", true);
//        activity.startActivityForResult(cameraIntent, 1122);

        Intent galeriIntent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        fragment.startActivityForResult(Intent.createChooser(galeriIntent, "Galeriden resim seç"), IntentRequestRepository.REQUEST_GALLERY);
    }
}
