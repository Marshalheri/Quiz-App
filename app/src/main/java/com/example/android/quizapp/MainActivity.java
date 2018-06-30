package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //declaration of answers to question radio button id....
    final int Question2 = R.id.Q2_answer_d;
    final int Question3 = R.id.Q3_answer_b;
    final int Question6 = R.id.Q6_answer_c;
    final int Question7 = R.id.Q7_answer_b;
    final int Question8 = R.id.Q8_answer_b;
    final int Question9 = R.id.Q9_answer_a;
    final int Question10 = R.id.Q10_answer_d;
    final int Question4 = 64;
    final String Question5 = "Went";
    public int finalTestScore = 0;

    //declaration of Radio group property for the user gender selection...
    RadioGroup userGender;

    // this variables and class object will handle the user names inputs...
    String holdFullName = null;
    String collectFname;
    String collectLname;
    EditText Fname;
    EditText Lname;


    // this variable will hold the score result of the entire user selection from the methods that checks it...
    int collectScoreOfUser = 0;

    //this is the declaration for each view object name that handles the user answer from the activity.xml...
    RadioGroup question2RG;
    RadioGroup question3RG;
    EditText question4RG;
    EditText question5RG;
    RadioGroup question6RG;
    RadioGroup question7RG;
    RadioGroup question8RG;
    RadioGroup question9RG;
    RadioGroup question10RG;
    CheckBox question1ACheckbox;
    CheckBox question1BCheckbox;
    CheckBox question1CCheckbox;
    CheckBox question1DCheckbox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitTest(View view) {
        //this variable holds the full name of the user.
        String holdFullName = userFirstAndLastName();

        //this method holds the result for the gender selected by the user...
        int genderResult = genderRadioButton();

        //this variable collects the number of questions the user answered correctly..
        collectScoreOfUser = finalScoreOfUser();

        //this variable holds the point scored by the user as returned by the method...
        int collectTotalPoint = calculatePoint();

        if (holdFullName == null || holdFullName == " "){
            if (genderResult == 1) {
                Toast.makeText(MainActivity.this, "You Scored: " + collectTotalPoint + "points" + "\nYou are a male." + "\nYou did not enter a name.", Toast.LENGTH_LONG).show();
            } else if (genderResult == 2) {
                Toast.makeText(MainActivity.this, "You Scored: " + collectTotalPoint + "points" + "\nYou are a female." + "\nYou did not enter a name.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this, "You Scored: " + collectTotalPoint + "points" + "\nYou did not enter a name and gender.", Toast.LENGTH_LONG).show();
            }
        }
        else {
            if (genderResult == 1) {
                Toast.makeText(MainActivity.this, "You Scored: " + collectTotalPoint + "points" + "\n" + holdFullName + ", You are a male.", Toast.LENGTH_LONG).show();
            } else if (genderResult == 2) {
                Toast.makeText(MainActivity.this, "You Scored: " + collectTotalPoint + "points" + "\n" + holdFullName + ", You are a female.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this, "You Scored: " + collectTotalPoint + "points" + "\n" + holdFullName + ", You did not indicate your gender.", Toast.LENGTH_LONG).show();
            }
        }
        finalTestScore = 0;
    }


    //this method will reset the values of the score to zero
    public void resetScore(View view) {
        reset();
        Toast.makeText(MainActivity.this, "You have reseted the quiz app values to zero", Toast.LENGTH_LONG).show();
    }


    //this method will clear all the inputed parameters from the user when it is called.
    private void reset() {
        question1ACheckbox.setChecked(false);
        question1BCheckbox.setChecked(false);
        question1CCheckbox.setChecked(false);
        question1DCheckbox.setChecked(false);
        question2RG.clearCheck();
        question3RG.clearCheck();
        question4RG.getText().clear();
        question5RG.getText().clear();
        question6RG.clearCheck();
        question7RG.clearCheck();
        question8RG.clearCheck();
        question9RG.clearCheck();
        question10RG.clearCheck();
        userGender.clearCheck();
        Fname.getText().clear();
        Lname.getText().clear();
        finalTestScore = 0;
    }


    // this method controls the gender selection of the user.
    public int genderRadioButton() {
        userGender = findViewById(R.id.user_gender);
        int check = 0;


        //create object for the radio button class...
        RadioButton male = findViewById(R.id.male_user_gender);
        boolean isMaleChecked = male.isChecked();

        RadioButton female = findViewById(R.id.female_user_gender);
        boolean isFemaleChecked = male.isChecked();

        if (isMaleChecked == true) {
            check = 1;
        } else if (isFemaleChecked == true) {
            check = 2;
        } else {
            check = 3;
        }
        return check;
    }


    //this method gets the user first and last name.
    public String userFirstAndLastName() {
        Fname = findViewById(R.id.first_name_user);
        collectFname = Fname.getText().toString();

        Lname = findViewById(R.id.last_name_user);
        collectLname = Lname.getText().toString();

        return (collectFname + " " + collectLname);
    }


    //this method is responsible for handling question one...........

    public boolean questionOneMethod() {

        boolean checkedAnswers;

        question1ACheckbox = findViewById(R.id.Q1_answer_a);
        boolean isAnswerAChecked = question1ACheckbox.isChecked();

        question1BCheckbox = findViewById(R.id.Q1_answer_a);
        boolean isAnswerBChecked = question1BCheckbox.isChecked();

        question1CCheckbox = findViewById(R.id.Q1_answer_a);
        boolean isAnswerCChecked = question1CCheckbox.isChecked();

        question1DCheckbox = findViewById(R.id.Q1_answer_a);
        boolean isAnswerDChecked = question1DCheckbox.isChecked();

        if (isAnswerAChecked == true && isAnswerCChecked == true && isAnswerDChecked == true && !isAnswerBChecked == true){
            checkedAnswers = true;
        }
        else {
            checkedAnswers = false;
        }
            return checkedAnswers;
    }

    //this method is responsible for handling question two...........

    public boolean questionTwoMethod() {

        question2RG = findViewById(R.id.question2RGroup);

        return question2RG.getCheckedRadioButtonId() == Question2;

    }

    //this method is responsible for handling question three...........

    public boolean questionThreeMethod() {

        question3RG = findViewById(R.id.question3RGroup);

        return question3RG.getCheckedRadioButtonId() == Question3;

    }


    //this method is responsible for handling question four...........

    public boolean questionFourMethod() {

        question4RG = findViewById(R.id.question4Answer);
        String collectQuestion4AnswerString = question4RG.getText().toString();
        int collectQuestion4Answer;

        if (collectQuestion4AnswerString.equals(""))
            collectQuestion4Answer = 0;
        else
            collectQuestion4Answer = Integer.parseInt(collectQuestion4AnswerString);


        return collectQuestion4Answer == Question4;

    }


    //this method is responsible for handling question five...........

    public boolean questionFiveMethod() {

        question5RG = findViewById(R.id.question5Answer);
        String collectQuestion5Answer = question5RG.getText().toString();

        return collectQuestion5Answer == Question5;

    }


    //this method is responsible for handling question sic...........

    public boolean questionSixMethod() {

        question6RG = findViewById(R.id.question6RGroup);

        return question6RG.getCheckedRadioButtonId() == Question6;

    }


    //this method is responsible for handling question seven...........

    public boolean questionSevenMethod() {

        question7RG = findViewById(R.id.question7RGroup);

        return question7RG.getCheckedRadioButtonId() == Question7;

    }


    //this method is responsible for handling question eight...........

    public boolean questionEightMethod() {

        question8RG = findViewById(R.id.question8RGroup);

        return question8RG.getCheckedRadioButtonId() == Question8;

    }


    //this method is responsible for handling question nine...........

    public boolean questionNineMethod() {

        question9RG = findViewById(R.id.question9RGroup);

        return question9RG.getCheckedRadioButtonId() == Question9;

    }


    //this method is responsible for handling question ten...........

    public boolean questionTenMethod() {

        question10RG = findViewById(R.id.question10RGroup);

        return question10RG.getCheckedRadioButtonId() == Question10;

    }

    //this method calculates the total score of the user.....
    public int finalScoreOfUser() {

        ArrayList<String> incorrectAnswers = new ArrayList<String>();

        boolean numberOneResultBool = questionOneMethod();
        boolean numberTwoResultBool = questionTwoMethod();
        boolean numberThreeResultBool = questionThreeMethod();
        boolean numberFourResultBool = questionFourMethod();
        boolean numberFiveResultBool = questionFiveMethod();
        boolean numberSixResultBool = questionSixMethod();
        boolean numberSevenResultBool = questionSevenMethod();
        boolean numberEightResultBool = questionEightMethod();
        boolean numberNineResultBool = questionNineMethod();
        boolean numberTenResultBool = questionTenMethod();


        if (numberOneResultBool == true) {
            finalTestScore++;
        } else {
            incorrectAnswers.add("Question1");
        }
        if (numberTwoResultBool == true) {
            finalTestScore++;
        } else {
            incorrectAnswers.add("Question2");
        }
        if (numberThreeResultBool == true) {
            finalTestScore++;
        } else {
            incorrectAnswers.add("Question3");
        }
        if (numberFourResultBool == true) {
            finalTestScore++;
        } else {
            incorrectAnswers.add("Question4");
        }
        if (numberFiveResultBool == true) {
            finalTestScore++;
        } else {
            incorrectAnswers.add("Question5");
        }
        if (numberSixResultBool == true) {
            finalTestScore++;
        } else {
            incorrectAnswers.add("Question6");
        }
        if (numberSevenResultBool == true) {
            finalTestScore++;
        } else {
            incorrectAnswers.add("Question7");
        }
        if (numberEightResultBool == true) {
            finalTestScore++;
        } else {
            incorrectAnswers.add("Question8");
        }
        if (numberNineResultBool == true) {
            finalTestScore++;
        } else {
            incorrectAnswers.add("Question9");
        }
        if (numberTenResultBool == true) {
            finalTestScore++;
        } else {
            incorrectAnswers.add("Question10");
        }

        StringBuilder listOfFailedQuestions = new StringBuilder();
        for (String holdFailedQuestions : incorrectAnswers){
            listOfFailedQuestions.append("\n");
            listOfFailedQuestions.append(holdFailedQuestions);
        }

        Toast.makeText(MainActivity.this, "You answered " + finalTestScore + "/10 correctly." + "\nPlease check questions: " +
                listOfFailedQuestions, Toast.LENGTH_LONG).show();
        return finalTestScore;
    }


    //this method calculates the point of the user for the test.
    public int calculatePoint() {
        int totalPoint = collectScoreOfUser * 3;
        return totalPoint;
    }

    @Override
    public void onClick(View view) {

    }
}
