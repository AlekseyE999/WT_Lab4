package by.bsuir.code.lab4.presentation.html.content;

import by.bsuir.code.lab4.servlets.UserSession;
import by.bsuir.code.lab4.presentation.html.Content;

import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class Booking extends Content {
    private final int roomId;
    private final boolean error;

    public Booking(int roomId, boolean error) {
        this.roomId = roomId;
        this.error = error;
    }

    @Override
    public List<String> getStyles() {
        return Collections.emptyList();
    }

    @Override
    public String get(UserSession session, ResourceBundle bundle) {
        return "<form action=\"/action\"method=\"post\">" +
                bundle.getString("language.arrivaldate") + ":" +
                "<input type=\"date\" name=\"start\">" +
                bundle.getString("language.dateofdeparture") + ":" +
                "<input type=\"date\" name=\"end\">" +
                "<input type=\"hidden\" name=\"room\" value=\"" + roomId + "\">" +
                "<input type=\"hidden\" name=\"type\" value=\"book\">" +
                "<button id=\"form-btn\" type=\"submit\">" + bundle.getString("language.booknow") + "</button>" +
                "</form>" + (error ? bundle.getString("language.timeerr") : "");
    }
}
