package com.ege.publictransformationroutefindersystem;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;


public class LinesActivity extends AppCompatActivity {
    private ListView listView;
private TextView textView;
private FirebaseDatabase database;
private DatabaseReference myRef;
private ArrayList<String> mVehicle=new ArrayList<>();
Vehicles vehicle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lines);
      database=FirebaseDatabase.getInstance();
      myRef=database.getReference("Vehicles");
        listView = (ListView) findViewById(R.id.lwLines);
          final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mVehicle);

        listView.setAdapter(arrayAdapter);
      myRef.addChildEventListener(new ChildEventListener() {
          @Override
          public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
              String value=dataSnapshot.getValue(String.class);
              mVehicle.add(value);
              arrayAdapter.notifyDataSetChanged();
          }

          @Override
          public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

          }

          @Override
          public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
              String value=dataSnapshot.getValue(String.class);
              mVehicle.remove(value);
              arrayAdapter.notifyDataSetChanged();
          }

          @Override
          public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

          }

          @Override
          public void onCancelled(@NonNull DatabaseError databaseError) {

          }


      });
    }
}
