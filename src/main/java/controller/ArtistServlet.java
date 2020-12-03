package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.dao.AlbumDao;
import database.dao.ArtistDao;
import model.Album;
import model.Artist;

@WebServlet("/artist")
public class ArtistServlet extends HttpServlet {

    private ArtistDao artistDao = new ArtistDao();

    private AlbumDao albumDao = new AlbumDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1. Get the artist id from the request:
        String idParameter = request.getParameter("id");
        long id = Long.parseLong(idParameter); // this may fail due to null value or invalid numeric string

        // 2. Load artist from the database (may be null if id does not match)
        Artist artist = artistDao.getArtist(id);

        // 3. Load all albums from the database for the artist
        List<Album> albums = albumDao.getAlbumsByArtist(artist);

        request.setAttribute("artist", artist);
        request.setAttribute("albums", albums);

        request.getRequestDispatcher("/WEB-INF/views/artist.jsp").include(request, response);
    }
}