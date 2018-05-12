package com.example.android.intenttest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class BrowserActivity extends AppCompatActivity {
EditText ul=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
    }

    public void url1(View view) {
        ul=(EditText)findViewById(R.id.url);
        String webpage=ul.getText().toString();
        if(webpage.isEmpty()){
           ul.setError("Please enter a valid URL.");
        }else{
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + webpage));
        startActivity(intent);
    }}
}
