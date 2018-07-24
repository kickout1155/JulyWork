package com.example.alekseyzenin.julywork;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.alekseyzenin.julywork.model.Workout;
import com.example.alekseyzenin.julywork.utils.Constants;

import java.util.List;


public class WorkoutListActivity extends AppCompatActivity {
    List<Workout> workoutList;
    Button exercise1;
    Button exercise2;
    Button exercise3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_list);
        exercise1 = findViewById(R.id.exercise1);
        exercise1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startDetailActivity = new Intent(WorkoutListActivity.this,WorkoutDetailActivity.class);
                startDetailActivity.putExtra(Constants.WORKOUT_INDEX,0);
                startDetailActivity.putExtra(Constants.WORKOUT_ID_CAPTURE,R.mipmap.pull_up_capture);
                startActivity(startDetailActivity);
            }
        });

        exercise2 = findViewById(R.id.exercise2);
        exercise2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startDetailActivity = new Intent(WorkoutListActivity.this,WorkoutDetailActivity.class);
                startDetailActivity.putExtra(Constants.WORKOUT_INDEX,1);
                startDetailActivity.putExtra(Constants.WORKOUT_ID_CAPTURE,R.mipmap.push_up_capture);
                startActivity(startDetailActivity);
            }
        });

        exercise3 = findViewById(R.id.exercise3);
        exercise3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startDetailActivity = new Intent(WorkoutListActivity.this,WorkoutDetailActivity.class);
                startDetailActivity.putExtra(Constants.WORKOUT_INDEX,2);
                startDetailActivity.putExtra(Constants.WORKOUT_ID_CAPTURE,R.mipmap.squats_capture);
                startActivity(startDetailActivity);
            }
        });
    }
}
