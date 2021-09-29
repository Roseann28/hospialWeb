package com.cohort.nine.tests;

public class Tests {
    private String testName;
    private String finding;
    private int id;
    private int patientId;

    public Tests(int id,int patientId, String testName, String finding) {
        this.testName = testName;
        this.finding = finding;
        this.id=id;
        this.patientId=patientId;
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

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getFinding() {
        return finding;
    }

    public void setFinding(String finding) {
        this.finding = finding;
    }
}
