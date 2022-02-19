package com.example.neverafk;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.techdew.stomplibrary.Stomp;
import com.techdew.stomplibrary.StompClient;

import org.java_websocket.WebSocket;


public class Home extends AppCompatActivity {
    String url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            url = extras.getString("url");
        }
        StompClient mStompClient = Stomp.over(WebSocket.class, url);
        mStompClient.connect();

        Button disconnect = (Button) findViewById(R.id.disconnect);
        disconnect.setOnClickListener(onClick(mStompClient));

    }

    private View.OnClickListener onClick(StompClient mStompClient) {
        mStompClient.disconnect();
        return null;
    }
}
