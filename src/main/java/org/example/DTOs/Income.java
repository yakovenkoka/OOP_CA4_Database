package org.example.DTOs;

public class Income {
    private int incomeID;
    private String title;
    private double amount;
    private String dateEarned;

    public Income(int incomeID, String title, double amount, String dateEarned) {
        this.incomeID = incomeID;
        this.title = title;
        this.amount = amount;
        this.dateEarned = dateEarned;
    }

    public Income(String title, double amount, String dateEarned) {
        this.incomeID = 0;
        this.title = title;
        this.amount = amount;
        this.dateEarned = dateEarned;
    }

    public Income() {}

    public int getIncomeID() {
        return incomeID;
    }

    public void setIncomeID(int incomeID) {
        this.incomeID = incomeID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDateEarned() {
        return dateEarned;
    }

    public void setDateEarned(String dateEarned) {
        this.dateEarned = dateEarned;
    }
}
