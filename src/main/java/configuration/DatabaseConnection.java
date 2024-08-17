package configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface DatabaseConnection {
    default Connection DriverManager (){
        String url = "jdbc:h2:~/expensesTracker";
        String userName = "username";
        String password = "password";
        Connection connection = null;

        try {
            Class.forName("org.hw.Driver");
            connection = DriverManager.getConnection(url, userName, password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
