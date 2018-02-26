package tr.com.fid.rehberim.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import tr.com.fid.rehberim.R;
import tr.com.fid.rehberim.activity.MainActivity;
import tr.com.fid.rehberim.command.GeneralOnClickListener;
import tr.com.fid.rehberim.command.PersonShowFragmentCommand;
import tr.com.fid.rehberim.command.SendCallCommand;
import tr.com.fid.rehberim.command.SendMailCommand;
import tr.com.fid.rehberim.command.SendSmsCommand;
import tr.com.fid.rehberim.command.SendWhatsappMessageCommand;
import tr.com.fid.rehberim.model.Person;

/**
 * Created by fidel on 24.02.2018.
 */

public class PersonHolder extends BaseHolder {

    public TextView fullNameTv;
    public TextView phoneNumberTv;
    public TextView mailTv;
    public CircleImageView profileImageView;
    public CircleImageView sendMailImageView;
    public CircleImageView sendCallImageView;
    public CircleImageView sendSmsImageView;
    public CircleImageView sendWpMessageImageView;

    public PersonHolder(View itemView, MainActivity activity) {
        super(itemView);
        fullNameTv = itemView.findViewById(R.id.text_view_person_name);
        phoneNumberTv = itemView.findViewById(R.id.text_view_person_number);
        mailTv = itemView.findViewById(R.id.text_view_person_mail);
        profileImageView = itemView.findViewById(R.id.image_view_person_profile);
        sendMailImageView = itemView.findViewById(R.id.image_view_send_mail);
        sendCallImageView = itemView.findViewById(R.id.image_view_send_call);
        sendSmsImageView = itemView.findViewById(R.id.image_view_send_sms);
        sendWpMessageImageView = itemView.findViewById(R.id.image_view_send_wp_message);
        sendCallImageView.setOnClickListener(new GeneralOnClickListener(new SendCallCommand(activity)));
        sendSmsImageView.setOnClickListener(new GeneralOnClickListener(new SendSmsCommand(activity)));
        sendMailImageView.setOnClickListener(new GeneralOnClickListener(new SendMailCommand(activity)));
        sendWpMessageImageView.setOnClickListener(new GeneralOnClickListener(new SendWhatsappMessageCommand(activity)));
        itemView.setOnClickListener(new GeneralOnClickListener(new PersonShowFragmentCommand(activity, this)));
    }

}
