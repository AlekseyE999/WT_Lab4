package by.bsuir.code.lab4.servlets.impl.pages;

import by.bsuir.code.lab4.service.ServicesAccessPoint;
import by.bsuir.code.lab4.presentation.html.Content;
import by.bsuir.code.lab4.presentation.html.content.Header;
import by.bsuir.code.lab4.presentation.html.content.SignIn;
import by.bsuir.code.lab4.presentation.html.View;
import by.bsuir.code.lab4.servlets.impl.ServletSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/signin")
public class SignInServlet extends HttpServlet {

    private final ServicesAccessPoint servicesAccessPoint = new ServicesAccessPoint();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletSession session = new ServletSession(req);

        if (session.isAuthorized()) {
            resp.sendRedirect("/");
        }

        Content content = req.getParameter("err") == null ?
                new SignIn(false, servicesAccessPoint.getAuthorizationService().createSalt()) :
                new SignIn(true, servicesAccessPoint.getAuthorizationService().createSalt());

        resp.getWriter().write(new View(new Header(), content).get(session));
    }
}
