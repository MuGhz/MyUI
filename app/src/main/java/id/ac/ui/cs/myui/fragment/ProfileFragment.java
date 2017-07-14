package id.ac.ui.cs.myui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import id.ac.ui.cs.myui.R;
import id.ac.ui.cs.myui.activity.DetailActivity;
/**
 * Created by irma.latifatul on 14/07/17.
 */

public class ProfileFragment extends Fragment{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inf = inflater.inflate(R.layout.fragment_profile, container, false);
        String username = getArguments().getString("username");
        TextView tv = (TextView) inf.findViewById(R.id.nama);
        tv.setText(username);
        return inf;
    }
}
