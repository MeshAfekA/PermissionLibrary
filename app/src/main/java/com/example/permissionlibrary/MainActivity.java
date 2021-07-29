package com.example.permissionlibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.permissionlibrary.Permission_Checker_Library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView result;
    private Button btn;
    private AutoCompleteTextView permissionsACTV;
    private ArrayList<String> permissionsAL;
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        initViews();

    }

    public void findViews(){
        result = findViewById(R.id.result);
        btn = findViewById(R.id.btn);
        spinner = (Spinner) findViewById(R.id.planets_spinner);
    }

    public void initViews(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        btn.setOnClickListener(v -> {
            if(Permission_Checker_Library.checkThePermissions(this, spinner.getSelectedItem().toString()))
                result.setText("Permissions granted!");
            else
                result.setText("You don't have this permissions");
            result.setVisibility(View.VISIBLE);
        });

    }
}