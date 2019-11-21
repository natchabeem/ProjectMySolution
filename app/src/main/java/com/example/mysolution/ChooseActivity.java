package com.example.mysolution;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        Button game = (Button) findViewById(R.id.game_button);
        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseActivity.this,MainActivity.class);

                startActivity(intent);
            }
        });

        Button cal = (Button) findViewById(R.id.cal_button);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseActivity.this,CalculatorActivity.class);

                startActivity(intent);
            }
        });

        Button temp = (Button) findViewById(R.id.temp_button);
        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseActivity.this,TemperatureActivity.class);

                startActivity(intent);
            }
        });
    }
}
