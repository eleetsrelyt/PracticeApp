package cc.moden.android.practiceapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupNavigationButton();

    }
    private void setupNavigationButton() {
        Button button = (Button) findViewById(R.id.btnOnSecond);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this, "Clicked Again!", Toast.LENGTH_LONG).show();

                //startActivity(new Intent(SecondActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}
