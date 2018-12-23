package com.ege.publictransformationroutefindersystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        EditText chsCity= (EditText) findViewById(R.id.chsCity);
        chsCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SettingsActivity.this, "Choose City Settings", Toast.LENGTH_SHORT).show();
            }
        });
        EditText notif= (EditText) findViewById(R.id.notif);
        notif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SettingsActivity.this, "Notification Settings", Toast.LENGTH_SHORT).show();
            }
        });
        EditText map= (EditText) findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SettingsActivity.this, "Map Settings", Toast.LENGTH_SHORT).show();
            }
        });
        EditText privacy= (EditText) findViewById(R.id.privacy);
        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SettingsActivity.this, "Privacy Settings", Toast.LENGTH_SHORT).show();
            }
        });
        EditText help= (EditText) findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SettingsActivity.this, "HELP", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
