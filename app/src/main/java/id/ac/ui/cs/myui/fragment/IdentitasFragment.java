package id.ac.ui.cs.myui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import id.ac.ui.cs.myui.R;

/**
 * Created by ekanaradhipa.d on 14/07/17.
 */

public class IdentitasFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_identity, container, false);
    }
    @Override
    public void onStart(){
        super.onStart();
        String strtext = getActivity().getIntent().getStringExtra("nama");
        TextView tv = (TextView) getView().findViewById(R.id.namaIdentitas);
        tv.append(strtext);

    }
}
