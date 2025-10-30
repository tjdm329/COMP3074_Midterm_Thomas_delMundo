package com.example.midterm_thomas_delmundo;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText number;
    private Button genTable;
    private ListView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //connect to main activity
        number = findViewById(R.id.ETnumber);
        genTable = findViewById(R.id.btnGenTable);
        results = findViewById(R.id.results);

        //listen to button
        results.setOnClickListener(v -> calculateResults());
    }

    private void calculateResults() {
        //get input
        String n = number.getText().toString().trim();

        //validation check
        if(!n.isEmpty()){
            addToTable(Integer.parseInt(n));
        } else {
            android.widget.Toast.makeText(this, "Please Enter a Number", android.widget.Toast.LENGTH_SHORT).show();
        }
    }

    private void addToTable(int n){
        //create array list
        ArrayList<String> resultsTable = new ArrayList<>();

        // add multiplication results onto table
        for (int i =1; i<=10; i++){
            resultsTable.add(String.valueOf(n * i));
        }

        //set adapter to create the table list
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                resultsTable
        );
        // show the results onto the table
        results.setAdapter(adapter);
    }
}