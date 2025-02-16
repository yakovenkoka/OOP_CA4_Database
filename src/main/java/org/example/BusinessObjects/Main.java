package org.example.BusinessObjects;

import org.example.DAOs.FinanceTrackerDaoInterface;
import org.example.DAOs.MySqlFinanceTrackerDao;
import org.example.DTOs.Expense;
import org.example.DTOs.Income;
import org.example.Exceptions.DaoException;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FinanceTrackerDaoInterface IFinanceTracker = new MySqlFinanceTrackerDao();

        try{
            //Add a new expense
            System.out.println("\n----Call addExpense()----");
            Expense newExpense = new Expense("phone bill", "bills", 20.00, new Date());
            IFinanceTracker.addExpense(newExpense);

            //Delete an expense by id
            System.out.println("\n----Call deleteExpense()-----");
            IFinanceTracker.deleteExpense(1);

            //Get all expenses
            System.out.println("\n----Call getAllExpenses()----\n");
            List<Expense> expenses = IFinanceTracker.getAllExpenses();
            for(Expense expense : expenses){
                System.out.println(expense);
            }

            // Calculate total expenses
            System.out.println("\n----Call calculateTotalExpenses()----");
            double totalExpenses = IFinanceTracker.calculateTotalExpenses();
            System.out.println("Total expenses: " + totalExpenses);

            //Add a new income
            System.out.println("\n----Call addIncome()----");
            Income newIncome = new Income("monthly salary", 1500.00, new Date());
            IFinanceTracker.addIncome(newIncome);

            //Delete an income by id
            System.out.println("\n----Call deleteIncome()----");
            IFinanceTracker.deleteIncome(1);

            //Get all income
            System.out.println("\n----Call getAllIncome()----\n");
            List<Income> incomes = IFinanceTracker.getAllIncome();
            for(Income income : incomes){
                System.out.println(income);
            }

            // Calculate total income
            System.out.println("\n----Call calculateTotalIncome()-----");
            double totalIncome = IFinanceTracker.calculateTotalIncome();
            System.out.println("Total expenses: " + totalIncome);

            // Display expenses and income for a specific month
            System.out.println("\n-----Call displayExpensesAndIncomeForMonth()----");
            IFinanceTracker.displayExpensesAndIncomeForMonth(2025, 2);

        } catch (DaoException e){
            e.printStackTrace();
        }
    }
}