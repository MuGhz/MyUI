package id.ac.ui.cs.myui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import id.ac.ui.cs.myui.R;

/**
 * Created by ayu.annisa41 on 14/07/17.
 */

public class IdentitasFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String strtext = getArguments().getString("edttext2");
        View mainViewInflater = inflater.inflate(R.layout.fragment_identitas, container, false);
        TextView text = (TextView) mainViewInflater.findViewById(R.id.idname);
        text.setText(strtext);
        TextView text2 = (TextView) mainViewInflater.findViewById(R.id.idnpm);
        text2.setText("1406543706");
        TextView text3 = (TextView) mainViewInflater.findViewById(R.id.idjurusan);
        text3.setText("Ilmu Komputer");
        TextView text4 = (TextView) mainViewInflater.findViewById(R.id.idprogram);
        text4.setText("S1");
        return mainViewInflater;
    }

}
