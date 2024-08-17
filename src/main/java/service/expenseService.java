package service;

import model.Expense;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class expenseService {
    /*
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
    */
}
