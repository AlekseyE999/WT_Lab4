package by.bsuir.code.lab4.presentation.html.content;

import by.bsuir.code.lab4.entity.Room;
import by.bsuir.code.lab4.service.RoomsService;

import java.util.List;
import java.util.ResourceBundle;

public class SuggestionsAdmin extends Suggestions{

    public SuggestionsAdmin(RoomsService roomsService) {
        super(roomsService);
    }

    @Override
    protected List<Room> getRooms() {
        return roomsService.getAllRooms();
    }

    @Override
    protected void appendRoomCardOptions(StringBuilder content, Room room, ResourceBundle bundle) {
        if (room.isHidden()) {
            content.append("<a href=\"/action?type=changeroomvisibility&room=" + room.getId() + "\">"
                    + bundle.getString("language.allowtobook") + "</a>");
        }
        else {
            content.append("<a href=\"/action?type=changeroomvisibility&room=" + room.getId() + "\">"
                    + bundle.getString("language.denybooking") + "</a>");
        }
    }

    @Override
    protected void appendRoomCardContent(StringBuilder content, Room room, ResourceBundle bundle) {
        super.appendRoomCardContent(content, room, bundle);
        if (room.isHidden()) {
            content.append(bundle.getString("language.roomreservationisprohibited"));
        }
        else {
            content.append(bundle.getString("language.roomreservationallowed"));
        }
    }
}
