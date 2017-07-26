package id.ac.ui.cs.myui.activity;

/**
 * Created by hafiyyansayyidfadhlillah on 7/12/17.
 */

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import java.io.IOException;

import id.ac.ui.cs.myui.AccessToken;
import id.ac.ui.cs.myui.LoginService;
import id.ac.ui.cs.myui.R;
import id.ac.ui.cs.myui.ServiceGenerator;
import retrofit2.Call;
import retrofit2.http.Field;

public class LoginActivity extends AppCompatActivity {

    private final String clientId = "2bfJDNTlHhR9TJO6kQ5OsINqeMpNqFrudWOC8Vg9";
    private final String redirectUri = "akuncs://localhost/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //set title bar
        setTitle("Halaman Login");

        //set action if login button clicked
        Button loginButton = (Button) findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(ServiceGenerator.API_BASE_URL + "" + "oauth/authorize/?response_type=code&client_id=" + clientId + "&state=random_state_string"));
                startActivity(intent);
            }
        });
    }

    protected void onResume(){
        super.onResume();
        Log.i("MASUK","Masuk");
        // the intent filter defined in AndroidManifest will handle the return from ACTION_VIEW intent
        Uri uri = getIntent().getData();
        if (uri != null && uri.toString().startsWith(redirectUri)) {
            Log.i("URI",uri.toString());
            // use the parameter your API exposes for the code (mostly it's "code")
            String code = uri.getQueryParameter("code");
            Log.i("CODE",code);
            if (code != null) {
                // get access token
                try{
                    ServiceGenerator serviceGenerator = new ServiceGenerator(getApplicationContext(),code);
                    serviceGenerator.execute();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            } else if (uri.getQueryParameter("error") != null) {
                // show an error message here
            }
        }
    }
}
