package cc.moden.android.practiceapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


/*
 * Steps to using the DB
 * 1. [DONE] Instantiate the DB Adapter
 * 2. Open the DB
 * 3. uste get, insert, delete, to change data
 * 4. [DONE] Close the DB
*/

public class MainActivity extends AppCompatActivity {

    DBAdapter myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openDB();
    }

    private void openDB() {
        myDb = new DBAdapter(this);
        myDb.open();
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();

        closeDB();
    }

    private void closeDB() {
        myDb.close();
    }



    private void displayText(String message) {
        TextView textView = (TextView) findViewById(R.id.textDisplay);
        textView.setText(message);
    }



    public void onClick_AddRecord(View v) {
        displayText("Clicked add record");

        long newId = myDb.insertRow("Jenny", 93, "green");

        // Query
        // use ID
        Cursor cursor = myDb.getRow(newId);
        displayRecordSet(cursor);
    }

    public void onClick_ClearAll(View v) {
        displayText("Clicked clear all");
        myDb.deleteAll();
    }

    public void onClick_DisplayRecords(View v) {
        displayText("Clicked display record");

        Cursor cursor = myDb.getAllRows();
        displayRecordSet(cursor);
    }

    private void displayRecordSet(Cursor cursor) {
        String message = "";

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(DBAdapter.COL_ROWID);
                String name = cursor.getString(DBAdapter.COL_NAME);
                int studentNumber = cursor.getInt(DBAdapter.COL_STUDENTNUM);
                String favColour = cursor.getString(DBAdapter.COL_FAVCOLOUR);

                message += "id=" + id
                        + ", name=" + name
                        + ", num=" + studentNumber
                        + ", color=" + favColour
                        + "\n";
            } while (cursor.moveToNext());
        }
        // Close to avoid resouce leak
        cursor.close();

        displayText(message);
    }
}
