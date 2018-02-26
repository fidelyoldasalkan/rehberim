package tr.com.fid.rehberim.command;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.widget.Toast;

import tr.com.fid.rehberim.R;
import tr.com.fid.rehberim.activity.MainActivity;

/**
 * Created by fidel on 25.02.2018.
 */

public class GeneralOnNavigationItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener {

    MainActivity activity;

    public GeneralOnNavigationItemSelectedListener(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_call_history:
                new CallHistoryFragmentCommand(activity).execute();
                return true;
            case R.id.menu_my_contacts:
                new PersonListFragmentCommand(activity).execute();
                return true;
            case R.id.menu_group:
                Toast.makeText(activity, "Bir sonraki güncellememizde aktif olacaktır", Toast.LENGTH_LONG).show();
                return true;
            default:
                return false;
        }
    }
}
