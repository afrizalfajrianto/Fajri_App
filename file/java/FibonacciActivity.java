package com.example.helloappti22a4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;
import android.widget.EditText;

public class FibonacciActivity extends AppCompatActivity {

    private long fibMinus1 = 0;
    private long fibMinus2 = 1;
    private long currentFib = 0;
    private TextView mShowFibonacci;
    private long i = 0;

    private long n = 0;
    private long limit = 0; // Menyimpan batas Fibonacci yang diinginkan

    private EditText mLimitInput;
    private boolean limitRequiredMode = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonacci);
        mShowFibonacci = (TextView) findViewById(R.id.show_count);
        mLimitInput = (EditText) findViewById(R.id.limit_input);
        updateFibonacciDisplay();
    }

    public void countUp(View view) {
        if (limitRequiredMode) {
            if (mLimitInput.getText().toString().isEmpty()) {
                Toast.makeText(this, "Enter the limit first", Toast.LENGTH_SHORT).show();
                return;
            }
            limit = Long.parseLong(mLimitInput.getText().toString());
            if (n >= limit) {
                Toast.makeText(this, "Fibonacci limit reached", Toast.LENGTH_SHORT).show();
                return; // Hentikan perhitungan jika jumlah baris Fibonacci mencapai batas
            }
            long newFib = fibMinus1 + fibMinus2;
            fibMinus2 = fibMinus1;
            fibMinus1 = newFib;
            currentFib = newFib;
            n++; // Inkrementasi jumlah baris Fibonacci
            updateFibonacciDisplay();
        }


        if (!limitRequiredMode) {
            long newFib = fibMinus1 + fibMinus2;
            fibMinus2 = fibMinus1;
            fibMinus1 = newFib;
            currentFib = newFib;
            updateFibonacciDisplay();
        }

    }


    public void toggleMode(View view) {
        limitRequiredMode = !limitRequiredMode;
        mLimitInput.setEnabled(limitRequiredMode); // Menonaktifkan input saat dalam mode "no-limit"
        if (limitRequiredMode) {
            mLimitInput.setVisibility(View.VISIBLE);
            Toast toast = Toast.makeText(this, "Limited", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0); // Mengatur posisi ke tengah atas
            mLimitInput.setHint("Enter Limit");
            currentFib = 0;
            fibMinus2 = 1;
            fibMinus1 = 0;
            limit = 0;
            n = 0;
            mLimitInput.setText(""); // Mengosongkan input
            updateFibonacciDisplay();
            toast.show(); // Menampilkan Toast
        } else {
            mLimitInput.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Unlimited", Toast.LENGTH_SHORT).show();
            mLimitInput.setHint("Unlimited");
            currentFib = 0;
            fibMinus2 = 1;
            fibMinus1 = 0;
            limit = 0;
            n = 0;
            mLimitInput.setText(""); // Mengosongkan input
            updateFibonacciDisplay();
        }
    }

    public void reset(View view) {
        currentFib = 0;
        fibMinus2 = 1;
        fibMinus1 = 0;
        limit = 0;
        n = 0;
        mLimitInput.setText(""); // Mengosongkan input
        updateFibonacciDisplay();
    }

    private void updateFibonacciDisplay() {
        if (mShowFibonacci != null) {
            mShowFibonacci.setText(Long.toString(currentFib));
            mShowFibonacci.setTextColor(getFibonacciColor());
        }
    }

    private int getFibonacciColor() {
        // Gantilah warna berdasarkan nilai Fibonacci
        i++;
        if (i % 2 == 0) {
            return ContextCompat.getColor(this, R.color.colorPrimaryDark);
        } else {
            return ContextCompat.getColor(this, R.color.colorFibonacciGreen);
        }
    }
}