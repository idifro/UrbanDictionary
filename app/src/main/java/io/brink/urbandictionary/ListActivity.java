package io.brink.urbandictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {
    private ListView mlistView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Intent intent = getIntent();
        String[] defnList = intent.getStringArrayExtra("definitions");

        mlistView = findViewById(R.id.listDefinition);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, defnList);
        Log.d("definition list", String.valueOf(defnList.length));
        mlistView.setAdapter(adapter);
    }
}
