package com.example.alekseyzenin.julywork.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Workout {
    private int repeatsCount;
    private String title;
    private String difficult;
    private long executingTime;
    private String descriptions;
    private int lastRecordRepeats;
    private Date lastRecordDate;
    private int imageResRef;
    private int index;
    private int idSrc;

    public Workout(int repeatsCount, String title, String difficult, long executingTime,
                   String descriptions, int lastRecordRepeats, Date lastRecordDate, int imageResRef) {
        this.repeatsCount = repeatsCount;
        this.title = title;
        this.difficult = difficult;
        this.executingTime = executingTime;
        this.descriptions = descriptions;
        this.lastRecordRepeats = lastRecordRepeats;
        this.lastRecordDate = lastRecordDate;
        this.imageResRef = imageResRef;
    }
    public Workout(String title, String descriptions, String difficult, int repeatsCount,
                   long executingTime) {
        this.repeatsCount = repeatsCount;
        this.title = title;
        this.difficult = difficult;
        this.executingTime = executingTime;
        this.descriptions = descriptions;
        this.lastRecordRepeats = lastRecordRepeats;
        this.lastRecordDate = lastRecordDate;
        this.imageResRef = imageResRef;
    }

    public int getRepeatsCount() {
        return repeatsCount;
    }

    public void setRepeatsCount(int repeatsCount) {
        this.repeatsCount = repeatsCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDifficult() {
        return difficult;
    }

    public void setDifficult(String difficult) {
        this.difficult = difficult;
    }

    public long getExecutingTime() {
        return executingTime;
    }

    public void setExecutingTime(long executingTime) {
        this.executingTime = executingTime;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public int getLastRecordRepeats() {
        return lastRecordRepeats;
    }

    public void setLastRecordRepeats(int lastRecordRepeats) {
        this.lastRecordRepeats = lastRecordRepeats;
    }

    public Date getLastRecordDate() {
        return lastRecordDate;
    }

    public void setLastRecordDate(Date lastRecordDate) {
        this.lastRecordDate = lastRecordDate;
    }

    public int getImageResRef() {
        return imageResRef;
    }

    public void setImageResRef(int imageResRef) {
        this.imageResRef = imageResRef;
    }

    public String getStringRecord(boolean insertTitle){
        SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
        if (insertTitle){
            return title + " "+formatDate.format(lastRecordDate) + " количество повторов "+lastRecordRepeats;
        } else{
            return formatDate.format(lastRecordDate) + " количество повторов "+lastRecordRepeats;
        }
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIdSrc() {
        return idSrc;
    }

    public void setIdSrc(int idSrc) {
        this.idSrc = idSrc;
    }
}
