package com.cohort.nine.ailment;

public class Ailment {
    private int id;
    private int patientId;
    private String ailment;
    private String medicine;
    private String test;
    private String admitted;

    public Ailment(int id,int patientId,String ailment, String medicine,  String test, String admitted) {
        this.ailment = ailment;
        this.medicine = medicine;
        this.id = id;
        this.test = test;
        this.admitted = admitted;
        this.patientId=patientId;

    }


    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getAdmitted() {
        return admitted;
    }

    public void setAdmitted(String admitted) {
        this.admitted = admitted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAilment() {
        return ailment;
    }

    public void setAilment(String ailment) {
        this.ailment = ailment;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }
}
