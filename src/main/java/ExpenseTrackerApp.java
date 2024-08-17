import repository.ExpensesDAO;

import java.math.BigDecimal;
import util.DataGenerator;
public class ExpenseTrackerApp {
    public static void main(String[] args) {
        DataGenerator.generateTables();

        //User user = new User("user", "test@test.com");
        ExpensesDAO expensesDAO = new ExpensesDAO();
        BigDecimal amount = new BigDecimal("10.00");
        //Category category = new Category("shopping", "expense description");


        //expensesDAO.addExpense(amount, "una descripcion de un gasto", 1,1);


    }
};