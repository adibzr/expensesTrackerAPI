package repository;

import configuration.DatabaseConnection;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExpensesDAO implements DatabaseConnection {
    private PreparedStatement addExpensePS = null;
    public Boolean addExpense(BigDecimal amount, String description, Integer categoryId, Integer userId) {
    String sql = "INSERT INTO Expense (amount, description, category_id, user_id) VALUES (?, ?, ?, ?)";

        try {
            addExpensePS = DriverManager().prepareStatement(sql);
            addExpensePS.setBigDecimal(1, amount);
            addExpensePS.setString(2, description);
            if (categoryId != null) {
                addExpensePS.setInt(3, categoryId);
            } else {
                addExpensePS.setNull(3, java.sql.Types.INTEGER);
            }
            addExpensePS.setInt(4, userId);

            int rowsAffected = addExpensePS.executeUpdate();
            if (rowsAffected > 0) {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    //getAllExpenses()
    //updateExpense()
    //deleteExpense();
}
