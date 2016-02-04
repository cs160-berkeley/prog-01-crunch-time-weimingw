package com.example.ww.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText amtEditText;
    private Spinner spinnerExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amtEditText = (EditText) findViewById(R.id.edit_reps);
        spinnerExercise = (Spinner) findViewById(R.id.exercise_spinner);

        amtEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (amtEditText.getText().length() == 0) {
                    return;
                }
                recalcCalories();
            }
        });

        spinnerExercise.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateUnits();
                recalcCalories();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void gotoCaloriesToExercise(View currentView) {
        Intent myIntent = new Intent(MainActivity.this, CalToExerciseActivity.class);
        MainActivity.this.startActivity(myIntent);
    }

    public void gotoExerciseToCalories(View currentView) {

    }

    private void recalcCalories() {
        String s = spinnerExercise.getSelectedItem().toString();
        if (amtEditText.getText().length() > 0) {
            float amtExercise = Float.parseFloat(amtEditText.getText().toString());

            TextView t;

            //update top text
            t = (TextView) findViewById(R.id.text_calories_amt);
            float amtCalories = exerciseToCalories(s, amtExercise);
            t.setText(amtCalories + "");

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
            TextView t = (TextView) findViewById(R.id.text_calories_amt);
            t.setText(0 + "");

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

    private float exerciseToCalories(String s, float amtExercise) {
        float f = getAmtPerHundred(s);
        return amtExercise / f * 100;
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

    private void updateUnits() {
        String s = spinnerExercise.getSelectedItem().toString();
        TextView t = (TextView) findViewById(R.id.text_units);
        if (s.equals("Pushups") || s.equals("Situps") || s.equals("Squats") || s.equals("Pullups")) {
            t.setText("Reps Of");
        }
        else {
            t.setText("Minutes Of");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
