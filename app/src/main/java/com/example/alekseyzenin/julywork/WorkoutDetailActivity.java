package com.example.alekseyzenin.julywork;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alekseyzenin.julywork.model.Workout;
import com.example.alekseyzenin.julywork.model.WorkoutList;
import com.example.alekseyzenin.julywork.utils.Constants;
import com.example.alekseyzenin.julywork.utils.SQLdb;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WorkoutDetailActivity extends AppCompatActivity {
    private TextView title;
    private TextView description;
    private TextView repsCount;
    private TextView difficult;
    private TextView records;
    private ImageView popupMenu;
    private ImageView imageView;
    private SeekBar repeatSeekBar;
    private Workout workout;
    private SharedPreferences settings;
    final String REPEAT_RECORD = "repeatRecord";
    final String DATE_RECORD = "dateRecord";
    private int workoutIndex;
    private int workoutIdSrc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        workoutIndex = intent.getIntExtra(Constants.WORKOUT_INDEX,0);
        workoutIdSrc = intent.getIntExtra(Constants.WORKOUT_ID_CAPTURE,R.mipmap.no_capture);
        iniUi();

    }

    private void iniUi() {

        workout = WorkoutList.getInstance(this).getWorkout(workoutIndex);
        records = findViewById(R.id.workout_detail_records);
        title = findViewById(R.id.workout_detail_title);
        title.setText(workout.getTitle());
        description = findViewById(R.id.workout_detail_description);
        description.setText(workout.getDescriptions());
        repsCount = findViewById(R.id.workout_detail_repeats_count);
        repsCount.setText(String.valueOf(workout.getRepeatsCount()));
        difficult = findViewById(R.id.workout_detail_difficult);
        difficult.setText(workout.getDifficult());
        imageView = findViewById(R.id.workout_detail_image);
        imageView.setImageResource(workoutIdSrc);
        repeatSeekBar = findViewById(R.id.workout_detail_seekbar);
        repeatSeekBar.setProgress(workout.getRepeatsCount());
        repeatSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                repsCount.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        try {
            SQLdb.loadRecords(workout);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        popupMenu = findViewById(R.id.workout_detail_popup_menu);
        popupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopUpMenu(v);
            }
        });


    }

    private void showPopUpMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.inflate(R.menu.workout_detail_popup_menu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.workout_detail_popup_save: {
                        if (getTrueRecord(Integer.parseInt(String.valueOf(repsCount.getText())))) {

                            //workout.setLastRecordRepeats(Integer.parseInt(String.valueOf(repsCount.getText())));
                            SQLdb.saveRecords(workout.getTitle(),Integer.parseInt(String.valueOf(repsCount.getText())));
                                    //---
                            records.setText(workout.getStringRecord(false));
                            Toast.makeText(WorkoutDetailActivity.this, "Рекорд сохранен", Toast.LENGTH_SHORT).show();
                            return true;
                        } else {
                            Toast.makeText(WorkoutDetailActivity.this, "Рекорд не сохранен т.к. он меньше предыдущего", Toast.LENGTH_LONG).show();
                        }
                    }
                    case R.id.workout_detail_popup_share:{
                        Intent sendIntent = new Intent();
                        sendIntent.setAction(Intent.ACTION_SEND);
                        sendIntent.putExtra(Intent.EXTRA_TEXT, workout.getStringRecord(true));
                        sendIntent.setType("text/plain");
                        startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.share)));                    }
                    default:
                        return false;
                }
            }
        });
        popupMenu.show();
    }

    private boolean getTrueRecord(int repeats) {
        return workout.getLastRecordRepeats() < repeats && repeats != 0;

    }

    private void loadSettings(Workout workout) {
//        settings = getPreferences(MODE_PRIVATE);
//        int repeatRecord = Integer.parseInt(settings.getString(String.valueOf(workoutIndex )+ REPEAT_RECORD, "0"));
//        String dateRecord = settings.getString(String.valueOf(workoutIndex ) + DATE_RECORD, "01-01-0001");
//        SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
//        workout.setIndex(workoutIndex);
//        try {
//            workout.setLastRecordDate(formatDate.parse(dateRecord));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        workout.setLastRecordRepeats(repeatRecord);
//        if (repeatRecord!=0){
//            records.setText(workout.getStringRecord(false));
//        }



    }

    private void saveRecords(String str) {



    }
}
