package by.bsuir.code.lab4.presentation.html;

import by.bsuir.code.lab4.servlets.UserSession;

import java.util.List;
import java.util.ResourceBundle;

public abstract class Content {
    public abstract List<String> getStyles();
    public abstract String get(UserSession session, ResourceBundle bundle);
}
