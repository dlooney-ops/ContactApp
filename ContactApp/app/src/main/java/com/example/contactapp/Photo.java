package com.example.contactapp;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.Instant;

public class Photo {

    private String idNumber;
    private String fileName;
    private Instant takenAt;
    private String info;

    public Photo(String idNumber, String fileName, Instant takenAt, String info) {
        this.idNumber = idNumber;
        this.fileName = fileName;
        this.takenAt = takenAt;
        this.info = info;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Photo(String idNumber, String fileName) {
        this.idNumber = idNumber;
        this.fileName = fileName;
        this.takenAt = Instant.now();
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getFileName() {
        return fileName;
    }

    public Instant getTakenAt() {
        return takenAt;
    }

    public String getInfo() {
        return info;
    }



}