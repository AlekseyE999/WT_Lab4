package by.bsuir.code.lab4.servlets.impl.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AdminActions extends UserActions {

    @Override
    public String book(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        return "/404";
    }

    @Override
    public void changeRoomStatus(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            servicesAccessPoint.getRoomsService().changeRoomVisibility(
                    Integer.parseInt(req.getParameter("room"))
            );
        } catch (Exception ignore) {

        }
        resp.sendRedirect("/suggestions");
    }
}
