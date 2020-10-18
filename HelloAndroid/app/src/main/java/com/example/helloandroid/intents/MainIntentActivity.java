package com.example.helloandroid.intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloandroid.R;

public class MainIntentActivity extends AppCompatActivity {

    Button bView1, bView2, bMsa1, bMsa2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_intent_activity);
        bView1 = (Button) findViewById(R.id.bView1);
        bView2 = (Button) findViewById(R.id.bView2);
        bMsa1 = (Button) findViewById(R.id.bMsa1);
        bMsa2 = (Button) findViewById(R.id.bMsa2);

        bView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.googl.com");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        bView2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:00401213456");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}