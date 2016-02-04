package com.example.ww.myapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CalToExerciseActivity extends AppCompatActivity {

    EditText editNumCalories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_to_exercise);

        editNumCalories = (EditText) findViewById(R.id.edit_calorie_amt);
        editNumCalories.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                recalcAmt();
            }
        });
    }

    private void recalcAmt() {
        float amtCalories = Float.parseFloat(editNumCalories.getText().toString());

        TextView t;
        if (amtCalories > 0) {
            //update each exercise
            t = (TextView) findViewById(R.id.text_cycling_amt);
            t.setText(caloriesToExercise("Cycling", amtCalories) + "");

            t = (TextView) findViewById(R.id.text_jogging_amt);
            t.setText(caloriesToExercise("Jogging", amtCalories) + "");

            t = (TextView) findViewById(R.id.text_jumpingjacks_amt);
            t.setText(caloriesToExercise("Jumping Jacks", amtCalories) + "");

            t = (TextView) findViewById(R.id.text_leglifts_amt);
            t.setText(caloriesToExercise("Leg-Lifts", amtCalories) + "");

            t = (TextView) findViewById(R.id.text_plank_amt);
            t.setText(caloriesToExercise("Planking", amtCalories) + "");

            t = (TextView) findViewById(R.id.text_pullup_amt);
            t.setText(caloriesToExercise("Pullups", amtCalories) + "");

            t = (TextView) findViewById(R.id.text_pushup_amt);
            t.setText(caloriesToExercise("Pushups", amtCalories) + "");

            t = (TextView) findViewById(R.id.text_situp_amt);
            t.setText(caloriesToExercise("Situps", amtCalories) + "");

            t = (TextView) findViewById(R.id.text_squat_amt);
            t.setText(caloriesToExercise("Squats", amtCalories) + "");

            t = (TextView) findViewById(R.id.text_stairclimbing_amt);
            t.setText(caloriesToExercise("Stair-Climbing", amtCalories) + "");

            t = (TextView) findViewById(R.id.text_swimming_amt);
            t.setText(caloriesToExercise("Swimming", amtCalories) + "");

            t = (TextView) findViewById(R.id.text_walking_amt);
            t.setText(caloriesToExercise("Walking", amtCalories) + "");
        }
        else {
            t = (TextView) findViewById(R.id.text_cycling_amt);
            t.setText(0 + "");

            t = (TextView) findViewById(R.id.text_jogging_amt);
            t.setText(0 + "");

            t = (TextView) findViewById(R.id.text_jumpingjacks_amt);
            t.setText(0 + "");

            t = (TextView) findViewById(R.id.text_leglifts_amt);
            t.setText(0 + "");

            t = (TextView) findViewById(R.id.text_plank_amt);
            t.setText(0 + "");

            t = (TextView) findViewById(R.id.text_pullup_amt);
            t.setText(0 + "");

            t = (TextView) findViewById(R.id.text_pushup_amt);
            t.setText(0 + "");

            t = (TextView) findViewById(R.id.text_situp_amt);
            t.setText(0 + "");

            t = (TextView) findViewById(R.id.text_squat_amt);
            t.setText(0 + "");

            t = (TextView) findViewById(R.id.text_stairclimbing_amt);
            t.setText(0 + "");

            t = (TextView) findViewById(R.id.text_swimming_amt);
            t.setText(0 + "");

            t = (TextView) findViewById(R.id.text_walking_amt);
            t.setText(0 + "");
        }
    }

    private float caloriesToExercise(String s, float amtCalories) {
        float f = getAmtPerHundred(s);
        return f * amtCalories / 100;
    }

    private float getAmtPerHundred(String s) {
        switch (s) {
            case "Pushups":
                return 350;
            case "Situps":
                return 200;
            case "Squats":
                return 225;
            case "Leg-Lifts":
                return 25;
            case "Planking":
                return 25;
            case "Jumping Jacks":
                return 10;
            case "Pullups":
                return 100;
            case "Cycling":
                return 12;
            case "Walking":
                return 20;
            case "Jogging":
                return 12;
            case "Swimming":
                return 13;
            case "Stair-Climbing":
                return 15;
            default:
                return 0;
        }
    }

    public void gotoCaloriesToExercise(View currentView) {

    }

    public void gotoExerciseToCalories(View currentView) {
        Intent myIntent = new Intent(CalToExerciseActivity.this, MainActivity.class);
        CalToExerciseActivity.this.startActivity(myIntent);
    }
}
