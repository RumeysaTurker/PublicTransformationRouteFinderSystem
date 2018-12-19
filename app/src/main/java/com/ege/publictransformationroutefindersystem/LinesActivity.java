package com.ege.publictransformationroutefindersystem;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class LinesActivity extends AppCompatActivity {

ListView listview;
FirebaseListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lines);

    listview=(ListView)findViewById(R.id.lwLines);
 Query query=FirebaseDatabase.getInstance().getReference().child("Vehicles");
        FirebaseListOptions<Vehicles> options= new FirebaseListOptions.Builder<Vehicles>()
                .setLayout(R.layout.vehicles)
                .setLifecycleOwner(LinesActivity.this)
                .setQuery(query,Vehicles.class)
                .build();

   adapter=new FirebaseListAdapter(options) {
       @Override
       protected void populateView(@NonNull View v, @NonNull Object model, int position) {
          TextView vehicleID=v.findViewById(R.id.vehicleID);
           TextView vehicleRoute=v.findViewById(R.id.vehicleRoute);
           TextView routeEstimationTime=v.findViewById(R.id.routeEstimationTime);
           TextView vehicleType=v.findViewById(R.id.vehicleType);
           Vehicles vehicle=(Vehicles) model;
           vehicleID.setText("ID:"+vehicle.getVehicleID().toString());
           vehicleType.setText("TYPE:"+vehicle.getVehicleType().toString());
           vehicleRoute.setText("ROUTE:"+vehicle.getVehicleRoute().toString());
           routeEstimationTime.setText("TIME:"+vehicle.getRouteEstimationTime().toString());
       }
   };
   listview.setAdapter(adapter);
}

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
