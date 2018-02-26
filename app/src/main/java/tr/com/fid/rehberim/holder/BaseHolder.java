package tr.com.fid.rehberim.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import tr.com.fid.rehberim.model.Person;

/**
 * Created by fidel on 25.02.2018.
 */

public abstract class BaseHolder extends RecyclerView.ViewHolder {

    private Person person;

    public BaseHolder(View itemView) {
        super(itemView);
    }

    final public Person getPerson() {
        return person;
    }

    final public void setPerson(Person person) {
        this.person = person;
    }
}
