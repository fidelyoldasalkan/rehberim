package tr.com.fid.rehberim.view;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by fidel on 24.02.2018.
 */

public class CopyClipboardTextView extends android.support.v7.widget.AppCompatTextView implements View.OnLongClickListener {

    public CopyClipboardTextView(Context context) {
        super(context);
        init();
    }

    public CopyClipboardTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CopyClipboardTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    public boolean onLongClick(View view) {
        ClipboardManager clipboard = (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Telefon no", getText());
        clipboard.setPrimaryClip(clip);
        return false;
    }

    private void init() {
        setOnLongClickListener(this);
    }
}
