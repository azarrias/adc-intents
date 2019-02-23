package com.example.intents;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnOpenWebPage;
    private Button btnMakePhoneCall;
    private Button btnNavigateMap;
    private Button btnTakePicture;
    private Button btnSendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOpenWebPage = findViewById(R.id.button);
        btnOpenWebPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebPage(v);
            }
        });

        btnMakePhoneCall = findViewById(R.id.button2);
        btnMakePhoneCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall(v);
            }
        });

        btnNavigateMap = findViewById(R.id.button3);
        btnNavigateMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateMap(v);
            }
        });

        btnTakePicture = findViewById(R.id.button4);
        btnTakePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePicture(v);
            }
        });

        btnSendEmail = findViewById(R.id.button5);
        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail(v);
            }
        });
    }

    public void openWebPage(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        startActivity(intent);
    }

    public void makePhoneCall(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:555123456"));
        startActivity(intent);
    }

    public void navigateMap(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:41.656313,-0.877351"));
        startActivity(intent);
    }

    public void takePicture(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
    }

    public void sendEmail(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        intent.putExtra(Intent.EXTRA_TEXT, "Email body text");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"johndoe@hosting.com"});
        startActivity(intent);
    }
}
