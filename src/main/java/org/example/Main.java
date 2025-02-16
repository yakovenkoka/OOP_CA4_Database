package org.example;

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
            Expense newExpense = new Expense("phone bill", "bills", 20.00, new Date());
            IFinanceTracker.addExpense(newExpense);

            IFinanceTracker.deleteExpense(1);

            List<Expense> expenses = IFinanceTracker.getAllExpenses();
            for(Expense expense : expenses){
                System.out.println("\n" + expense);
            }

            double totalExpenses = IFinanceTracker.calculateTotalExpenses();
            System.out.println("Total expenses: " + totalExpenses);

            Income newIncome = new Income("monthly salary", 1500.00, new Date());
            IFinanceTracker.addIncome(newIncome);

            IFinanceTracker.deleteIncome(1);

            List<Income> incomes = IFinanceTracker.getAllIncome();
            for(Income income : incomes){
                System.out.println("\n" + income);
            }

            double totalIncome = IFinanceTracker.calculateTotalIncome();
            System.out.println("Total expenses: " + totalIncome);

            IFinanceTracker.displayExpensesAndIncomeForMonth(2025, 2);

        } catch (DaoException e){
            e.printStackTrace();
        }
    }
}