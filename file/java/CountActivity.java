package com.example.helloappti22a4;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CountActivity extends AppCompatActivity {
    private int nCount = 0;

    private TextView nShowCount;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);
        nShowCount = findViewById(R.id.show_count);
    }

    public void showToast(View view){
        Toast toast = Toast.makeText(this, "Menghitung Bilangan",
                Toast.LENGTH_SHORT);
        toast.show();
    }

    @SuppressLint("SetTextI18n")
    public void countUp(View view){
        nCount++;
        if (nShowCount != null)
            nShowCount.setText(Integer.toString(nCount));
    }
}