package com.example.mysolution;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mysolution.Operations.Add;
import com.example.mysolution.Operations.Devide;
import com.example.mysolution.Operations.Multiply;
import com.example.mysolution.Operations.Operation;
import com.example.mysolution.Operations.Percent;
import com.example.mysolution.Operations.Subtract;

public class CalculatorActivity extends AppCompatActivity {
    private static final Operation[] OPERATIONS = {new Add(), new Subtract(), new Devide(), new Multiply(), new Percent()};
    EditText input1, input2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        input1 = (EditText) findViewById(R.id.input1);
        input2 = (EditText) findViewById(R.id.input2);
        Button add = findViewById(R.id.add_button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(input1.getText().toString());
                int y = Integer.parseInt(input2.getText().toString());
                int total = (x+y);
                StringBuilder builder = new StringBuilder();
                    builder.append(total);

                new AlertDialog.Builder(CalculatorActivity.this).setTitle("Answer").
                        setMessage(builder.toString()).
                        show();
            }
        });
        Button sub = findViewById(R.id.sub_button);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(input1.getText().toString());
                int y = Integer.parseInt(input2.getText().toString());
                int total = (x-y);
                StringBuilder builder = new StringBuilder();
                builder.append(total);
                    new AlertDialog.Builder(CalculatorActivity.this).setTitle("Answer").
                            setMessage(builder.toString()).
                            show();

            }
        });
        Button mul = findViewById(R.id.mul_button);
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(input1.getText().toString());
                int y = Integer.parseInt(input2.getText().toString());
                int total = (x*y);
                StringBuilder builder = new StringBuilder();
                builder.append(total);

                new AlertDialog.Builder(CalculatorActivity.this).setTitle("Answer").
                        setMessage(builder.toString()).
                        show();
            }
        });
        Button div = findViewById(R.id.div_button);
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(input1.getText().toString());
                int y = Integer.parseInt(input2.getText().toString());
                int total = (x/y);
                StringBuilder builder = new StringBuilder();
                builder.append(total);

                new AlertDialog.Builder(CalculatorActivity.this).setTitle("Answer").
                        setMessage(builder.toString()).
                        show();
            }
        });
        Button mod = findViewById(R.id.percen_button);
        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(input1.getText().toString());
                int y = Integer.parseInt(input2.getText().toString());
                int total = OPERATIONS[4].eval(x,y);
                StringBuilder builder = new StringBuilder();
                builder.append(total);

                new AlertDialog.Builder(CalculatorActivity.this).setTitle("Answer").
                        setMessage(builder.toString()).
                        show();
            }
        });
    }
}
