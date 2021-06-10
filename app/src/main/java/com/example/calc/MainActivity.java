package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import nguyenvanquan7826.com.Balan;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView input;
    private TextView output;

    private final int[] idBtn = {
            R.id.zero, R.id.one, R.id.two, R.id.three, R.id.four, R.id.five, R.id.six, R.id.seven, R.id.eight, R.id.nine,
            R.id.dot,
            R.id.summation, R.id.subtraction, R.id.multiplication, R.id.divide,
            R.id.leftBracket, R.id.rightBracket,
            R.id.c, R.id.equal
    };

    private void getView() {
        input =  findViewById(R.id.input);
        output = findViewById(R.id.output);
        for (int i : idBtn) {
            findViewById(i).setOnClickListener(this);
        }
    }
    

    @Override
    public void onClick(View view) {
        int id = view.getId();

        for (int i = 0; i < idBtn.length - 2; i++) {
            if (id == idBtn[i]) {
                String text = ((Button) findViewById(id)).getText().toString();
                input.append(text);
            }
        }
        if (id == R.id.c) {
            input.setText("");
            output.setText("0");
        }
        if (id == R.id.equal) {
            calc();
        }
    }

    private void calc() {
        String mathInput = input.getText().toString().trim();
        if (mathInput.length() > 0) {
            Balan balan = new Balan();
            String mathResult = balan.valueMath(mathInput) + "";
            String mathError = balan.getError();

            if (mathError != null) {
                output.setText(mathError);
            }  {
                output.setText(mathResult);
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getView();
    }
}