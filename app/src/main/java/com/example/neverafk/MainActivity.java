package com.example.neverafk;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    //Initialize variable


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign variable

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(view -> openScanner());
    }

    private void openScanner(){
        Intent intent = new Intent(this, ScanClass.class);
        startActivity(intent);
    }
}
