package tr.com.fid.rehberim.fragment;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import de.hdodenhof.circleimageview.CircleImageView;
import tr.com.fid.rehberim.R;
import tr.com.fid.rehberim.activity.MainActivity;
import tr.com.fid.rehberim.command.GeneralOnClickListener;
import tr.com.fid.rehberim.command.PersonSaveFragmentCommand;
import tr.com.fid.rehberim.command.SendCallCommand;
import tr.com.fid.rehberim.command.SendMailCommand;
import tr.com.fid.rehberim.command.SendSmsCommand;
import tr.com.fid.rehberim.command.SendWhatsappMessageCommand;
import tr.com.fid.rehberim.repository.FragmentTagRepository;
import tr.com.fid.rehberim.view.CopyClipboardTextView;

/**
 * Created by fidel on 25.02.2018.
 */

public class PersonShowFragment extends BaseFragment {
    @Override
    protected void setFragmentView(View fragmentView) {
        MainActivity activity = (MainActivity) getActivity();
        CopyClipboardTextView nameTv = fragmentView.findViewById(R.id.text_view_person_name);
        CopyClipboardTextView phoneNumberTv = fragmentView.findViewById(R.id.text_view_person_number);
        CopyClipboardTextView mailTv = fragmentView.findViewById(R.id.text_view_person_mail);
        CircleImageView sendCallImageView = fragmentView.findViewById(R.id.image_view_send_call);
        CircleImageView sendSmsImageView = fragmentView.findViewById(R.id.image_view_send_sms);
        CircleImageView sendWpMessageImageView = fragmentView.findViewById(R.id.image_view_send_wp_message);
        CircleImageView sendMailImageView = fragmentView.findViewById(R.id.image_view_send_mail);

        nameTv.setText(activity.getPerson().getFullName());
        phoneNumberTv.setText(activity.getPerson().getTelefonNo());
        mailTv.setText(activity.getPerson().getMail());

        sendCallImageView.setOnClickListener(new GeneralOnClickListener(new SendCallCommand(activity)));
        sendSmsImageView.setOnClickListener(new GeneralOnClickListener(new SendSmsCommand(activity)));
        sendMailImageView.setOnClickListener(new GeneralOnClickListener(new SendMailCommand(activity)));
        sendWpMessageImageView.setOnClickListener(new GeneralOnClickListener(new SendWhatsappMessageCommand(activity)));
        setHasOptionsMenu(true);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_person_show;
    }

    @Override
    public String getFragmentTag() {
        return FragmentTagRepository.PERSON_SHOW_FRAGMENT;
    }

    @Override
    public String getSubTitle() {
        return "Ali";
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_show_person, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_edit:
                new PersonSaveFragmentCommand(getActivity()).execute();
                return true;
            case R.id.menu_delete:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
