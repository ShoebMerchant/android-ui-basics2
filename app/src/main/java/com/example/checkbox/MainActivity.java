package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CheckBox checkBoxHarry, checkBoxMatrix, checkBoxJoker;
    private RadioGroup rgMaritalStatus;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxHarry = findViewById(R.id.checkboxHarry);
        checkBoxMatrix = findViewById(R.id.checkboxMatrix);
        checkBoxJoker = findViewById(R.id.checkboxJoker);

        checkBoxHarry.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(MainActivity.this, "You have watched Harry Potter, Yay", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "You Need to watch Harry Potter", Toast.LENGTH_SHORT).show();
            }
        });

        rgMaritalStatus = findViewById(R.id.rgMaritalStatus);
        rgMaritalStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbMarried:
                        Toast.makeText(MainActivity.this, "Married", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbSingle:
                        Toast.makeText(MainActivity.this, "Single", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbInRel:
                        Toast.makeText(MainActivity.this, "In a Relationship",
                                Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });

        progressBar = findViewById(R.id.progressBar);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    progressBar.incrementProgressBy(10);
                    SystemClock.sleep(500);
                }
            }
        });
        thread.start();
    }
}