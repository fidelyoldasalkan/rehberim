package tr.com.fid.rehberim.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by fidel on 24.02.2018.
 */

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(getLayoutId(), container, false);
        setFragmentView(fragmentView);
        return fragmentView;
    }

    protected abstract void setFragmentView(View fragmentView);

    protected abstract int getLayoutId();

    public abstract String getFragmentTag();

    public abstract String getSubTitle();
}
