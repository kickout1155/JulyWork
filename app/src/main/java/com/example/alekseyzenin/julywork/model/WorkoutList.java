package com.example.alekseyzenin.julywork.model;

import android.content.Context;

import com.example.alekseyzenin.julywork.R;

import java.util.ArrayList;
import java.util.List;

public class WorkoutList {
    private static List<Workout> workouts = new ArrayList<>();
    private Context context;
    private static WorkoutList ourInstance;

    public static WorkoutList getInstance(Context context) {
        if (ourInstance != null){
            return ourInstance;
        }
        ourInstance = new WorkoutList(context);
        return ourInstance;
    }

    private WorkoutList(Context context) {
        initMockList(context);
    }

    private void initMockList(Context context) {
        workouts = new ArrayList<>();
        Workout workoutPullUp = new Workout(context.getString(R.string.pull_up_title), context.getString(R.string.pull_up_description),
                context.getString(R.string.difficult_easy),0, 0);
        Workout workoutPushUp = new Workout(context.getString(R.string.push_up_title), context.getString(R.string.push_up_description),
                context.getString(R.string.difficult_easy),0, 0);
        Workout workoutSquats = new Workout(context.getString(R.string.squats_title), context.getString(R.string.squats_description),
                context.getString(R.string.difficult_easy),0, 0);

        workouts.add(workoutPullUp);
        workouts.add(workoutPushUp);
        workouts.add(workoutSquats);
    }

    public static Workout getWorkout(int index){
        return workouts.get(index);
    }

    public static List<Workout> getAllWorkouts(){
        return workouts;
    }

    public static void setWorkout(int index, Workout workout){
        workouts.set(index,workout);
    }














}
