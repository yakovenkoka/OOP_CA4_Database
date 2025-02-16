package org.example.DAOs;

import org.example.DTOs.Expense;
import org.example.DTOs.Income;
import org.example.Exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MySqlFinanceTrackerDao extends MySqlDao implements FinanceTrackerDaoInterface {
    //Retrieve all expenses from the database
    @Override
    public List<Expense> getAllExpenses() throws DaoException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Expense> expensesList = new ArrayList<>();

        try{
            connection = this.getConnection();

            String query = "SELECT * FROM expenses";
            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int expenseID = resultSet.getInt("expenseID");
                String title = resultSet.getString("title");
                String category = resultSet.getString("category");
                double amount = resultSet.getDouble("amount");
                Date dateIncurred = resultSet.getDate("dateIncurred");

                Expense expense = new Expense(expenseID, title, category, amount, dateIncurred);
                expensesList.add(expense);
            } 
        } catch (Exception e){
            throw new DaoException("getAllExpenses() " + e.getMessage());
        } finally {
            try{
                if(resultSet != null){
                    resultSet.close();
                }
                if(preparedStatement != null){
                    preparedStatement.close();
                }
                if(connection != null){
                    connection.close();
                }
            } catch (Exception e){
                throw new DaoException("getAllExpenses() " + e.getMessage());
            }
        }
        return expensesList;
    }

    //Add a new expense to the database
    @Override
    public Expense addExpense(Expense expense) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = this.getConnection();

            String query = "INSERT INTO expenses VALUES(?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, expense.getExpenseID());
            preparedStatement.setString(2, expense.getTitle());
            preparedStatement.setString(3, expense.getCategory());
            preparedStatement.setDouble(4, expense.getAmount());
            preparedStatement.setDate(5, new java.sql.Date(expense.getDateIncurred().getTime()));

            preparedStatement.executeUpdate();
            System.out.println("Expense added successfully");
        } catch (Exception e) {
            throw new DaoException("addExpense() " + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                throw new DaoException("addExpense() " + e.getMessage());
            }
        }
        return expense;
    }

    //Delete an expense by its ID
    @Override
    public boolean deleteExpense(int expenseID) throws DaoException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = this.getConnection();
            String query = "DELETE FROM expenses WHERE expenseID = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,expenseID);

            boolean res = preparedStatement.executeUpdate() > 0;
            if(res == true){
                System.out.println("Expense deleted successfully");
            }else{
                System.out.println("Expense deletion failed");
            }
            return res;
        }
        catch (Exception e){
            throw new DaoException("deleteExpense() " + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                throw new DaoException("deleteExpense() " + e.getMessage());
            }
        }
    }

    //Calculate the total sum of all expenses
    @Override
    public double calculateTotalExpenses() throws DaoException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        double total = 0.0;

        try{
            connection = this.getConnection();

            String query = "SELECT SUM(amount) FROM expenses";
            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                total = resultSet.getDouble(1);
            }
        } catch (Exception e){
            throw new DaoException("calculateTotalExpenses() " + e.getMessage());
        } finally {
            try{
                if(resultSet != null){
                    resultSet.close();
                }
                if(preparedStatement != null){
                    preparedStatement.close();
                }
                if(connection != null){
                    connection.close();
                }
            } catch (Exception e){
                throw new DaoException("calculateTotalExpenses() " + e.getMessage());
            }
        }
        return total;
    }

    //Retrieve all income from the database
    @Override
    public List<Income> getAllIncome() throws DaoException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Income> incomeList = new ArrayList<>();

        try{
            connection = this.getConnection();

            String query = "SELECT * FROM income";
            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int incomeID = resultSet.getInt("incomeID");
                String title = resultSet.getString("title");
                double amount = resultSet.getDouble("amount");
                Date dateEarned = resultSet.getDate("dateEarned");

                Income income = new Income(incomeID, title, amount, dateEarned);
                incomeList.add(income);
            }
        } catch (Exception e){
            throw new DaoException("getAllIncome() " + e.getMessage());
        } finally {
            try{
                if(resultSet != null){
                    resultSet.close();
                }
                if(preparedStatement != null){
                    preparedStatement.close();
                }
                if(connection != null){
                    connection.close();
                }
            } catch (Exception e){
                throw new DaoException("getAllIncome() " + e.getMessage());
            }
        }
        return incomeList;
    }

    //Add a new income to the database
    @Override
    public Income addIncome(Income income) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = this.getConnection();

            String query = "INSERT INTO income VALUES(?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, income.getIncomeID());
            preparedStatement.setString(2, income.getTitle());
            preparedStatement.setDouble(3, income.getAmount());
            preparedStatement.setDate(4, new java.sql.Date(income.getDateEarned().getTime()));

            preparedStatement.executeUpdate();
            System.out.println("Income added successfully");
        } catch (Exception e) {
            throw new DaoException("addIncome() " + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                throw new DaoException("addIncome() " + e.getMessage());
            }
        }
        return income;
    }

    //Delete an income by its ID
    @Override
    public boolean deleteIncome(int incomeID) throws DaoException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = this.getConnection();
            String query = "DELETE FROM income WHERE incomeID = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,incomeID);

            boolean res = preparedStatement.executeUpdate() > 0;
            if(res == true){
                System.out.println("Income deleted successfully");
            }else{
                System.out.println("Income deletion failed");
            }
            return res;
        }
        catch (Exception e){
            throw new DaoException("deleteIncome() " + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                throw new DaoException("deleteIncome() " + e.getMessage());
            }
        }
    }

    //Calculate the total sum of all income
    @Override
    public double calculateTotalIncome() throws DaoException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        double total = 0.0;

        try{
            connection = this.getConnection();

            String query = "SELECT SUM(amount) FROM income";
            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                total = resultSet.getDouble(1);
            }
        } catch (Exception e){
            throw new DaoException("calculateTotalIncome() " + e.getMessage());
        } finally {
            try{
                if(resultSet != null){
                    resultSet.close();
                }
                if(preparedStatement != null){
                    preparedStatement.close();
                }
                if(connection != null){
                    connection.close();
                }
            } catch (Exception e){
                throw new DaoException("calculateTotalIncome() " + e.getMessage());
            }
        }
        return total;
    }

    //Display all expenses and income for a specific month
    @Override
    public void displayExpensesAndIncomeForMonth(int year, int month) throws DaoException{
        Connection connection = null;
        PreparedStatement preparedStatementExpenses = null;
        PreparedStatement preparedStatementIncome = null;
        ResultSet resultSet = null;

        try{
            connection = this.getConnection();

            //Retrieve income for the month
            String query = "SELECT * FROM income WHERE YEAR (dateEarned) = ? AND MONTH (dateEarned) = ?";
            preparedStatementIncome = connection.prepareStatement(query);
            preparedStatementIncome.setInt(1,year);
            preparedStatementIncome.setInt(2,month);

            double monthIncome = 0.0;
            double monthExpenses = 0.0;

            resultSet = preparedStatementIncome.executeQuery();
            System.out.println("Income for month: ");

            while (resultSet.next()){
                int incomeID = resultSet.getInt("incomeID");
                String title = resultSet.getString("title");
                double amount = resultSet.getDouble("amount");
                Date dateEarned = resultSet.getDate("dateEarned");

                System.out.println("Income ID: " + incomeID + " Title: " + title + " Amount: " + amount + " DateEarned: " + dateEarned);
                monthIncome += amount;
            }
            resultSet.close();

            //Retrieve expenses for the month
            query = "SELECT * FROM expenses WHERE YEAR (dateIncurred) = ? AND MONTH (dateIncurred) = ?";
            preparedStatementExpenses = connection.prepareStatement(query);
            preparedStatementExpenses.setInt(1,year);
            preparedStatementExpenses.setInt(2,month);

            resultSet = preparedStatementExpenses.executeQuery();
            System.out.println("Expenses for month: ");

            while (resultSet.next()){
                int expenseID = resultSet.getInt("expenseID");
                String title = resultSet.getString("title");
                String category = resultSet.getString("category");
                double amount = resultSet.getDouble("amount");
                Date dateIncurred = resultSet.getDate("dateIncurred");

                System.out.println("Expense ID: " + expenseID + " Title: " + title + " Category" + category + " Amount: " + amount + " DateIncurred: " + dateIncurred);
                monthExpenses += amount;
            }
            System.out.println("\nTotal Expenses: " + monthExpenses);
            System.out.println("Total Income: " + monthIncome);
            double leftOver = monthIncome - monthExpenses;
            System.out.println("Left Over: " + leftOver);
        }
        catch (Exception e){
            throw new DaoException("displayExpensesAndIncomeForMonth() " + e.getMessage());
        } finally {
            try{
                if(resultSet != null){
                    resultSet.close();
                }
                if(preparedStatementExpenses != null){
                    preparedStatementExpenses.close();
                }
                if(preparedStatementIncome != null){
                    preparedStatementIncome.close();
                }
                if(connection != null){
                    connection.close();
                }
            } catch (Exception e){
                throw new DaoException("displayExpensesAndIncomeForMonth() " + e.getMessage());
            }
        }

    }
}
