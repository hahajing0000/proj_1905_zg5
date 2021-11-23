package com.zy.home.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.zy.home.R;

public class DeepLinkTargetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deep_link_target);

        String username = getIntent().getData().getQueryParameter("username");
        String pwd = getIntent().getData().getQueryParameter("pwd");

        Toast.makeText(this, String.format("username=%s pwd=%s",username,pwd), Toast.LENGTH_SHORT).show();
    }
}