package com.example.messageintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button sendSMS;
    EditText smsMessage, smsNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendSMS = findViewById(R.id.send_sms_button);
        smsMessage = findViewById(R.id.smsText);
        smsNumber = findViewById(R.id.smsNumber);


        sendSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtMessage = smsMessage.getText().toString();
                String numberMessage = smsNumber.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", numberMessage, null));
                intent.putExtra("sms_body", txtMessage);
                startActivity(intent);

            }
        });
    }
}