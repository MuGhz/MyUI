package id.ac.ui.cs.myui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import id.ac.ui.cs.myui.R;
import id.ac.ui.cs.myui.activity.DetailActivity;

/**
 * Created by agni.wira on 14/07/17.
 */

public class IdentitasFragment  extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_identitas, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        TextView tvUsername = (TextView) getView().findViewById(R.id.username_identitas);
        tvUsername.setText(getActivity().getIntent().getStringExtra("username"));

    }




}
