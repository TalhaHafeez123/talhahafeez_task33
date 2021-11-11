package com.example.task3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    private TextView noq, questions;
    private Button option1Btn, option2Btn, option3Btn, option4Btn;
    private ArrayList<Quiz> quizArrayList;
    Random random;
    int currentScore = 0, questionAttempted = 1, currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        noq = findViewById(R.id.noq);
        questions = findViewById(R.id.questions);
        option1Btn = findViewById(R.id.button1);
        option2Btn = findViewById(R.id.button2);
        option3Btn = findViewById(R.id.button3);
        option4Btn = findViewById(R.id.button4);
        quizArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestion(quizArrayList);
        currentPos = random.nextInt(quizArrayList.size());

        setQuizQuestion(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase()))

                {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizArrayList.size());
                setQuizQuestion(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase()))

                {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizArrayList.size());
                setQuizQuestion(currentPos);
            }
        });
        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase()))

                {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizArrayList.size());
                setQuizQuestion(currentPos);
            }
        });
        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase()))

                {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizArrayList.size());

                setQuizQuestion(currentPos);
            }
        });
    }
    private void  showBottomSheet(){
        setContentView(R.layout.score_bottom_sheet);
        TextView text = findViewById(R.id.textView2);
        text.setText("Your score is \n"+currentScore + "/10");
        Button button1, button2;
        button1= findViewById(R.id.Share);
        button2= findViewById(R.id.main);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(Intent.ACTION_SEND);
                I.setType("text/plain");
                String sharebody = "my score is "+currentScore+ "/10";
                String subject = "your body here";
                I.putExtra(Intent.EXTRA_SUBJECT,subject);
                I.putExtra(Intent.EXTRA_TEXT,sharebody);
                startActivity(Intent.createChooser(I,"Share using"));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void getQuizQuestion (ArrayList < Quiz > quizArrayList) {
        quizArrayList.add(new Quiz("By speaking أ ہ the sound produced from", "end of throat", "middle of throat", "start of throat", "Base of Tongue which is near Uvula touching the mouth roof", "end of throat"));
        quizArrayList.add(new Quiz("By speaking ع ح the sound produced from", "end of throat", "middle of throat", "start of throat", "Base of Tongue which is near Uvula touching the mouth roof", "middle of throat"));
        quizArrayList.add(new Quiz("By speaking غ خ the sound produced from", "end of throat", "middle of throat", "start of throat", "Base of Tongue which is near Uvula touching the mouth roof", "start of throat"));
        quizArrayList.add(new Quiz("By speaking ق the sound produced from", "end of throat", "middle of throat", "start of throat", "Base of Tongue which is near Uvula touching the mouth roof", "Base of Tongue which is near Uvula touching the mouth roof"));
        quizArrayList.add(new Quiz("By speaking ک the sound produced from", "Portion of Tongue near its base touching the roof of mouth", "middle of throat", "start of throat", "Base of Tongue which is near Uvula touching the mouth roof", "Portion of Tongue near its base touching the roof of mouth"));
        quizArrayList.add(new Quiz("By speaking ج ش ی the sound produced from", "end of throat", "middle of throat", "start of throat", "Tongue touching the center of the mouth roof", "Tongue touching the center of the mouth roof"));
        quizArrayList.add(new Quiz("By speaking ض the sound produced from", "end of throat", "middle of throat", "start of throat", "One side of the tongue touching the molar teeth", "One side of the tongue touching the molar teeth"));
        quizArrayList.add(new Quiz("By speaking ل the sound produced from", "end of throat", "middle of throat", "start of throat", "Rounded tip of the tongue touching the base of the frontal 8 teeth", "Rounded tip of the tongue touching the base of the frontal 8 teeth"));
        quizArrayList.add(new Quiz("By speaking ن the sound produced from", "end of throat", "middle of throat", "start of throat", "Rounded tip of the tongue touching the base of the frontal 6 teeth", "Rounded tip of the tongue touching the base of the frontal 6 teeth"));
        quizArrayList.add(new Quiz("By speaking ت د ط the sound produced from", "end of throat", "middle of throat", "start of throat", "Tip of the tongue touching the base of the front 2 teeth", "Tip of the tongue touching the base of the front 2 teeth"));
    }
    private void setQuizQuestion ( int currentPos){
        noq.setText("Questions attempted: " + questionAttempted + "/10");
        if(questionAttempted==10){
            showBottomSheet();
        }
        else {
            questions.setText(quizArrayList.get(currentPos).getQuestion());
            option1Btn.setText(quizArrayList.get(currentPos).getButton1());
            option2Btn.setText(quizArrayList.get(currentPos).getButton2());
            option3Btn.setText(quizArrayList.get(currentPos).getButton3());
            option4Btn.setText(quizArrayList.get(currentPos).getButton4());
        }
    }
}