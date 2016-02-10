package cc.moden.android.practiceapp;

import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private PetRock rocky = new PetRock();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setupHappyButton();
        //setupSadButton();
        setupEmotionButton(R.id.btnHappy, PetRock.Emotion.HAPPY);
        setupEmotionButton(R.id.btnSad, PetRock.Emotion.SAD);
        updateUI();
    }

    private void setupEmotionButton(int buttonId, final PetRock.Emotion newEmotion) {
        Button button = (Button) findViewById(buttonId);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                rocky.setCurrentEmotion(newEmotion);
                updateUI();
            }
        });
    }

    private void updateUI() {
        TextView textView = (TextView) findViewById(R.id.txtRockyFeeling);
        String feeling = rocky.toString();

        textView.setText(feeling);
    }
}
