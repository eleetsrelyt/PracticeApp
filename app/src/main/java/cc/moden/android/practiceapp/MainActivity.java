package cc.moden.android.practiceapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_USER_NUMBER = "user number";
    public static final String EXTRA_ANSWER = "the answer";
    public static final int RESULT_CODE_DO_MATH = 42;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupDoMathButton();


    }

    private void setupDoMathButton() {


        Button btn = (Button) findViewById(R.id.btnDoMath);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText userTextEntry = (EditText) findViewById(R.id.editTextUserNumber);
                String userData = userTextEntry.getText().toString();
                int userNumber = Integer.parseInt(userData);

                Intent intent = new Intent(MainActivity.this, mathActivity.class);
                intent.putExtra(EXTRA_USER_NUMBER, userNumber);
                startActivityForResult(intent, RESULT_CODE_DO_MATH);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_CANCELED) {
            TextView answerView = (TextView) findViewById(R.id.textViewAnswer);
            answerView.setText("User canceled");
            return;
        }

        switch (requestCode) {
            case RESULT_CODE_DO_MATH:
                int answer = data.getIntExtra(EXTRA_ANSWER, 0);
                TextView answerView = (TextView) findViewById(R.id.textViewAnswer);
                answerView.setText("" + answer);
                break;
        }
    }
}
