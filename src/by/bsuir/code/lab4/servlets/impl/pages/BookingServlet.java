package by.bsuir.code.lab4.servlets.impl.pages;

import by.bsuir.code.lab4.entity.User;
import by.bsuir.code.lab4.servlets.UserSession;
import by.bsuir.code.lab4.presentation.html.View;
import by.bsuir.code.lab4.presentation.html.content.Booking;
import by.bsuir.code.lab4.presentation.html.content.Header;
import by.bsuir.code.lab4.servlets.impl.ServletSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

@WebServlet("/booking")
public class BookingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserSession session = new ServletSession(req);

        if (Objects.equals(session.getUserRole(), User.UserRole.user)) {

            try {
                resp.getWriter().write(new View(new Header(), new Booking(
                        Integer.parseInt(req.getParameter("room")),
                        req.getParameter("err") != null
                )).get(session));
            }
            catch (Exception ignore) {
                getServletContext().getRequestDispatcher("/404").forward(req, resp);
            }

        } else {
            resp.sendRedirect("/signin");
        }
    }
}
