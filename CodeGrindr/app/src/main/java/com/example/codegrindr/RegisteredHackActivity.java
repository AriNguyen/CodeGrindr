package com.example.codegrindr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class RegisteredHackActivity extends AppCompatActivity {

    String[] nameArray = {"Hoya Hacks","Make Harvard","DragonHacks"};

    String[] dateArray = {
            "Jan 31st - Feb 2nd 2020",
            "Feb 1st - Feb 2nd 2020",
            "Feb 22nd - Feb 23rd 2020"
    };

    String[] locationArray = {
            "Washington DC, US",
            "Boston MA, US",
            "Philadelphia PA, US"
    };

    Integer[] imageArray = {R.drawable.hoya,
            R.drawable.makeharvard,
            R.drawable.dragonhacks
    };

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered_hack);

        CustomListAdapter whatever = new CustomListAdapter(this, nameArray, dateArray, locationArray, imageArray);
        listView = (ListView) findViewById(R.id.registered_hackathon);
        listView.setAdapter(whatever);

    }
}
