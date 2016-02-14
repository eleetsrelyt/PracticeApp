package cc.moden.android.practiceapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class mathActivity extends AppCompatActivity {

    private int valueToWorkWith;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        Intent intent = getIntent();
        valueToWorkWith = intent.getIntExtra(MainActivity.EXTRA_USER_NUMBER, 0);

        TextView displayNumber = (TextView) findViewById(R.id.textViewUserNumber);
        displayNumber.setText("" + valueToWorkWith);

        setupDoubleButton();
        setupCancelButton();
    }

    private void setupDoubleButton() {
        Button btn = (Button) findViewById(R.id.btnDoubleIt);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int answer = valueToWorkWith * 2;

                Intent intent = new Intent();
                intent.putExtra(MainActivity.EXTRA_ANSWER, answer);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }

    private void setupCancelButton() {
        Button btn = (Button) findViewById(R.id.btnCancel);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(Activity.RESULT_CANCELED, intent);
                finish();
            }
        });
    }


}
