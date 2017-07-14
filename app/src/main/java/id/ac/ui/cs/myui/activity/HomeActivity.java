package id.ac.ui.cs.myui.activity;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import id.ac.ui.cs.myui.R;
import id.ac.ui.cs.myui.fragment.IdentitasFragment;
import id.ac.ui.cs.myui.fragment.JadwalFragment;
import id.ac.ui.cs.myui.fragment.MainFragment;

public class HomeActivity extends AppCompatActivity {

    @Override
    public void onBackPressed()
    {
        // code here to show dialog
        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
        startActivity(intent);
        super.onBackPressed();  // optional depending on your needs
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id==android.R.id.home) {
            Intent myIntent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivityForResult(myIntent, 0);

        }
        return  true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        final MainFragment mainFragment = new MainFragment();

        //By default, use MainFragment
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, mainFragment).commit();

        Bundle bundle = new Bundle();
        bundle.putString("edttext", getIntent().getStringExtra("nama"));
        mainFragment.setArguments(bundle);

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
                }else if(tabId == R.id.tab_identitas) {
                    //Use JadwalFragment
                    IdentitasFragment identitasFragment = new IdentitasFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("edttext2", getIntent().getStringExtra("nama"));
                    identitasFragment.setArguments(bundle2);
                    transaction.replace(R.id.fragment_container, identitasFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                    setTitle("Identitas Diri");
                }
            }


        });
    }
}
