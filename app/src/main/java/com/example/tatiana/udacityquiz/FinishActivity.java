package com.example.tatiana.udacityquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinishActivity extends AppCompatActivity {
    TextView pt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        int score = getIntent().getIntExtra("score", 0);
        int total = getIntent().getIntExtra("total", 0);
        boolean checkCheat = getIntent().getBooleanExtra("checkCheat", false);
        TextView scoreView = (TextView) findViewById(R.id.quantity);
        scoreView.setText(score + " out of " + total + " right answers");
        if (score == 0) {
            pt = (TextView) findViewById(R.id.pt);
            pt.setText("Meeeh :(");
        }
            else if (score <= total/4){
            pt = (TextView) findViewById(R.id.pt);
            pt.setText("You need to be learning more :/");
            }
        else if (score <= total/2 ){
            pt = (TextView) findViewById(R.id.pt);
            pt.setText("You tried, bro.");
        }
        else if (score <= total/4*3){
            pt = (TextView) findViewById(R.id.pt);
            pt.setText("Cool!");
        }
        else if (score < total){
            pt = (TextView) findViewById(R.id.pt);
            pt.setText("High five, bro!");
        }
        else if (score == total){
            pt = (TextView) findViewById(R.id.pt);
            pt.setText("Welcome home, Master.");
        }
        if (checkCheat == true) {
            pt = (TextView) findViewById(R.id.pt);
            pt.setText(pt.getText().toString() + " ...Oh, and you cheater.");
        }
        Button again = (Button) findViewById(R.id.again);
        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}
