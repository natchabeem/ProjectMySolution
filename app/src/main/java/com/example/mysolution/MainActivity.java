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
import com.example.mysolution.Operations.Subtract;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final Operation[] OPERATIONS = {new Add(), new Subtract(), new Devide(), new Multiply()};
    private ArrayList<String> solution = new ArrayList<>();
    private EditText numbers, target;
    private Button sol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numbers = (EditText) findViewById(R.id.num_edit_text);
        target = (EditText) findViewById(R.id.target_edit_Text);
        sol = (Button) findViewById(R.id.check_button);
        sol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = numbers.getText().toString();
                String[] tmp = str.split(" ");
                int[] numbers = new int[tmp.length];

                for (int i = 0; i < tmp.length; i++) {
                    numbers[i] = Integer.parseInt(tmp[i]);
                }

                int total = Integer.parseInt(target.getText().toString());
                solution.clear();

                if (findSolution(numbers, numbers.length, total)) {
                    printSolution();
                } else {
                    new AlertDialog.Builder(MainActivity.this).setTitle("Solution").
                            setMessage("Sorry, no solution").
                            show();
                }

            }
        });
    }
    public boolean findSolution(int[] t, int nb, int total) {
        for (int i = 0; i < nb; i++) {
            if (t[i] == total) {
                return true;
            }

            for (int j = i + 1; j < nb; j++) {
                for (int k = 0; k < OPERATIONS.length; k++) {
                    int res = OPERATIONS[k].eval(t[i], t[j]);

                    if (res != 0) {
                        int savei = t[i], savej = t[j];
                        t[i] = res;
                        t[j] = t[nb - 1];

                        if (findSolution(t, nb - 1, total)) {
                            solution.add(Math.max(savei, savej) + " " +
                                    OPERATIONS[k].symbol() + " " +
                                    Math.min(savei, savej) + " = " + res);
                            return true;
                        }

                        t[i] = savei;
                        t[j] = savej;
                    }
                }
            }
        }

        return false;
    }

    public void printSolution() {
        StringBuilder builder = new StringBuilder();

        for (int i = solution.size() - 1; i >= 0; i--) {
            builder.append(solution.get(i)).append("\n");
        }

        new AlertDialog.Builder(this).setTitle("Solution").
                setMessage(builder.toString()).
                show();
    }

}
