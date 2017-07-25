package id.ac.ui.cs.myui;

/**
 * Created by hafiyyansayyidfadhlillah on 7/25/17.
 */

public class AccessToken {

    private String access_token;
    private String refresh_token;
    private String token_type;

    public String getAccessToken() {
        return access_token;
    }

    public String getTokenType() {
        return token_type;
    }

    @Override
    public String toString(){
        return access_token;
    }
}
