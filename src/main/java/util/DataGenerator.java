package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataGenerator{
    public static void generateTables(){
        String createTable = "src/main/resources/tables.sql";
        String url = "jdbc:h2:~/expensesTracker";
        String userName = "username";
        String password = "password";
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            executeSqlScript(connection, createTable);
            //executeSqlScript(connection, createUsersFile);
            System.out.println("Usuarios generados.");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
    private static void executeSqlScript(Connection connection, String filePath) throws IOException, SQLException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
             Statement statement = connection.createStatement()) {

            String line;
            StringBuilder sql = new StringBuilder();

            while ((line = br.readLine()) != null) {
                sql.append(line).append("\n");
                if (line.trim().endsWith(";")) {
                    statement.execute(sql.toString());
                    sql.setLength(0);
                }
            }

            if (sql.length() > 0) {
                statement.execute(sql.toString());
            }
        }
    }
}
