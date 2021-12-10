package by.bsuir.code.lab4.presentation.html;

import by.bsuir.code.lab4.servlets.UserSession;
import by.bsuir.code.lab4.presentation.html.content.Body;

import java.util.ResourceBundle;

public class View {

    private static final Head head = new Head();
    private static final String encoding = "UTF-8";

    private final Content body;

    public View(Content header, Content main) {
        this.body = new Body(header, main);
    }

    public String get(UserSession session) {

        ResourceBundle bundle = ResourceBundle.getBundle("localization/localization", session.getUserLocale());

        return "<!DOCTYPE html><html>" +
                head.get(encoding, body.getStyles()) +
                body.get(session, bundle) +
                "</html>";
    }
}
