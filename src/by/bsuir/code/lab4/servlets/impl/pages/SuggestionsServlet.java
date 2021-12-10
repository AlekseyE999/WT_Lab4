package by.bsuir.code.lab4.servlets.impl.pages;

import by.bsuir.code.lab4.entity.User;
import by.bsuir.code.lab4.service.ServicesAccessPoint;
import by.bsuir.code.lab4.presentation.html.content.Header;
import by.bsuir.code.lab4.presentation.html.content.Suggestions;
import by.bsuir.code.lab4.presentation.html.content.SuggestionsAdmin;
import by.bsuir.code.lab4.presentation.html.View;
import by.bsuir.code.lab4.servlets.impl.ServletSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

@WebServlet("/suggestions")
public class SuggestionsServlet extends HttpServlet {

    private final ServicesAccessPoint servicesAccessPoint = new ServicesAccessPoint();
    private final View userView = new View(new Header(), new Suggestions(servicesAccessPoint.getRoomsService()));
    private final View adminView = new View(new Header(), new SuggestionsAdmin(servicesAccessPoint.getRoomsService()));

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletSession session = new ServletSession(req);

        resp.getWriter().write(Objects.equals(session.getUserRole(), User.UserRole.admin) ?
                adminView.get(session) : userView.get(session));
    }
}
