package model;
import java.math.BigDecimal;


public class Expense {
    private final int id;
    private BigDecimal amount;
    private Category category;
    private String description;
    private static int counter = 0;

    // Constructor
    public Expense(BigDecimal amount, Category category, String description) {
        this.id = ++counter;
        this.amount = amount;
        this.category = category;
        this.description = description;
    }
    // Getters
    public int getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public Category getCategory() {
        return this.category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
