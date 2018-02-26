package tr.com.fid.rehberim.activity;

import android.app.FragmentTransaction;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Vector;

import tr.com.fid.rehberim.R;
import tr.com.fid.rehberim.command.CallHistoryFragmentCommand;
import tr.com.fid.rehberim.command.GeneralOnNavigationItemSelectedListener;
import tr.com.fid.rehberim.fragment.BaseFragment;
import tr.com.fid.rehberim.fragment.PersonListFragment;
import tr.com.fid.rehberim.model.Person;
import tr.com.fid.rehberim.repository.FragmentTagRepository;

public class MainActivity extends AppCompatActivity {

    private String currentFragmentTag;
    private Person person;
    private Vector<Person> personVector;
    private BottomNavigationView bottomNavigationItemView;

    public void showFragment(BaseFragment fragment, boolean addToStack) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.main_layout, fragment);
        if (addToStack)
            transaction.addToBackStack(null);
        getSupportActionBar().setSubtitle(fragment.getSubTitle());
        setCurrentFragmentTag(fragment.getFragmentTag());
        transaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        person = new Person(getApplicationContext());
        setContentView(R.layout.activity_main);
        showFragment(new PersonListFragment(), false);
        bottomNavigationItemView = findViewById(R.id.bottom_navigation);
        bottomNavigationItemView.setOnNavigationItemSelectedListener(new GeneralOnNavigationItemSelectedListener(this));
        bottomNavigationItemView.setSelectedItemId(R.id.menu_my_contacts);
    }

    public String getCurrentFragmentTag() {
        return currentFragmentTag;
    }

    private void setCurrentFragmentTag(String currentFragmentTag) {
        this.currentFragmentTag = currentFragmentTag;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void closeBottomNavigationView(){
        bottomNavigationItemView.setVisibility(View.INVISIBLE);
    }

    public void openBottomNavigationView(){
        bottomNavigationItemView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBackPressed() {
        if (currentFragmentTag.equals(FragmentTagRepository.PERSON_SAVE_FRAGMENT) || currentFragmentTag.equals(FragmentTagRepository.PERSON_SHOW_FRAGMENT))
            openBottomNavigationView();
        super.onBackPressed();
    }

    public Vector<Person> getPersonVector() {
        return personVector;
    }

    public void setPersonVector(Vector<Person> personVector) {
        this.personVector = personVector;
    }
}
