package by.bsuir.code.lab4.presentation.html.content;

import by.bsuir.code.lab4.entity.Room;
import by.bsuir.code.lab4.service.RoomsService;
import by.bsuir.code.lab4.servlets.UserSession;
import by.bsuir.code.lab4.presentation.html.Content;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Suggestions extends Content {
    protected final RoomsService roomsService;

    public Suggestions(RoomsService roomsService) {
        this.roomsService = roomsService;
    }

    @Override
    public List<String> getStyles() {
        List<String> styles = new ArrayList<>();
        styles.add("css/roomcard.css");
        return styles;
    }

    @Override
    public String get(UserSession session, ResourceBundle bundle) {
        StringBuilder content = new StringBuilder();

        for (Room room : getRooms()) {
            content.append("<div class=\"room-card\">");
            appendRoomCardContent(content, room, bundle);
            content.append("</div>");
        }

        return content.toString();
    }

    protected List<Room> getRooms() {
        return roomsService.getVisibleRooms();
    }

    protected void appendRoomCardContent(StringBuilder content, Room room, ResourceBundle bundle) {
        content.append("<div class=\"name\">");
        content.append(bundle.getString(room.getName()));
        content.append("</div>");

        content.append("<div class=\"desc-main\">");
        content.append("<div class=\"desc-main-price\">");
        content.append(bundle.getString("language.priceperday") + ": "+ (room.getPrice() / 100) + " BYN");
        content.append("</div>");
        content.append("<div class=\"desc-main-beds\">");
        content.append(bundle.getString("language.numberofbeds") + ": " + room.getBedsCount());
        content.append("</div>");
        content.append("</div>");

        content.append("<div class=\"desc-extra\">");
        content.append(bundle.getString(room.getDescription()));
        content.append("</div>");

        content.append("<div class=\"opt\">");
        appendRoomCardOptions(content, room, bundle);
        content.append("</div>");
    }

    protected void appendRoomCardOptions(StringBuilder content, Room room, ResourceBundle bundle) {
        content.append("<a href=\"/booking?room=" + room.getId() + "\">" + bundle.getString("language.bookaroom") + "</a>");
    }
}
