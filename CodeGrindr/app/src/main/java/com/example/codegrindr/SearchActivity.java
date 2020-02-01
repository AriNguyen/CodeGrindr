package com.example.codegrindr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    ArrayList<String> myList = new ArrayList<String>();
    //HashMap<String, String> myList = new HashMap<String, String>();
    ArrayAdapter<String> arrayAdapter;
    ListView lv;
    EditText txtSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        for(int i = 0; i < 100; i++){
            int z = i;
            myList.add("This is line number " + i);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        lv = (ListView) findViewById(R.id.lstViewSearch);

        arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                myList );
        //MyAdapter adapter = new MyAdapter();


        lv.setAdapter(arrayAdapter);

        txtSearch = (EditText) findViewById(R.id.txtSearchBox);
        lv.setTextFilterEnabled(true);

        txtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                SearchActivity.this.arrayAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
