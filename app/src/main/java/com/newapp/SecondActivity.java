package com.newapp;

import static com.newapp.R.id.second;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    private Button pickMobo;
    private Button pickCPU;
    private Button pickCooler;
    private Button pickRam;
    private Button pickStorage;
    private Button pickCase;
    private Button pickGPU;
    private Button pickPSU;
    private ImageView cpuImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.second), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        pickCPU = (Button) findViewById(R.id.pick_cpu);
        pickCooler = (Button) findViewById(R.id.pick_cooler);
        pickMobo = (Button) findViewById(R.id.pick_mobo);
        pickRam = (Button) findViewById(R.id.pick_ram);
        pickStorage = (Button) findViewById(R.id.pick_storage);
        pickGPU = (Button) findViewById(R.id.pick_gpu);
        pickCase = (Button) findViewById(R.id.pick_case);
        pickPSU = (Button) findViewById(R.id.pick_psu);
        cpuImage = (ImageView) findViewById(R.id.cpu_image);

        handleIntent(getIntent());

        pickCPU.setOnClickListener(v -> startActivity(new Intent(SecondActivity.this, PickCPUActivity.class)));
        pickCooler.setOnClickListener(v -> startActivity(new Intent(SecondActivity.this, PickCoolerActivity.class)));
        pickMobo.setOnClickListener(v -> startActivity(new Intent(SecondActivity.this, PickMoboActivity.class)));
        pickRam.setOnClickListener(v -> startActivity(new Intent(SecondActivity.this, PickRamActivity.class)));
        pickStorage.setOnClickListener(v -> startActivity(new Intent(SecondActivity.this, PickStorageActivity.class)));
        pickGPU.setOnClickListener(v -> startActivity(new Intent(SecondActivity.this, PickGPUActivity.class)));
        pickCase.setOnClickListener(v -> startActivity(new Intent(SecondActivity.this, PickCaseActivity.class)));
        pickPSU.setOnClickListener(v -> startActivity(new Intent(SecondActivity.this, PickPSUActivity.class)));
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (intent != null && intent.hasExtra("CPU_IMAGE")) {
            String imageName = intent.getStringExtra("CPU_IMAGE");
            if (imageName != null && !imageName.isEmpty()) {
                int imageResource = getResources().getIdentifier(imageName, "drawable", getPackageName());
                if (imageResource != 0) {
                    cpuImage.setImageResource(imageResource);
                }
            }
        }
    }
}
