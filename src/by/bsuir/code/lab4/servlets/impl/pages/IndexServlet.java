package by.bsuir.code.lab4.servlets.impl.pages;

import by.bsuir.code.lab4.presentation.html.View;
import by.bsuir.code.lab4.presentation.html.content.Header;
import by.bsuir.code.lab4.presentation.html.content.Welcome;
import by.bsuir.code.lab4.servlets.impl.ServletSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("")
public class IndexServlet extends HttpServlet {

    private final View view = new View(new Header(), new Welcome());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(view.get(new ServletSession(req)));
    }
}
