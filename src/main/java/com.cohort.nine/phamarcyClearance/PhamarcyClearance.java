package com.cohort.nine.phamarcyClearance;

import com.cohort.nine.util.BillClearance;

import java.math.BigDecimal;

public class PhamarcyClearance{
    private int id;
    private String drugOrService;
    public int quantity;
    private BigDecimal price;
    private BillClearance clearedbill;


    public PhamarcyClearance(int id,String drugOrService, int quantity, BigDecimal price, BillClearance clearedbill) {
        this.drugOrService = drugOrService;
        this.quantity = quantity;
        this.price = price;
        this.clearedbill = clearedbill;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDrugOrService() {
        return drugOrService;
    }

    public void setDrugOrService(String drugOrService) {
        this.drugOrService = drugOrService;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BillClearance getClearedbill() {
        return clearedbill;
    }

    public void setClearedbill(BillClearance clearedbill) {
        this.clearedbill = clearedbill;
    }
}
