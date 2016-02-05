package cc.moden.android.practiceapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "DemoButtonApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupMessageButton();
    }

    private void setupMessageButton() {
        Button messageButton = (Button) findViewById(R.id.btnDisplayMessage);
        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You Clicked it!", Toast.LENGTH_LONG).show();

                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }
}
