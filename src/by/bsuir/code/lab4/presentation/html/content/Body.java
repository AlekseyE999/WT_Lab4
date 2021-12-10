package by.bsuir.code.lab4.presentation.html.content;

import by.bsuir.code.lab4.servlets.UserSession;
import by.bsuir.code.lab4.presentation.html.Content;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Body extends Content {

    private final Content header;
    private final Content main;

    public Body(Content header , Content main) {
        this.header = header;
        this.main = main;
    }

    @Override
    public List<String> getStyles() {
        List<String> styles = new ArrayList<>();

        styles.addAll(header.getStyles());
        styles.addAll(main.getStyles());
        styles.add("css/shared.css");

        return styles;
    }

    @Override
    public String get(UserSession session, ResourceBundle bundle) {
        return "<body>" +
                "<header>" + header.get(session, bundle) + "</header>" +
                "<main>" + main.get(session, bundle) + "</main>" +
                "</body>";
    }
}
