package by.bsuir.code.lab4.presentation.html.content;

import by.bsuir.code.lab4.servlets.UserSession;
import by.bsuir.code.lab4.presentation.html.Content;

import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class SignIn extends Content {
    private final boolean error;
    private final String salt;

    public SignIn(boolean error, String salt) {
        this.error = error;
        this.salt = salt;
    }

    @Override
    public List<String> getStyles() {
        return Collections.emptyList();
    }

    @Override
    public String get(UserSession session, ResourceBundle bundle) {
        StringBuilder content = new StringBuilder("<form action=\"signin\" method=\"post\">" +
                "<h2>" + bundle.getString("language.signin").toUpperCase() + "</h2>" +
                "<div>" +
                "<span>" + bundle.getString("language.login") + ":</span>" +
                "<div>" +
                "<input id=\"form-email\"name=\"email\" placeholder=\"email\">" +
                "</div>" +
                "</div>" +
                "<div>" +
                "<span>" + bundle.getString("language.password") + ":</span>" +
                "<div>" +
                "<input id=\"form-password\"name=\"password\" type=\"password\" placeholder=\"password\">" +
                "</div>" +
                "</div>" +
                "<input id=\"form-salt\" name=\"salt\" type=\"hidden\" value=\"" + salt + "\">" +
                "<button id=\"form-btn\" type=\"submit\">" + bundle.getString("language.signin") + "</button>"
        );

        if (error) {
            content.append("<span>" + bundle.getString("language.signinerr") + "</span>");
        }

        content.append("</form>");

        content.append("<script type=\"text/javascript\" src=\"/js/MD5.js\"></script>");
        content.append("<script type=\"text/javascript\" src=\"/js/signinbtn.js\"></script>");

        return content.toString();
    }
}
