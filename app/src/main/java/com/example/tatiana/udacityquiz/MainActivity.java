package com.example.tatiana.udacityquiz;

import android.content.Intent;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int currentQuesitonId;
    int score;
    int requestCode = 1;
    boolean checkCheat = false;
    TextView question;
    Button answer0Button;
    Button answer1Button;
    Button answer2Button;
    ProgressBar progressBar;
    Button cheat;
    ArrayList<Question> questionArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionArrayList = new ArrayList<Question>();

        questionArrayList.add(new Question("1. Lesson 1 Trail begins with", "Select Views", "Style Views", "Position Views", 0));
        questionArrayList.add(new Question("2. View that doesn't exist", "EditView", "Button", "FigureView", 2));
        questionArrayList.add(new Question("3. Nonrequired attribute for TextView", "Layout_width", "Text", "Layout_height", 1));
        questionArrayList.add(new Question("4. Right syntax for XML single element", "<ElementName/>", "<ElementName\\>", "{ElementName;}", 0));
        questionArrayList.add(new Question("5. Nonexistent type of View Groups", "RelativeLayout", "LinearLayout", "ParentLayout", 2));
        questionArrayList.add(new Question("6. Property for expanding element's borders from inside", "Padding", "Margin", "Size", 0));
        questionArrayList.add(new Question("7. Conventional text in start project", "Hello", "GoodMorning", "HelloWord", 2));
        questionArrayList.add(new Question("8. Element in 'Code' which automatically fixes spacing and tabs", "Reformat Code", "Fix Code", "Select Code", 0));
        questionArrayList.add(new Question("9. Extension in folder 'manifests'", ".java", ".xml", ".mnf", 1));
        questionArrayList.add(new Question("10. Element ID syntax", "@+id/element_name", "id/element_name", "@_id/element_name", 0));
        questionArrayList.add(new Question("11. Proper variable declaration", "DataType  variableName = initialValue;", "VariableName initialValue = dataType;", "VariableName dataType = initialValue;", 0));
        questionArrayList.add(new Question("12. Element of debugging", "Stopbutton", "Breakpoint", "Endline", 1));

        init();

        answer0Button = (Button) findViewById(R.id.a0);
        answer1Button = (Button) findViewById(R.id.a1);
        answer2Button = (Button) findViewById(R.id.a2);
        answer0Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionArrayList.get(currentQuesitonId).getRightAnswer() == 0) {
                    score++;
                }
                UpdateAnswer();
            }
        });
        answer1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionArrayList.get(currentQuesitonId).getRightAnswer() == 1) {
                    score++;
                }
                UpdateAnswer();
            }
        });
        answer2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionArrayList.get(currentQuesitonId).getRightAnswer() == 2) {
                    score++;
                }
                UpdateAnswer();
            }
        });

        cheat = (Button) findViewById(R.id.cheat);
        cheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Question currentQuestion = questionArrayList.get(currentQuesitonId);
                checkCheat = true;

                int currentRightAnswer = currentQuestion.getRightAnswer();
                if (currentRightAnswer == 0) {
                    answer0Button.setBackgroundColor(ContextCompat.getColor(getBaseContext(), R.color.buttonCheat));
                }
                if (currentRightAnswer == 1) {
                    answer1Button.setBackgroundColor(ContextCompat.getColor(getBaseContext(), R.color.buttonCheat));
                }
                if (currentRightAnswer == 2) {
                    answer2Button.setBackgroundColor(ContextCompat.getColor(getBaseContext(), R.color.buttonCheat));
                }
            }
        });
    }

    private void init() {
        currentQuesitonId = -1;
        score = 0;
        checkCheat = false;
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        progressBar.setMax(questionArrayList.size());
        progressBar.setProgress(0);

        UpdateAnswer();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == this.requestCode && resultCode == RESULT_OK) {
            init();
        }
    }

    private void UpdateAnswer() {
        currentQuesitonId++;
        progressBar.incrementProgressBy(1);
        if (questionArrayList.size() <= currentQuesitonId)  {
            final Intent intent = new Intent(this, FinishActivity.class);
            intent.putExtra("score", score);
            intent.putExtra("total", questionArrayList.size());
            intent.putExtra("checkCheat", checkCheat);
            startActivityForResult(intent, requestCode);
        } else {
            question = (TextView) findViewById(R.id.textView);
            answer0Button = (Button) findViewById(R.id.a0);
            answer1Button = (Button) findViewById(R.id.a1);
            answer2Button = (Button) findViewById(R.id.a2);
            answer0Button.setBackgroundColor(ContextCompat.getColor(getBaseContext(), R.color.cancelCheat));
            answer1Button.setBackgroundColor(ContextCompat.getColor(getBaseContext(), R.color.cancelCheat));
            answer2Button.setBackgroundColor(ContextCompat.getColor(getBaseContext(), R.color.cancelCheat));
            Question q = questionArrayList.get(currentQuesitonId);
            question.setText(q.getQuestionText());
            answer0Button.setText(q.getAnswer1());
            answer1Button.setText(q.getAnswer2());
            answer2Button.setText(q.getAnswer3());
        }
    }
}
