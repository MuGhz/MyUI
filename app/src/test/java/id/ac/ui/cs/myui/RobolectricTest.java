package id.ac.ui.cs.myui;

import android.widget.Button;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import id.ac.ui.cs.myui.activity.LoginActivity;

/**
 * Created by DELL on 7/24/2017.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class RobolectricTest {
    @Test
    public void clickingButton_shouldChangeResultsViewText() throws Exception {
        LoginActivity activity = Robolectric.setupActivity(LoginActivity.class);

        Button button = (Button) activity.findViewById(R.id.login);

        button.performClick();
        assertEquals(button.getText().toString(),"Login QR");
    }
}
