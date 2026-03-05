package com.newapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PickCPUActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pick_cpu_layout);

        findViewById(R.id.button_ryzen5600).setOnClickListener(this);
        findViewById(R.id.button_ryzen5700).setOnClickListener(this);
        findViewById(R.id.button_ryzen5800).setOnClickListener(this);
        findViewById(R.id.button_ryzen7600).setOnClickListener(this);
        findViewById(R.id.ryzen_7700).setOnClickListener(this);
        findViewById(R.id.button_ryzen7800).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, SecondActivity.class);
        String imageName = "";
        int id = v.getId();
        if (id == R.id.button_ryzen5600) {
            imageName = "ryzen5600";
        } else if (id == R.id.button_ryzen5700) {
            imageName = "ryzen5700";
        } else if (id == R.id.button_ryzen5800) {
            imageName = "ryzen5800";
        } else if (id == R.id.button_ryzen7600) {
            imageName = "ryzen7600";
        } else if (id == R.id.ryzen_7700) {
            imageName = "ryzen7700";
        } else if (id == R.id.button_ryzen7800) {
            imageName = "ryzen7800";
        }
        intent.putExtra("CPU_IMAGE", imageName);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        finish();
    }
}
