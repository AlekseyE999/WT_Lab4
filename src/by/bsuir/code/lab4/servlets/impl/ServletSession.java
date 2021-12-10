package by.bsuir.code.lab4.servlets.impl;

import by.bsuir.code.lab4.entity.User;
import by.bsuir.code.lab4.servlets.UserSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Locale;

public class ServletSession implements UserSession {

    private final HttpSession session;
    private final Locale locale;

    public ServletSession(HttpServletRequest req) {
        this.session = req.getSession();
        locale = req.getLocale();
    }

    @Override
    public boolean isAuthorized() {
        return session.getAttribute("id") != null;
    }

    @Override
    public void setUserId(int userId) {
        session.setAttribute("id", userId);
        session.setMaxInactiveInterval(-1);
    }

    @Override
    public String getUserRole() {
        Object value = session.getAttribute("role");
        if (value == null) {
            return User.UserRole.guest;
        } else {
            return (String) value;
        }
    }

    @Override
    public void setUserRole(String userRole) {
        session.setAttribute("role", userRole);
    }

    @Override
    public String getUserName() {
        return (String) session.getAttribute("name");
    }

    @Override
    public void setUserName(String name) {
        session.setAttribute("name", name);
    }

    @Override
    public Locale getUserLocale() {

        Locale lang = (Locale) session.getAttribute("lang");

        if (lang != null) {
            return lang;
        }

        return locale;
    }

    @Override
    public void setUserLocale(Locale locale) {
        session.setAttribute("lang", locale);
    }

    @Override
    public int getUserId() {
        Object id = session.getAttribute("id");

        if (id == null) {
            return -1;
        }

        return (int)id;
    }

    @Override
    public void clear() {
        session.invalidate();
    }
}
