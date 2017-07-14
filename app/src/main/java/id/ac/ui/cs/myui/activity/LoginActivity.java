package id.ac.ui.cs.myui.activity;

/**
 * Created by hafiyyansayyidfadhlillah on 7/12/17.
 */

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

import id.ac.ui.cs.myui.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText username = (EditText) findViewById(R.id.username);

        final Intent i = new  Intent(LoginActivity.this, HomeActivity.class);
        //set title bar
        setTitle("Halaman Login");

        //set action if login button clicked
        Button loginButton = (Button) findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                i.putExtra("user", username.getText().toString());


                Log.d("test", username.getText().toString());


                i.setFlags(i.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });
    }
}
