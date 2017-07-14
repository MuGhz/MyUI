package id.ac.ui.cs.myui.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import id.ac.ui.cs.myui.R;

/**
 * Created by itf on 14/07/17.
 */

public class IdentitasFragment extends Fragment {

    TextView tvNama;
    TextView tvNPM;
    TextView tvJurusan;
    TextView tvProgram;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_identitas, container, false);

        tvNama = (TextView) view.findViewById(R.id.nama);
        tvNPM = (TextView) view.findViewById(R.id.npm);
        tvJurusan = (TextView) view.findViewById(R.id.jurusan);
//        tvProgram = (TextView) view.findViewById(R.id.program);

        Spinner spinner = (Spinner) view.findViewById(R.id.spinner_program);

        tvNama.setText("guhkunganteng");
        tvNPM.setText("1106003522");
        tvJurusan.setText("Ilmu Komputer");
//        tvProgram.setText("S1 Reguler");

        return view;

    }
}
