package com.bahraoui.bmicalculator;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText heightInput;
    private EditText weightInput;  // Fixed typo here
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        weightInput = findViewById(R.id.wightInput);  // Fixed typo here as well
        heightInput = findViewById(R.id.heightInput);
        resultText = findViewById(R.id.resultText);
        Button calculateBTN = findViewById(R.id.calculateBTN);

        calculateBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String weightStr = weightInput.getText().toString();
        String heightStr = heightInput.getText().toString();

        if (TextUtils.isEmpty(weightStr) || TextUtils.isEmpty(heightStr)) {
            Toast.makeText(this, "Please enter both weight and height", Toast.LENGTH_SHORT).show();
            return;
        }

        float weight = Float.parseFloat(weightStr);
        float height = Float.parseFloat(heightStr);
        if (height == 0) {
            Toast.makeText(this, "Height cannot be zero", Toast.LENGTH_SHORT).show();
            return;
        }


        if (height == 0) {
            Toast.makeText(this, "Height cannot be zero", Toast.LENGTH_SHORT).show();
            return;
        }

        float bmi = weight / (height * height);
        String bmiResult = interpretBMI(bmi);
        resultText.setText("Your BMI is: " + bmi + "\n" + bmiResult);
    }

    // Method to interpret BMI result
    private String interpretBMI(float bmi) {
        if (bmi < 18.5) {
            return "You are underweight.";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "You have a normal weight.";
        } else if (bmi >= 25 && bmi <= 29.9) {
            return "You are overweight.";
        } else {
            return "You are obese.";
        }
    }
}
