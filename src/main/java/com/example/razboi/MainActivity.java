package com.example.razboi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.net.Uri;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickPlay(View view){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
    public void onClickRules(View view){
        Uri uriUrl = Uri.parse("http://jocuridincopilarie.ro/razboi/");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
    public void onClickExit(View view){
        finish();
        moveTaskToBack(true);
    }
}
