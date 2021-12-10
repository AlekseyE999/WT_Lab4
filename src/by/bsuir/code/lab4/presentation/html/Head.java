package by.bsuir.code.lab4.presentation.html;

public class Head {
    public String get(String encoding, Iterable<String> styles) {
        StringBuilder head = new StringBuilder();
        head.append("<head>");

        head.append("<meta charset=\"").append(encoding).append("\">");

        for (String style : styles) {
            head.append("<link rel=\"stylesheet\" href=\"").append(style).append("\">");
        }

        head.append("</head>");
        return head.toString();
    }
}
