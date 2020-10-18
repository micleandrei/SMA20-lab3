package com.example.helloandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.helloandroid.lifecycle.ActivityA;

public class MainActivity extends AppCompatActivity {
    Button bClick, bShare, bSearch;
    TextView tName;
    EditText eName;
    AlertDialog.Builder builder;
    Spinner spinner;
    Intent sendIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bClick = (Button) findViewById(R.id.bClick);
        bShare = (Button) findViewById(R.id.bShare);
        bSearch = (Button) findViewById(R.id.bSearch);
        tName = (TextView) findViewById(R.id.tName);
        eName = (EditText) findViewById(R.id.eName);
        spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
        R.array.colors_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        builder = new AlertDialog.Builder(getApplicationContext());


        bClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = eName.getText().toString().matches("") ?
                        "Hello, stranger!" : "Hello, " + eName.getText().toString() + "!";
                tName.setText(text);
                createDialog(text, "Greetings");
            }
        });


        bShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendIntent = new Intent();

                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, eName.getText().toString());
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });

        bSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY,  eName.getText().toString());
                startActivity(intent);
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0: bClick.setTextColor(Color.BLUE);
                        break;
                    case 1: bClick.setTextColor(Color.GREEN);
                        break;
                    case 2: bClick.setTextColor(Color.RED);
                        break;
                case 3: bClick.setTextColor(Color.YELLOW);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                bClick.setTextColor(Color.BLACK);
            }
        });
    }

    private void createDialog(String message, String title) {
        Dialog dialog = new Dialog(message, title);
        dialog.show(getSupportFragmentManager(), "dialog");
    }

    public void clicked(View view){

                startActivity(new Intent(this, ActivityA.class));

    }
}