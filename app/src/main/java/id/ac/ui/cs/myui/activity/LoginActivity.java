package id.ac.ui.cs.myui.activity;

/**
 * Created by hafiyyansayyidfadhlillah on 7/12/17.
 */

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;

import id.ac.ui.cs.myui.R;

import static id.ac.ui.cs.myui.R.id.username;

public class LoginActivity extends AppCompatActivity {
    EditText etUsername;
    String username;

    private EditText etUname;
    private EditText etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText) findViewById(R.id.username);

        //set title bar
        setTitle("Halaman Login");
        final Intent intent = new Intent(this, HomeActivity.class);

        final Context context = getApplicationContext();
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

    private void login(Intent intent, Context context, String username)
    {
        Toast.makeText(this, "Logging in as " + username, Toast.LENGTH_LONG).show();
        Intent i = new  Intent(LoginActivity.this, HomeActivity.class);
        i.putExtra("username", username);
        startActivity(i);
    }

    private boolean checkValidation()
    {
        boolean ret = true;
        Validation val = new Validation();
        if (!val.hasText(etUname)) ret = false;
        if (!val.hasText(etPass)) ret = false;

        return ret;
    }

    class Validation {

        // Error Messages
        private static final String REQUIRED_MSG = "required";


        // check the input field has any text or not
        // return true if it contains text otherwise false
        public boolean hasText(EditText editText) {

            String text = editText.getText().toString().trim();
            editText.setError(null);

            // length 0 means there is no text
            if (text.length() == 0) {
                editText.setError(REQUIRED_MSG);
                return false;
            }

            return true;
        }
    }
}
