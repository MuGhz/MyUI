package id.ac.ui.cs.myui.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import id.ac.ui.cs.myui.R;

/**
 * Created by galih.priyambodho on 14/07/17.
 */

public class IdentitasFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_identitas, container, false);

        TextView textNama = (TextView) view.findViewById(R.id.nama);
        textNama.setText(textNama.getText() + "Galih Priambodo");

        TextView textNpm = (TextView) view.findViewById(R.id.npm);
        textNpm.setText(textNpm.getText() + "1506689603");

        TextView textJurusan = (TextView) view.findViewById(R.id.jurusan);
        textJurusan.setText(textJurusan.getText() + "Sistem Informasi");

        TextView textProgram = (TextView) view.findViewById(R.id.program);
        textProgram.setText(textProgram.getText() + "S1 Reguler");

        return view;
        //return inflater.inflate(R.layout.fragment_identitas, container, false);
    }
}
