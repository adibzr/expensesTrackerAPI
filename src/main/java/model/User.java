package model;

import exception.ExpenseNotFoundException;
import interfaces.ExpensesInterface;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;

public class User implements ExpensesInterface {
    private String name;
    private String email;
    private final List<Expense> expenses;

    public User(String name, String email){
        this.email = email;
        this.name = name;
        this.expenses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void removeExpense(int id) {
        try {
            boolean found = false;
            for (Expense expense : expenses) {
                if (expense.getId() == id) {
                    expenses.remove(expense);
                    System.out.println("Expense with ID " + id + " removed.");
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new ExpenseNotFoundException("Expense with ID " + id + " not found.");
            }
        } catch (ExpenseNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    public void updateExpense(int id, BigDecimal newAmount, Category newCategory, String newDescription) {
        try {
            boolean found = false;
            for (Expense expense : expenses) {
                if (expense.getId() == id) {
                    expense.setAmount(newAmount);
                    expense.setCategory(newCategory);
                    expense.setDescription(newDescription);
                    System.out.println("Expense with ID " + id + " updated.");
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new ExpenseNotFoundException("Expense with ID " + id + " not found.");
            }
        } catch (ExpenseNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }


    @Override
    public BigDecimal calculateTotalExpenses(List<Expense> expenses) {
        return expenses.stream()
                .map(Expense::getAmount)
                .reduce(BigDecimal.valueOf(0), BigDecimal::add);
    }

    @Override
    public List<Expense> filterByCategory(List<Expense> expenses, String category) {
        return expenses.stream().filter(expense -> Objects.equals(category.toLowerCase(), expense.getCategory().getName())).toList();
    }

    @Override
    public List<Expense> filterByDate(List<Expense> expenses, LocalDate date) {
        return null;
    }
}
