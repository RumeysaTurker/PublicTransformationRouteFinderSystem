package com.ege.publictransformationroutefindersystem;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class LinesActivity extends AppCompatActivity {
    DatabaseReference dref;
ListView listview;
ArrayList<String> list=new ArrayList<>();
ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lines);

    listview=(ListView)findViewById(R.id.lwLines);
    adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,list);
    listview.setAdapter(adapter);
        dref=FirebaseDatabase.getInstance().getReference();
    dref.addChildEventListener(new ChildEventListener() {
        @Override
        public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
           String value= dataSnapshot.getValue(String.class);
            list.add(value);
            adapter.notifyDataSetChanged();
        }

        @Override
        public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

        }

        @Override
        public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
            String value= dataSnapshot.getValue(String.class);
            list.remove(value);
            adapter.notifyDataSetChanged();
        }

        @Override
        public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });


}}
