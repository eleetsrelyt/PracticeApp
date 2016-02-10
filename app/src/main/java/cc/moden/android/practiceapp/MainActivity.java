package cc.moden.android.practiceapp;

import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureImageButton();

    }

    private void configureImageButton() {
        ImageButton btn = (ImageButton) findViewById(R.id.imageButton);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You clicked the button", Toast.LENGTH_LONG).show();

                // Change image on button.
                ImageButton btn = (ImageButton) findViewById(R.id.imageButton);
                btn.setImageResource(R.drawable.x_avatar);
            }
        });
    }

}
