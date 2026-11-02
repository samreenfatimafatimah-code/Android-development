package com.example.assignmentno1;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.scrollMain), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Setup AutoCompleteTextView
        AutoCompleteTextView autoCountry = findViewById(R.id.autoCountry);
        if (autoCountry != null) {
            String[] countries = getResources().getStringArray(R.array.country_list);
            ArrayAdapter<String> autoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, countries);
            autoCountry.setAdapter(autoAdapter);
        }

        // Setup ListView
        ListView listNames = findViewById(R.id.listNames);
        if (listNames != null) {
            String[] names = {"Sara", "Usman", "Fatima", "Zain"};
            ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
            listNames.setAdapter(listAdapter);
        }

        // Setup RecyclerView LayoutManager
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
    }

    public void onSubmitClick(View view) {
        Toast.makeText(this, "Submitted!", Toast.LENGTH_SHORT).show();
    }
}