package by.bsuir.code.lab4.presentation.html.content;

import by.bsuir.code.lab4.servlets.UserSession;
import by.bsuir.code.lab4.presentation.html.Content;
import by.bsuir.code.lab4.presentation.html.HtmlUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Header extends Content {

    @Override
    public List<String> getStyles() {
        List<String> styles = new ArrayList<>();
        styles.add("css/header.css");
        return styles;
    }

    @Override
    public String get(UserSession session, ResourceBundle bundle) {
        StringBuilder content = new StringBuilder();

        content.append("<div>");
        content.append("<div class=\"title\">");
        content.append(HtmlUtils.createLink("/", "<h1>" + bundle.getString("language.title") + "</h1></a>"));
        content.append("</div>");

        content.append("<div class=\"menu\">");
        content.append(HtmlUtils.createLink("/suggestions", bundle.getString("language.suggestions")));
        content.append("</div>");

        content.append("<div class=\"options\">");
        if (session.isAuthorized()) {
            content.append(HtmlUtils.createLink("/account", bundle.getString("language.account")));
            content.append(" | ");
            content.append(HtmlUtils.createLink("/action?type=exit", bundle.getString("language.exit")));
        } else {
            content.append(HtmlUtils.createLink("/signin", bundle.getString("language.signin")));
            content.append(" | ");
            content.append(HtmlUtils.createLink("/signup", bundle.getString("language.signup")));
        }
        content.append(" | ");
        content.append(HtmlUtils.createLink("/action?type=changelang&lang=ru", "RU"));
        content.append(" | ");
        content.append(HtmlUtils.createLink("/action?type=changelang&lang=en", "EN"));
        content.append("</div>");

        content.append("</div>");

        return content.toString();
    }
}
