package demo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BatchUpdateSqlInjection {

    public static final String DATABASE_URL = "jdbc:sqlite:M:\\sqlite\\Chinook_Sqlite.sqlite";

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(DATABASE_URL);

        Scanner input = new Scanner(System.in);

        System.out.print("Insert artist id: ");
        long id = Integer.parseInt(input.nextLine());

        System.out.println("Please enter a new name: ");
        String name = input.nextLine();

        // Warning: IT IS NOT SAFE TO CONCATENATE STRINGS INTO AN SQL STATEMENT:
        PreparedStatement statement = connection
                .prepareStatement("UPDATE Artist SET Name = '" + name + "' WHERE ArtistId = " + id);

        statement.executeUpdate();

        System.out.println("Done!");

        input.close();
        statement.close();
        connection.close();

    }
}