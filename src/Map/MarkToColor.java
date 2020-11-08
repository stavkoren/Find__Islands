package Map;

import javafx.scene.paint.Color;

public class MarkToColor {
    public static Color getColor(Mark m) {
        if (m == Mark.LAND) {
            return Color.BLACK;
        }

        return Color.WHITE;
    }
}
