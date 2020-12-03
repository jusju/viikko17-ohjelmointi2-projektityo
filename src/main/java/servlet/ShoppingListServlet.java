package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.JDBCShoppingListItemDao;
import database.ShoppingListItemDao;
import model.ShoppingListItem;

@WebServlet("/list")
public class ShoppingListServlet extends HttpServlet {

    private ShoppingListItemDao dao = new JDBCShoppingListItemDao();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ShoppingListItem> allItems = this.dao.getAllItems();

        req.setAttribute("items", allItems);

        req.getRequestDispatcher("/WEB-INF/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");

        ShoppingListItem newItem = new ShoppingListItem(title);

        boolean success = this.dao.addItem(newItem);

        resp.sendRedirect("/list");
    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        long id = Long.parseLong(req.getParameter("id"));
        ShoppingListItem itemToRemove = this.dao.getItem(id);

        if (itemToRemove != null) {
            this.dao.removeItem(itemToRemove);
        } else {
            resp.setStatus(404);
        }
    }
}

