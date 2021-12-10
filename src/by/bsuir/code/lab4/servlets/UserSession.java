package by.bsuir.code.lab4.servlets;

import java.util.Locale;

public interface UserSession {
    boolean isAuthorized();

    int getUserId();
    void setUserId(int userId);

    String getUserRole();
    void setUserRole(String userRole);

    String getUserName();
    void setUserName(String name);

    Locale getUserLocale();
    void setUserLocale(Locale locale);

    void clear();
}
