package com.example.neverafk;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.Result;

import java.util.Scanner;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanClass extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        scannerView = findViewById(R.id.scannerView);
        scannerView.setAspectTolerance(0.5f);
        scannerView.setResultHandler(ScanClass.this);
        scannerView.startCamera();
    }


    @Override
    public void handleResult(Result rawResult) {
        String url = rawResult.getText();
        Intent intent = new Intent(this, Home.class);
        intent.putExtra("url", url);
        startActivity(intent);

    }
}
