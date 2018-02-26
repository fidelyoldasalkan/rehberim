package tr.com.fid.rehberim.adapter;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.CallLog;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Vector;

import tr.com.fid.rehberim.R;
import tr.com.fid.rehberim.activity.MainActivity;
import tr.com.fid.rehberim.holder.CallHolder;
import tr.com.fid.rehberim.model.CallHistory;

/**
 * Created by fidel on 25.02.2018.
 */

public class CallHistoryAdapter extends RecyclerView.Adapter<CallHolder> {

    Vector<CallHistory> callHistories;
    MainActivity activity;

    public CallHistoryAdapter(MainActivity activity) {
        this.activity = activity;
        callHistories = new Vector<>();
        setCallHistories();
    }

    @Override
    public CallHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(activity).inflate(R.layout.row_call_history, parent, false);
        return new CallHolder(rowView, activity);
    }

    @Override
    public void onBindViewHolder(CallHolder holder, int position) {
        CallHistory callHistory = callHistories.elementAt(position);
        holder.phoneNumberTv.setText(callHistory.getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return callHistories.size();
    }

    private void setCallHistories() {
        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Cursor cursor = activity.getContentResolver().query(CallLog.Calls.CONTENT_URI, null, null, null, CallLog.Calls.DATE + " DESC");
        assert cursor != null;
        if (cursor.moveToFirst()){
            do {
                Log.e("adasd","asddf");
                callHistories.add(new CallHistory(cursor));
            } while (cursor.moveToNext());
        }
    }
}
