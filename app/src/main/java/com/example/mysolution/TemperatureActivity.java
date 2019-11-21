package com.example.mysolution;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TemperatureActivity extends AppCompatActivity {
    private ArrayList<String> calculate = new ArrayList<>();
    private Temp temperature;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        final EditText tempEdit = (EditText) findViewById(R.id.tem_editText);
        final Button submit = (Button) findViewById(R.id.tem_cal_button);
        final TextView txt = (TextView) findViewById(R.id.target_edit_Text);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str[] = tempEdit.getText().toString().split(" ");
                double temp = Double.parseDouble(str[0]);
                String type = str[1];
                calculate.clear();
                if(tempEdit.getText().toString().trim().equals("")){
                    StringBuilder builder = new StringBuilder("Please enter temperature");
                    new AlertDialog.Builder(TemperatureActivity.this).setTitle("ERROR").
                            setMessage(builder.toString()).
                            show();
                }
                else {
                    temperature = new Temp(temp,type);
                    calculate.add(String.valueOf(temperature.getCel())+" Celsius");
                    calculate.add(String.valueOf(temperature.getFah())+" Fahrenheit");
                    calculate.add(String.valueOf(temperature.getKel())+" Kelvin");
                    StringBuilder builder = new StringBuilder();
                    for (int i = calculate.size() - 1; i >= 0; i--) {
                        builder.append(calculate.get(i)).append(" \n");
                    }
                    new AlertDialog.Builder(TemperatureActivity.this).setTitle("Temperature").
                            setMessage(builder.toString()).
                            show();
                }
            }
        });
    }
}
