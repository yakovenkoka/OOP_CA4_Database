package org.example.DAOs;

import org.example.DTOs.Expense;
import org.example.Exceptions.DaoException;

import java.util.List;

public interface ExpenseDaoInterface {
    List<Expense> getAllExpenses() throws DaoException;

}
