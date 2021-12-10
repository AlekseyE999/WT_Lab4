package by.bsuir.code.lab4.presentation.html.content;

import by.bsuir.code.lab4.servlets.UserSession;
import by.bsuir.code.lab4.presentation.html.Content;

import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class Welcome extends Content {
    @Override
    public List<String> getStyles() {
        return Collections.emptyList();
    }

    @Override
    public String get(UserSession session, ResourceBundle bundle) {
        return "<div>" +
                "<p>" + bundle.getString("language.welcome.p1") + "</p>" +
                "<p>" + bundle.getString("language.welcome.p2") + "</p>" +
                "<p>" + bundle.getString("language.welcome.p3") + "</p>" +
                "</div>";
    }
}
