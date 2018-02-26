package tr.com.fid.rehberim.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Vector;

import tr.com.fid.rehberim.R;
import tr.com.fid.rehberim.activity.MainActivity;
import tr.com.fid.rehberim.holder.PersonHolder;
import tr.com.fid.rehberim.model.Person;

/**
 * Created by fidel on 24.02.2018.
 */

public class PersonListAdapter extends RecyclerView.Adapter<PersonHolder> {

    private Vector<Person> personVector;
    private MainActivity activity;
    public PersonListAdapter(Vector<Person> personVector, MainActivity activity) {
        this.personVector = personVector;
        this.activity = activity;
    }

    @Override
    public PersonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(activity).inflate(R.layout.row_person_list, parent,false);

        return new PersonHolder(rowView, activity);
    }

    @Override
    public void onBindViewHolder(PersonHolder holder, int position) {
        Person person = personVector.elementAt(position);
        holder.fullNameTv.setText(person.getFullName());
        holder.phoneNumberTv.setText(person.getTelefonNo());
        holder.mailTv.setText(person.getMail());
        holder.setPerson(person);
    }

    @Override
    public int getItemCount() {
        return personVector.size();
    }
}
