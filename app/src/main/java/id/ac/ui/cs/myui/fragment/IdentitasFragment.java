package id.ac.ui.cs.myui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import id.ac.ui.cs.myui.R;
import id.ac.ui.cs.myui.activity.DetailActivity;

/**
 * Created by meitya.dianti on 14/07/17.
 */

public class IdentitasFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_identitas, container, false);

        Spinner spinner = (Spinner) v.findViewById(R.id.program_spinner);
        ArrayAdapter<CharSequence> adapter =  ArrayAdapter.createFromResource(this.getContext(),
                R.array.program_item, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);


        return v;
    }

}
