package tr.com.fid.rehberim.command;

import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;

import tr.com.fid.rehberim.activity.MainActivity;
import tr.com.fid.rehberim.fragment.PersonSaveFragment;
import tr.com.fid.rehberim.model.BaseModel;

/**
 * Created by fidel on 25.02.2018.
 */

public class PersonSaveCommand implements Command {

    PersonSaveFragment fragment;
    MainActivity activity;

    public PersonSaveCommand(PersonSaveFragment fragment, Activity activity) {
        this.fragment = fragment;
        this.activity = (MainActivity) activity;
    }

    @Override
    public void execute() {
        activity.getPerson().setAdi(fragment.nameEt.getText().toString());
        activity.getPerson().setSoyadi(fragment.surnameEt.getText().toString());
        activity.getPerson().setGoruntulenecekIsim(fragment.nickNameEt.getText().toString());
        activity.getPerson().setTelefonNo(fragment.phoneNumberEt.getText().toString());
        activity.getPerson().setMail(fragment.mailEt.getText().toString());
        activity.getPerson().setGercekIsimMiGosterilecek(
                (fragment.nickNameCheckBox.isChecked()) ? BaseModel.INT_TRUE : BaseModel.INT_FALSE
        );
        if (activity.getPerson().isRecored())
            activity.getPerson().update();
        else
            activity.getPerson().insert();

        closeKeyboard();
        activity.onBackPressed();
    }

    private void closeKeyboard(){
        InputMethodManager inputManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        assert inputManager != null;
        inputManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }


}
