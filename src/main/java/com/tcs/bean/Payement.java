package com.tcs.bean;

public class Payement {
    private int studentId;
    private String referenceId;
    private double amount;
    private boolean status;

    public Payement() {
		super();
		// TODO Auto-generated constructor stub
	}

    public Payement(int studentId, String referenceId, double amount, boolean status) {
        this.studentId = studentId;
        this.referenceId = referenceId;
        this.amount = amount;
        this.status = status;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
