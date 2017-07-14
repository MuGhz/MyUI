package id.ac.ui.cs.myui.activity;

/**
 * Created by hafiyyansayyidfadhlillah on 7/12/17.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;

import id.ac.ui.cs.myui.R;

public class LoginActivity extends AppCompatActivity {
    EditText etUsername;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText) findViewById(R.id.username);

        setTitle("Halaman Login");

        //set action if login button clicked
        Button loginButton = (Button) findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new  Intent(LoginActivity.this, HomeActivity.class);
                username = etUsername.getText().toString();
                i.putExtra("username", username);
                finish();
                getApplicationContext().startActivity(i);
            }
        });
    }
}
