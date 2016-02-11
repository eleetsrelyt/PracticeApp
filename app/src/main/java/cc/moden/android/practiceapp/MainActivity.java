package cc.moden.android.practiceapp;

import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int currentDieNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupNextImageButton();
    }

    private void setupNextImageButton() {
        Button btn = (Button) findViewById(R.id.btnNextImage);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Move to next image
                currentDieNumber++;
                if (currentDieNumber > 5) {
                    currentDieNumber = 1;
                }

                // come up with the name of the file we want
                String fileName = "image_" + currentDieNumber;

                // translate file name to resource id
                int id = getResources().getIdentifier(fileName, "drawable", MainActivity.this.getPackageName());

                // change image based on id
                ImageView imageView = (ImageView) findViewById(R.id.avatarImage);
                imageView.setImageResource(id);
            }
        });
    }


}
