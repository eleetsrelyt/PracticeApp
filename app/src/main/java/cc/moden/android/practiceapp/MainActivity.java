package cc.moden.android.practiceapp;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public static final String SHAREDPREF_SET = "da App Times";
    public static final String SHAREDPREF_ITEM_START_TIME = "StartTime";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        displayCurrentTime();
        displayLastStartTime();

        storeStartTimeToSharedPreferences();
    }

    private void displayCurrentTime() {
        Date currentTime = new Date();
        String text = "The current time is: " + currentTime.toString();

        TextView textView = (TextView) findViewById(R.id.txtCurrentTime);
        textView.setText(text);
    }

    private void displayLastStartTime() {
        String lastStartTime = getLastStartTimeFromSharedPreferences();
        String text = "The last time was: " + lastStartTime;

        TextView textView = (TextView) findViewById(R.id.txtLastTime);
        textView.setText(text);
    }

    private String getLastStartTimeFromSharedPreferences() {
        SharedPreferences prefs = getSharedPreferences(SHAREDPREF_SET, MODE_PRIVATE);
        String extractedText = prefs.getString(SHAREDPREF_ITEM_START_TIME, "no time recorded");
        return extractedText;
    }

    private void storeStartTimeToSharedPreferences() {
        String text = new Date().toString();

        SharedPreferences prefs = getSharedPreferences(SHAREDPREF_SET, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(SHAREDPREF_ITEM_START_TIME, text);
        editor.apply();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
