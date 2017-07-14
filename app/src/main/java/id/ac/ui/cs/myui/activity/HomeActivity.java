package id.ac.ui.cs.myui.activity;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import id.ac.ui.cs.myui.R;
import id.ac.ui.cs.myui.fragment.IdentitasFragment;
import id.ac.ui.cs.myui.fragment.JadwalFragment;
import id.ac.ui.cs.myui.fragment.MainFragment;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final MainFragment mainFragment = new MainFragment();

        String username = getIntent().getStringExtra("username");
        Bundle bundle = new Bundle();
        bundle.putString("name", username);
        //By default, use MainFragment

        mainFragment.setArguments(bundle);
        Log.d("BUNDLE set", username);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, mainFragment).commit();

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);

        //what to do if bottom bar or tab is tapped
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_menu) {
                    //Use MainFragment
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, mainFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                    setTitle("MyUI");
                }else if(tabId == R.id.tab_jadwal) {
                    //Use JadwalFragment
                    JadwalFragment jadwalFragment = new JadwalFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, jadwalFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                    setTitle("Jadwal Kuliah");
                } else if(tabId == R.id.tab_identitas) {
                    //Use JadwalFragment
                    IdentitasFragment identitasFragment = new IdentitasFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, identitasFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                    setTitle("Identitas");
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        if (this.equals(HomeActivity.this)) {
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            finish();
        }
    }
}
