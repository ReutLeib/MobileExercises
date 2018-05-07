package com.shenkar.reutleib.reutmobile;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    android.widget.Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnSub, btnMult, btnDiv, btnPlus, btnEqual, btnCE;
    android.widget.TextView ans;
    double var1, var2, varRst = 0;
    boolean add, sub, mult, div = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.shenkar.reutleib.reutmobile.R.layout.activity_calculator);

        btn0 = (Button) findViewById(R.id.button0);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn7 = (Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        btn9 = (Button) findViewById(R.id.button9);
        btnPlus = (Button) findViewById(R.id.buttonPlus);
        btnEqual = (Button) findViewById(R.id.buttonEqual);
        btnSub = (Button) findViewById(R.id.buttonSub);
        btnMult = (Button) findViewById(R.id.buttonMult);
        btnDiv = (Button) findViewById(R.id.buttonDiv);
        btnCE = (Button) findViewById(R.id.buttonCE);

        ans = (android.widget.TextView) findViewById(R.id.Answer);


        btnCE.setOnClickListener(new View.OnClickListener() {
            //            @override
            public void onClick(View v) {
                ans.setText(null);
                add = div = sub = mult = false;
                var1 = var2 = 0;
            }

        });

        btn0.setOnClickListener(new View.OnClickListener() {
            //            @override
            public void onClick(View v) {
                ans.setText(ans.getText() + "0");
            }

        });


        btn1.setOnClickListener(new View.OnClickListener() {
            //            @override
            public void onClick(View v) {
                ans.setText(ans.getText() + "1");
            }

        });


        btn2.setOnClickListener(new View.OnClickListener() {
            //            @override
            public void onClick(View v) {
                ans.setText(ans.getText() + "2");
            }

        });


        btn3.setOnClickListener(new View.OnClickListener() {
            //            @override
            public void onClick(View v) {
                ans.setText(ans.getText() + "3");
            }

        });


        btn4.setOnClickListener(new View.OnClickListener() {
            //            @override
            public void onClick(View v) {
                ans.setText(ans.getText() + "4");
            }

        });


        btn5.setOnClickListener(new View.OnClickListener() {
            //            @override
            public void onClick(View v) {
                ans.setText(ans.getText() + "5");
            }

        });


        btn6.setOnClickListener(new View.OnClickListener() {
            //            @override
            public void onClick(View v) {
                ans.setText(ans.getText() + "6");
            }

        });

        btn7.setOnClickListener(new View.OnClickListener() {
            //            @override
            public void onClick(View v) {
                ans.setText(ans.getText() + "7");
            }

        });

        btn8.setOnClickListener(new View.OnClickListener() {
            //            @override
            public void onClick(View v) {
                ans.setText(ans.getText() + "8");
            }

        });

        btn9.setOnClickListener(new View.OnClickListener() {
            //            @override
            public void onClick(View v) {
                ans.setText(ans.getText() + "9");
            }

        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            //            @override
            public void onClick(View v) {
                if (varRst == 0) {
                    var1 = Double.parseDouble(ans.getText() + "");
                }

                add = true;
                ans.setText(null);
            }

        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            //            @override
            public void onClick(View v) {
                var1 = Double.parseDouble(ans.getText() + "");
                div = true;
                ans.setText(null);
            }

        });

        btnMult.setOnClickListener(new View.OnClickListener() {
            //            @override
            public void onClick(View v) {
                var1 = Double.parseDouble(ans.getText() + "");
                mult = true;
                ans.setText(null);
            }

        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            //            @override
            public void onClick(View v) {
                var1 = Double.parseDouble(ans.getText() + "");
                sub = true;
                ans.setText(null);
            }

        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            //            @override
            public void onClick(View v) {
                var2 = Double.parseDouble(ans.getText() + "");

                if (add == true) {
                    varRst = var1 + var2;
                    ans.setText(varRst + "");
                    var1 = varRst;
                    add = false;
                    var2 = 0;
                }
                if (sub == true) {
                    varRst = var1 - var2;
                    ans.setText(varRst + "");
                    var1 = varRst;
                    sub = false;
                    var2 = 0;
                }
                if (mult == true) {
                    varRst = var1 * var2;
                    ans.setText(varRst + "");
                    var1 = varRst;
                    mult = false;
                    var2 = 0;
                }
                if (div == true) {
                    varRst = var1 / var2;
                    ans.setText(varRst + "");
                    var1 = varRst;
                    div = false;
                    var2 = 0;
                }
            }

        });


    }
}

