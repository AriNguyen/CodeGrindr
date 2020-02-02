package com.example.codegrindr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class SearchActivity extends AppCompatActivity {
    EditText txtSearch;
    SearchAdapter searchAdapter;

    String[] hackathonNameArray = {
            "Hoya Hacks",
            "Make Harvard",
            "DragonHacks"};

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
    ArrayList<String> HackNames = new ArrayList<String>();
    ArrayList<String> dateStart = new ArrayList<String>();
    ArrayList<String> locationSet = new ArrayList<String>();
    ArrayList<Integer> imageGet = new ArrayList<Integer>();

    Random r = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        for(int i = 0; i < 100; i++){
            if(i % 2 == 0){
                HackNames.add(hackathonNameArray[1] + r.nextInt(26));
                dateStart.add(dateArray[1]);
                locationSet.add(locationArray[0]);
                imageGet.add(imageArray[2]);
            }
            else if(i % 3 == 0){
                HackNames.add(hackathonNameArray[2] + r.nextInt(26));
                dateStart.add(dateArray[2]);
                locationSet.add(locationArray[1]);
                imageGet.add(imageArray[1]);
            }
            else{
                HackNames.add(hackathonNameArray[0] + r.nextInt(26));
                dateStart.add(dateArray[0]);
                locationSet.add(locationArray[2]);
                imageGet.add(imageArray[0]);
            }
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        searchAdapter = new SearchAdapter(this, HackNames, dateStart, locationSet, imageGet);
        listView = (ListView) findViewById(R.id.lstViewSearch);
        listView.setAdapter(searchAdapter);

        txtSearch = (EditText) findViewById(R.id.txtSearchBox);
        listView.setTextFilterEnabled(true);

        txtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                SearchActivity.this.searchAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
