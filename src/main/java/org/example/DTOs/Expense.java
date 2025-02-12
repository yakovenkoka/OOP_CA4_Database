package org.example.DTOs;

public class Expense {

    private int expenseID;
    private String title;
    private String category;
    private double amount;
    private String dateIncurred;

    public Expense(int expenseID, String title, String category, double amount, String dateIncurred) {
        this.expenseID = expenseID;
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.dateIncurred = dateIncurred;
    }
    public Expense(String title, String category, double amount, String dateIncurred) {
        this.expenseID = 0;
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.dateIncurred = dateIncurred;
    }

    public Expense() {}

    public int getExpenseID() {
        return expenseID;
    }

    public void setExpenseID(int expenseID) {
        this.expenseID = expenseID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDateIncurred() {
        return dateIncurred;
    }

    public void setDateIncurred(String dateIncurred) {
        this.dateIncurred = dateIncurred;
    }


}

