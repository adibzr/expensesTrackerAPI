package interfaces;

import model.Category;
import model.Expense;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface ExpensesInterface {
    BigDecimal calculateTotalExpenses(List<Expense> expenses);

    List<Expense> filterByCategory(List<Expense> expenses, String category);

    List<Expense> filterByDate(List<Expense> expenses, LocalDate date);
}
