package database.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.ChinookDatabase;
import model.Artist;

public class ArtistDao {
    private ChinookDatabase db = new ChinookDatabase();

    public Artist getArtist(long id) {
        Connection conn = db.connect();
        PreparedStatement statement = null;
        ResultSet results = null;

        try {
            statement = conn.prepareStatement("SELECT * FROM Artist WHERE ArtistId = ?");
            statement.setLong(1, id);
            results = statement.executeQuery();

            if (results.next()) {
                String name = results.getString("Name");
                long artistId = results.getLong("ArtistId");

                return new Artist(artistId, name);
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.close(results, statement, conn);
        }
    }

    public List<Artist> getAllArtists() {
        Connection conn = db.connect();
        PreparedStatement statement = null;
        ResultSet results = null;
        List<Artist> artists = new ArrayList<>();

        try {
            // 1. Create the SQL statement
            statement = conn.prepareStatement("SELECT * FROM Artist ORDER BY Name");

            // 2. Execute the statement and get results to local variable
            results = statement.executeQuery();

            while (results.next()) {
                // 3. Transform data from DB into Java objects
                long id = results.getLong("ArtistId");
                String name = results.getString("Name");

                Artist a = new Artist(id, name);

                // 4. Add each artist to list one-by-one
                artists.add(a);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 5. Close all resources
            db.close(results, statement, conn);
        }

        // 6. Return all artists as a list
        return artists;
    }
    public void storeArtist(Artist artist) {
        Connection connection = db.connect();
        PreparedStatement statement = null;
        ResultSet generatedKeys = null;
        try {
            statement = connection.prepareStatement("INSERT INTO Artist (Name) VALUES (?)",
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, artist.getName());
            statement.executeUpdate();
            generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                long id = generatedKeys.getLong(1);
                artist.setId(id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.close(generatedKeys, statement, connection);
        }
    }
    
    
    
    
    
}