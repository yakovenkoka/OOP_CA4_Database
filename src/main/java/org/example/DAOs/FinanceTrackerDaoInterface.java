package org.example.DAOs;

import org.example.DTOs.Expense;
import org.example.DTOs.Income;
import org.example.Exceptions.DaoException;

import java.util.List;

public interface FinanceTrackerDaoInterface {
    public List<Expense> getAllExpenses() throws DaoException;
    public Expense addExpense(Expense expense) throws DaoException;
    public boolean deleteExpense(int expenseID) throws DaoException;

    public List<Income> getAllIncome() throws DaoException;
    public Income addIncome(Income income) throws DaoException;
    public boolean deleteIncome(int incomeID) throws DaoException;
}
