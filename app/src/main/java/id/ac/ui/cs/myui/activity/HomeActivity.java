package id.ac.ui.cs.myui.activity;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import id.ac.ui.cs.myui.R;
import id.ac.ui.cs.myui.fragment.JadwalFragment;
import id.ac.ui.cs.myui.fragment.MainFragment;
import id.ac.ui.cs.myui.fragment.ProfileFragment;

public class HomeActivity extends AppCompatActivity {
    String username;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final MainFragment mainFragment = new MainFragment();
        //By default, use MainFragment
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, mainFragment).commit();
        username = getIntent().getStringExtra("username");
        bundle = new Bundle();
        bundle.putString("username", username);
        mainFragment.setArguments(bundle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
                    //Use ProfileFragment
                    ProfileFragment profileFragment = new ProfileFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, profileFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                    profileFragment.setArguments(bundle);
                    setTitle("Profile");
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i = new  Intent(HomeActivity.this, LoginActivity.class);
        finish();
        getApplicationContext().startActivity(i);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
