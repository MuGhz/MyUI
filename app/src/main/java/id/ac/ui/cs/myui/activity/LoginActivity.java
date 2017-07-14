package id.ac.ui.cs.myui.activity;

/**
 * Created by hafiyyansayyidfadhlillah on 7/12/17.
 */

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import id.ac.ui.cs.myui.R;

public class LoginActivity extends AppCompatActivity {


    private TextInputLayout usernameWrapper;
    private TextInputLayout passwordWrapper;
    private EditText etUsername;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //set title bar
        setTitle("Halaman Login");

        etUsername = (EditText) findViewById(R.id.username);
        etPassword = (EditText) findViewById(R.id.password);
        final Button bLogin = (Button) findViewById(R.id.login);

        usernameWrapper = (TextInputLayout) findViewById(R.id.usernameTIL);
        passwordWrapper = (TextInputLayout) findViewById(R.id.passwordTIL);

        //set action if login button clicked
        Button loginButton = (Button) findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
//                Intent i = new  Intent(LoginActivity.this, HomeActivity.class);
//                startActivity(i);
                processLogin();
            }
        });
    }

    public void processLogin(){
        String strUsername = etUsername.getText().toString();
        String strPassword = etPassword.getText().toString();

        boolean isValid = checkLoginForm(strUsername,strPassword);
        if (isValid){
            doLogin(strUsername);
        }
    }

    public boolean checkLoginForm(String username, String password){
        hideKeyboard();
        boolean result = true;
        boolean boolUsername = true;
        boolean boolPassword = true;

        if (username.equalsIgnoreCase("")){
            usernameWrapper.setError("Wajib diisi");
            boolUsername = false;
        } else if (username.length() > 1 && username.length() < 5){
            usernameWrapper.setError("Minimal 5 karakter");
            boolPassword = false;
        } else {
            usernameWrapper.setErrorEnabled(false);
        }

        if (password.equalsIgnoreCase("")){
            passwordWrapper.setError("Wajib diisi");
            boolPassword = false;
        } else if (password.length() > 1 && password.length() < 5){
            passwordWrapper.setError("Minimal 5 karakter");
            boolPassword = false;
        } else {
            passwordWrapper.setErrorEnabled(false);
        }

        result = boolUsername && boolPassword;
        return result;

    }

    public void doLogin(String username){
        String toast_msg = "login berhasil";
        Toast.makeText(getApplicationContext(), toast_msg ,Toast.LENGTH_LONG).show();

        // create new intent
        Intent loginIntent = new Intent(LoginActivity.this, HomeActivity.class);

        // put parameters to be sent
        loginIntent.putExtra("username", username);

        // go to new intent / page / activity
        LoginActivity.this.startActivity(loginIntent);
    }

    private void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
