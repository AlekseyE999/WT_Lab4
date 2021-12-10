package by.bsuir.code.lab4.servlets.impl.actions;

import by.bsuir.code.lab4.entity.User;
import by.bsuir.code.lab4.servlets.impl.ServletSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/action")
public class ActionsDispatcherServlet extends HttpServlet {

    private final AdminActions adminActions = new AdminActions();
    private final UserActions userActions = new UserActions();
    private final GuestActions guestActions = new GuestActions();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Actions roleActions = null;

        switch (new ServletSession(req).getUserRole()) {
            case User.UserRole.admin:
                roleActions = adminActions;
                break;

            case User.UserRole.user:
                roleActions = userActions;
                break;

            case User.UserRole.guest:
                roleActions = guestActions;
                break;
        }

        if (roleActions == null) {
            resp.sendRedirect("/");
        }

        String action = req.getParameter("type");
        String forward = null;

        switch (action) {
            case "exit":
                roleActions.exit(req, resp);
                break;

            case "signin":
                roleActions.signIn(req, resp);
                break;

            case "book":
                forward = roleActions.book(req, resp);
                break;

            case "signup":
                roleActions.signUp(req, resp);
                break;

            case "changeroomvisibility":
                roleActions.changeRoomStatus(req, resp);
                break;

            case "changelang":
                roleActions.changeLang(req, resp);
                break;

            default:
                getServletContext().getRequestDispatcher("/404").forward(req, resp);
        }

        if (forward != null) {
            getServletContext().getRequestDispatcher(forward).forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
