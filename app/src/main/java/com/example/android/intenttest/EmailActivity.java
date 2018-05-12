package com.example.android.intenttest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EmailActivity extends AppCompatActivity {
   EditText u1=null;
    EditText ul1=null;
    EditText ul2=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
    }

    public void mail1(View view) {
        u1 = (EditText) findViewById(R.id.url);
        ul1 = (EditText) findViewById(R.id.message);
        ul2 = (EditText) findViewById(R.id.message1);
        String mn = u1.getText().toString();
        String message = ul1.getText().toString();
        String body = ul2.getText().toString();

       /* if (mn.isEmpty() && ) {
            u1.setError("Please enter a valid email.");
            u1.requestFocus();
            return;
        }*/
       if(mn.isEmpty()){
           u1.setError("Please enter a valid Email");
           u1.requestFocus();
           return;
       }
        if (message.isEmpty()) {
            ul1.setError("Please enter a message");
            ul1.requestFocus();
            return;
        }
        if (body.isEmpty()) {
            ul2.setError("Please enter a body");
            ul2.requestFocus();
            return;
        }
        else {
            Intent intent = new Intent(Intent.ACTION_SENDTO,Uri.parse("mailto:" + mn));
            intent.putExtra(Intent.EXTRA_SUBJECT, message);
            intent.putExtra(Intent.EXTRA_TEXT, body);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
    }
}
