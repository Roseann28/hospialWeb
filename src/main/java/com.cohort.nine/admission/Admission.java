package com.cohort.nine.admission;

import java.util.Date;

public class Admission {
    private int id;
    private int patientId;
    private String roomNumber;
    private Date dateOfAdmission;
    private Date presentDate;
    private String progress;

    public Admission(int id,int patientId, String roomNumber,Date dateOfAdmission, Date presentDate, String progress) {
        this.id = id;
        this.patientId=patientId;
        this.roomNumber = roomNumber;
        this.dateOfAdmission = dateOfAdmission;
        this.presentDate = presentDate;
        this.progress = progress;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(Date dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public Date getPresentDate() {
        return presentDate;
    }

    public void setPresentDate(Date presentDate) {
        this.presentDate = presentDate;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }
}
