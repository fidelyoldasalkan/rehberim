package tr.com.fid.rehberim.model;

import android.database.Cursor;
import android.provider.CallLog;

/**
 * Created by fidel on 25.02.2018.
 */

public class CallHistory {

    private String phoneNumber;
    private String callDate;
    private String duration;
    private int callType;

    public CallHistory(Cursor cursor) {
        int number = cursor.getColumnIndex(CallLog.Calls.NUMBER);
        int type = cursor.getColumnIndex(CallLog.Calls.TYPE);
        int date = cursor.getColumnIndex(CallLog.Calls.DATE);
        int duration = cursor.getColumnIndex(CallLog.Calls.DURATION);
        setPhoneNumber(cursor.getString(number));
        setCallDate(cursor.getString(date));
        setCallType(cursor.getInt(type));
        setDuration(cursor.getString(duration));
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCallDate() {
        return callDate;
    }

    public void setCallDate(String callDate) {
        this.callDate = callDate;
    }

    public int getCallType() {
        return callType;
    }

    public void setCallType(int callType) {
        this.callType = callType;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
