package io.brink.urbandictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {


    private EditText word;
    private Button btnsearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        word = findViewById(R.id.input_word);
        btnsearch = findViewById(R.id.btnsearch);



        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String iWord = word.getText().toString();

                String url = "http://api.urbandictionary.com/v0/define?term="+ iWord;

                SearchTask searchTask = new SearchTask(new SearchTaskCompletedListener() {
                    @Override
                    public void onSearchTaskCompleted(String[] defnList) {
                       Intent intent = new Intent(HomeActivity.this, ListActivity.class);
                       intent.putExtra("definitions", defnList);
                       startActivity(intent);
                    }
                });
                searchTask.execute(url);

            }
        });


    }
}
