package com.example.codegrindr;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchAdapter extends ArrayAdapter implements Filterable {

    //to reference the Activity
    private Activity context;
    //to store the animal images
    private ArrayList<Integer> imageArray;
    //to store the list of countries
    private ArrayList<String> hackathonNameArray;
    //to store the list of countries
    private ArrayList<String> dateArray;
    // to store location of hackathon
    private ArrayList<String> locationArray;

    public SearchAdapter(Activity context, ArrayList<String> nameArrayParam, ArrayList<String> dateArrayParam, ArrayList<String> locationArrayParam, ArrayList<Integer> imageArrayParam){

        super(context,R.layout.activity_registered_hackathon_row , nameArrayParam);

        this.context=context;
        this.imageArray = imageArrayParam;
        this.hackathonNameArray = nameArrayParam;
        this.dateArray = dateArrayParam;
        this.locationArray = locationArrayParam;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.activity_registered_hackathon_row, null,true);

        //this code gets references to objects in the activity_registered_hackathon_row.xml file
        TextView nameTextField = (TextView) rowView.findViewById(R.id.hackathon_name);
        TextView dateTextField = (TextView) rowView.findViewById(R.id.hackathon_date);
        TextView locationTextField = (TextView) rowView.findViewById(R.id.hackathon_location);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.logoImageView);

        //this code sets the values of the objects to values from the arrays

        nameTextField.setText(hackathonNameArray.get(position));
        dateTextField.setText(dateArray.get(position));
        locationTextField.setText(locationArray.get(position));
        imageView.setImageResource(imageArray.get(position));
        return rowView;

    };

//    @Override
//    public Filter getFilter() {
//        Filter filter = new Filter() {
//
//            @SuppressWarnings("unchecked")
//            @Override
//            protected void publishResults(CharSequence constraint,FilterResults results) {
//
//                hackathonNameArray = (ArrayList<String>) results.values; // has the filtered values
//                notifyDataSetChanged();  // notifies the data with new filtered values
//            }
//
//            @Override
//            protected FilterResults performFiltering(CharSequence constraint) {
//                FilterResults results = new FilterResults();        // Holds the results of a filtering operation in values
//                ArrayList<String> FilteredArrList = new ArrayList<String>();
//
//                if (hackathonNameArray == null) {
//                    hackathonNameArray = new ArrayList<String>(hackathonNameArray); // saves the original data in mOriginalValues
//                }
//
//                /********
//                 *
//                 *  If constraint(CharSequence that is received) is null returns the mOriginalValues(Original) values
//                 *  else does the Filtering and returns FilteredArrList(Filtered)
//                 *
//                 ********/
//                if (constraint == null || constraint.length() == 0) {
//
//                    // set the Original result to return
//                    results.count = hackathonNameArray.size();
//                    results.values = hackathonNameArray;
//                } else {
//                    constraint = constraint.toString().toLowerCase();
//                    for (int i = 0; i < hackathonNameArray.size(); i++) {
//                        String data = hackathonNameArray.get(i);
//                        if (data.toLowerCase().startsWith(constraint.toString())) {
//                            FilteredArrList.add(new String(hackathonNameArray.get(i)));
//                        }
//                    }
//                    // set the Filtered result to return
//                    results.count = FilteredArrList.size();
//                    results.values = FilteredArrList;
//                }
//                return results;
//            }
//        };
//        return filter;
//    }
}
