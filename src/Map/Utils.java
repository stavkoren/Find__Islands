package Map;

import javafx.scene.paint.Color;

public class Utils {

    public static Color getRandomColor(){
        return Color.color(Math.random(), Math.random(), Math.random());
    }
    public static String getMessage(int num){
        return Constants.UIConstants.Message_Prefix+" "+num+" "+ Constants.UIConstants.Message_suffix;
    }
}

