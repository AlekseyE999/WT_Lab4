package by.bsuir.code.lab4.presentation.html.content;

import by.bsuir.code.lab4.servlets.UserSession;
import by.bsuir.code.lab4.presentation.html.Content;

import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class SignUp extends Content {

    private final boolean error;

    public SignUp(boolean error) {
        this.error = error;
    }

    @Override
    public List<String> getStyles() {
        return Collections.emptyList();
    }

    @Override
    public String get(UserSession session, ResourceBundle bundle) {
        StringBuilder content = new StringBuilder("<form action=\"signup\" method=\"post\">" +
                "<h2>" + bundle.getString("language.signup").toUpperCase() + "</h2>" +
                "<div>" +
                "<span>" + bundle.getString("language.login") + ":</span>" +
                "<div>" +
                "<input id=\"form-login\" name=\"login\" placeholder=\"login\">" +
                "</div>" +
                "</div>" +
                "<div>" +
                "<span>" + bundle.getString("language.name") + ":</span>" +
                "<div>" +
                "<input id=\"form-name\" name=\"name\" placeholder=\"name\">" +
                "</div>" +
                "</div>" +
                "<div>" +
                "<span>" + bundle.getString("language.password") + ":</span>" +
                "<div>" +
                "<input id=\"form-password\" name=\"password\" type=\"password\" placeholder=\"password\">" +
                "</div>" +
                "</div>" +
                "<button id=\"form-btn\"type=\"submit\">" + bundle.getString("language.signup") + "</button>");

        if (error) {
            content.append(bundle.getString("language.signuperr"));
        }

        content.append("<script type=\"text/javascript\" src=\"/js/MD5.js\"></script>");
        content.append("<script type=\"text/javascript\" src=\"/js/signupbtn.js\"></script>");

        return content.toString();
    }
}
