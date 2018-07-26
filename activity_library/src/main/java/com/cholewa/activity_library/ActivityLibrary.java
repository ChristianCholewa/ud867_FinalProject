package com.cholewa.activity_library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.cholewa.javajoketellinglibrary.JavaJokeTellingLibraryClass;

public class ActivityLibrary extends AppCompatActivity {

    public static final String BUNDLE_JOKE = "BUNDLE_JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        Intent intent = getIntent();
        String joke = intent.getStringExtra(BUNDLE_JOKE);

        TextView tvJoke = findViewById(R.id.tv_joke);
        tvJoke.setText(joke);
    }

    public void done(View view) {
        finish();
    }
}
