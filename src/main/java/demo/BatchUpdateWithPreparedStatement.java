package demo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BatchUpdateWithPreparedStatement {

    public static final String DATABASE_URL = "jdbc:sqlite:M:\\sqlite\\Chinook_Sqlite.sqlite";

    public static void main(String[] args) throws SQLException {
        Scanner input = new Scanner(System.in);

        Connection connection = DriverManager.getConnection(DATABASE_URL);

        System.out.print("Insert artist id: ");
        long id = Integer.parseInt(input.nextLine());

        System.out.println("Please enter a new name: ");
        String name = input.nextLine();

        PreparedStatement statement = connection.prepareStatement("UPDATE Artist SET Name = ? WHERE ArtistId = ?");

        // Parametrit asetetaan turvallisesti:
        statement.setString(1, name);
        statement.setLong(2, id);

        // Turvallinen, ei salli SQL-injektioita:
        statement.executeUpdate();

        System.out.println("Done!");

        input.close();
        statement.close();
        connection.close();
    }
}