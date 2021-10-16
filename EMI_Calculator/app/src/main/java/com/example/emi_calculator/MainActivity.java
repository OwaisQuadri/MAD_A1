package com.example.emi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateEMI(View view){
        //initialize variables
        double mortgage,interestRate,years;
        //get mortgage from EditText to double
        EditText m = (EditText) findViewById(R.id.mortgageInput);
        String M = m.getText().toString();
        mortgage=Double.parseDouble(M);
        //get interest rate from EditText to double
        EditText ir = (EditText) findViewById(R.id.interestRateInput);
        String IR = ir.getText().toString();
        interestRate=Double.parseDouble(IR);
        interestRate/=100;
        double montlyIR=interestRate/12;
        //get years from EditText to double
        EditText y = (EditText) findViewById(R.id.yearsInput);
        String Y = y.getText().toString();
        years=Double.parseDouble(Y);
        //System.out.println(mortgage+" "+interestRate+" "+years);//test
        //declare result variable
        double emi;
        //use EMI formula (P × r × (1 + r)n/((1 + r)n - 1)
        double months=years*12;
        double firstPart,fraction,numerator,denominator;
        firstPart=mortgage*montlyIR;
        numerator=Math.pow(1+montlyIR,months);
        denominator=(Math.pow(1+montlyIR,months)-1);
        fraction=numerator/denominator;
        emi=firstPart*fraction;
        //output EMI to outputLabel
        TextView outputLabel=(TextView) findViewById(R.id.outputLabel);
        DecimalFormat dollars = new DecimalFormat("$0.00");//format dollars
        outputLabel.setText("Your equated monthly installment is : \n"+dollars.format(emi));
    }
}