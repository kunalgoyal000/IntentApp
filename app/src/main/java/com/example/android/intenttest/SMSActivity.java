package com.example.android.intenttest;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SMSActivity extends AppCompatActivity {
    EditText ul=null;
    EditText ul1=null;
    private static final int REQUEST_SMS = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
    }

    public void sms1(View view) {
         ul=(EditText)findViewById(R.id.mn);
         ul1=(EditText)findViewById(R.id.message);
        String mn=ul.getText().toString();
        String message=ul1.getText().toString();
        if(mn.length()!=10){
            ul.setError("Please enter a valid mobile number");
            ul.requestFocus();
            return;
        }
        if(message.isEmpty()){
            ul1.setError("Please enter a Message");
            ul1.requestFocus();
            return;
        }
        else {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + mn));
            intent.putExtra("sms_body", message);
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS},REQUEST_SMS);
            }
            else
            {
                startActivity(intent);
            }
    }}


}
