package by.bsuir.code.lab4.presentation.html.content;

import by.bsuir.code.lab4.entity.Reservation;
import by.bsuir.code.lab4.entity.Room;
import by.bsuir.code.lab4.service.ServicesAccessPoint;
import by.bsuir.code.lab4.servlets.UserSession;
import by.bsuir.code.lab4.presentation.html.Content;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Account extends Content {

    private final ServicesAccessPoint servicesAccessPoint;

    public Account(ServicesAccessPoint servicesAccessPoint) {
        this.servicesAccessPoint = servicesAccessPoint;
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

        content.append("<div>");
        content.append("<h2>" + bundle.getString("language.hello") + ", " + session.getUserName() + "</h2>");

        List<Reservation> reservations = servicesAccessPoint.getBookingService().getReservationsOf(session.getUserId());

        if (reservations.size() != 0) {
            content.append("<h3>" + bundle.getString("language.yourreservations")+ ":</h3>");
            content.append("</div>");

            content.append("<div>");



            for (Reservation reservation : reservations) {
                appendReservationCard(
                        content,
                        reservation,
                        servicesAccessPoint.getRoomsService().getRoomById(reservation.getRoomId()),
                        bundle
                );
            }
        } else {
            content.append("<h4>" + bundle.getString("language.nobook")+"</h4>");
        }


        content.append("</div>");

        return content.toString();
    }

    protected void appendReservationCard(StringBuilder content, Reservation reservation, Room room, ResourceBundle bundle) {
        content.append("<div class=\"room-card\">");

        content.append("<div>");
        content.append("<div>");
        content.append(bundle.getString(room.getName()));
        content.append("</div>");
        content.append("<div>");
        content.append(bundle.getString(room.getDescription()));
        content.append("</div>");
        content.append("</div>");

        content.append("<div>");
        content.append("<div>");
        content.append("<span>" + bundle.getString("language.arrivaldate") + ":</span>");
        content.append(reservation.getStart());
        content.append("</div>");
        content.append("<div>");
        content.append("<span>" + bundle.getString("language.dateofdeparture") + "</span>");
        content.append(reservation.getEnd());
        content.append("</div>");
        content.append("</div>");

        content.append("</div>");
    }
}
