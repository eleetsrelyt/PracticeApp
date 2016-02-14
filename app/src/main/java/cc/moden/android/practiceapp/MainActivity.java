package cc.moden.android.practiceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private List<Car> myCars = new ArrayList<Car>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateCarList();
        populateListView();
        registerClickCallback();

    }




    private void populateCarList() {
        myCars.add(new Car("Ford", 1940, R.drawable.car184, "Needing work"));
        myCars.add(new Car("Toyota", 1994, R.drawable.vehicle33, "Lovable"));
        myCars.add(new Car("Honda", 1999, R.drawable.vintage40, "Wet"));
        myCars.add(new Car("Porche", 2005, R.drawable.sedan4, "Fast!"));
        myCars.add(new Car("Jeep", 2000, R.drawable.car80, "Awesome"));
        myCars.add(new Car("Rust-Bucket", 2010, R.drawable.blac186, "Not *very* good"));
        myCars.add(new Car("Moon Lander", 1971, R.drawable.vehicle46, "Out of this world"));
    }


    private void populateListView() {
        ArrayAdapter<Car> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.carsListView);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<Car> {
        public MyListAdapter() {
            super(MainActivity.this, R.layout.item_view, myCars);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Make sure we have a veiw to work with (may have been given null)
            View itemView = convertView;
            if (itemView == null) {
                itemView = getLayoutInflater().inflate(R.layout.item_view, parent, false);
            }

            // find the car
            Car currentCar = myCars.get(position);


            // fill the view
            ImageView imageView = (ImageView)itemView.findViewById(R.id.item_icon);
            imageView.setImageResource(currentCar.getIconID());

            TextView makeText = (TextView) itemView.findViewById(R.id.item_txtMake);
            makeText.setText(currentCar.getMake());

            TextView yearText = (TextView) itemView.findViewById(R.id.item_txtYear);
            yearText.setText("" + currentCar.getYear());

            TextView conditionText = (TextView) itemView.findViewById(R.id.item_txtCondition);
            conditionText.setText(currentCar.getCondition());

            return itemView;

        }

    }
    private void registerClickCallback() {
        ListView list = (ListView) findViewById(R.id.carsListView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                Car clickedCar = myCars.get(position);
                String message = "You clicked position: " + position + ". Which is car make " + clickedCar.getMake();
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();

            }
        });
    }

}
