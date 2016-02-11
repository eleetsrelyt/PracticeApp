package cc.moden.android.practiceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        //super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        String message = "Title: " + item.getTitle()
                + ", id=" + item.getItemId();
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

        switch(item.getItemId()) {
            case R.id.menu_help:
                startActivities(new Intent(this, helpScreen.class));
                break;

            case R.id.menu_settings:

        }
        return true;
    }
}
