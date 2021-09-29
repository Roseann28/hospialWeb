package com.cohort.nine.Finance;

import java.io.Serializable;
import java.math.BigDecimal;

public class Finances implements Serializable {
    private int patientId;
    private String service;
    private int quantity;
    private BigDecimal fee;
    private BigDecimal totalfee;

    public Finances(){

    }
    public Finances( String service,int quantity, BigDecimal fee) {
        this.quantity = quantity;
        this.fee = fee;
        this.service=service;
    }

    public Finances(int patientId, String service,int quantity, BigDecimal fee) {
        this.patientId = patientId;
        this.quantity = quantity;
        this.fee = fee;
        this.service=service;
    }

    public BigDecimal getTotalfee() {
        return totalfee;
    }

    public void setTotalfee(BigDecimal totalfee) {
        this.totalfee = totalfee;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }
}
