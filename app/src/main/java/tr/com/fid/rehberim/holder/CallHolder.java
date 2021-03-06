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

/**
 * Created by fidel on 25.02.2018.
 */

public class CallHolder extends BaseHolder {
    public TextView fullNameTv;
    public TextView phoneNumberTv;
    public TextView callDateTv;
    public CircleImageView profileImageView;
    public CircleImageView sendMailImageView;
    public CircleImageView sendCallImageView;
    public CircleImageView sendSmsImageView;
    public CircleImageView sendWpMessageImageView;

    public CallHolder(View itemView, MainActivity activity) {
        super(itemView);
        fullNameTv = itemView.findViewById(R.id.text_view_caller_name);
        phoneNumberTv = itemView.findViewById(R.id.text_view_caller_number);
        callDateTv = itemView.findViewById(R.id.text_view_caller_date);
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
