package tr.com.fid.rehberim.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import de.hdodenhof.circleimageview.CircleImageView;
import tr.com.fid.rehberim.R;
import tr.com.fid.rehberim.activity.MainActivity;
import tr.com.fid.rehberim.command.GeneralOnClickListener;
import tr.com.fid.rehberim.command.LoadImageCommand;
import tr.com.fid.rehberim.command.PersonSaveCommand;
import tr.com.fid.rehberim.model.BaseModel;
import tr.com.fid.rehberim.repository.FragmentTagRepository;
import tr.com.fid.rehberim.repository.IntentRequestRepository;

import static android.support.v7.app.AppCompatActivity.RESULT_OK;
/**
 * Created by fidel on 25.02.2018.
 */

public class PersonSaveFragment extends BaseFragment {

    public CircleImageView profileImageView;
    public EditText nameEt;
    public EditText surnameEt;
    public EditText nickNameEt;
    public EditText phoneNumberEt;
    public EditText mailEt;
    public EditText facebookEt;
    public EditText instagramEt;
    public EditText youtubeEt;
    public EditText twitterEt;
    public Spinner ilSp;
    public Spinner ilceSp;
    public CheckBox nickNameCheckBox;

    @Override
    protected void setFragmentView(View fragmentView) {
        nameEt = fragmentView.findViewById(R.id.edit_text_name);
        surnameEt = fragmentView.findViewById(R.id.edit_text_surname);
        nickNameEt = fragmentView.findViewById(R.id.edit_text_nick_name);
        phoneNumberEt = fragmentView.findViewById(R.id.edit_text_number);
        mailEt = fragmentView.findViewById(R.id.edit_text_mail);
        nickNameCheckBox = fragmentView.findViewById(R.id.checkbox_show_nick_name);
        profileImageView = fragmentView.findViewById(R.id.image_view_person_profile);
        profileImageView.setOnClickListener(new GeneralOnClickListener(new LoadImageCommand(getActivity(),this)));
        MainActivity activity = (MainActivity) getActivity();
        if (activity.getPerson().isRecored()) {
            nameEt.setText(activity.getPerson().getAdi());
            surnameEt.setText(activity.getPerson().getSoyadi());
            nickNameEt.setText(activity.getPerson().getGoruntulenecekIsim());
            phoneNumberEt.setText(activity.getPerson().getTelefonNo());
            mailEt.setText(activity.getPerson().getMail());
            nickNameCheckBox.setChecked(BaseModel.INT_TRUE == activity.getPerson().getGercekIsimMiGosterilecek());
        }

        setHasOptionsMenu(true);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_person_save;
    }

    @Override
    public String getFragmentTag() {
        return FragmentTagRepository.PERSON_SAVE_FRAGMENT;
    }

    @Override
    public String getSubTitle() {
        return "kaydet";
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_save_person, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_save:
                new PersonSaveCommand(this, getActivity()).execute();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {
            if (requestCode == IntentRequestRepository.REQUEST_GALLERY){
                if (data != null) {
                    Uri uri = data.getData();
                    cropImage(uri);
                }
            }
            else if (requestCode == IntentRequestRepository.REQUEST_CROP_IMAGE) {
                if (data != null) {
                    Bundle bundle = data.getExtras();
                    assert bundle != null;
                    Bitmap bitmap = bundle.getParcelable("data");
                    profileImageView.setImageBitmap(bitmap);

                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void cropImage(Uri uri) {
        Intent cropIntent = new Intent("com.android.camera.action.CROP");
        cropIntent.setDataAndType(uri, "image/*");
        cropIntent.putExtra("crop", "true");
        cropIntent.putExtra("outputX", 180);
        cropIntent.putExtra("outputY", 180);
        cropIntent.putExtra("aspectX", 3);
        cropIntent.putExtra("aspectY", 4);
        cropIntent.putExtra("scaleUpIfNeeded",true);
        cropIntent.putExtra("return-data",true);
        startActivity(cropIntent);
    }
}
