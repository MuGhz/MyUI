package id.ac.ui.cs.myui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import id.ac.ui.cs.myui.R;
import id.ac.ui.cs.myui.activity.DetailActivity;
import id.ac.ui.cs.myui.activity.HomeActivity;
import id.ac.ui.cs.myui.activity.LoginActivity;

/**
 * Created by faisalagustp on 7/13/17.
 */

public class MainFragment extends Fragment {

    private TextView tvWel;
    private String username;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        username = getArguments().getString("name");
        tvWel = (TextView) v.findViewById(R.id.name);
        tvWel.setText("Hai, " + username);
        Log.d("BUNDLE retireval", username);

        return v;
    }

    @Override
    public void onStart(){
        super.onStart();
        //Event onClick to move to other Intent from fragment
        LinearLayout academicTrackerBtn = (LinearLayout) getView().findViewById(R.id.academic_tracker_btn);
        academicTrackerBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(getActivity(), DetailActivity.class);
                getActivity().startActivity(i);
            }
        });

    }
}
