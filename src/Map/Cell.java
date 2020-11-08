package Map;

import javafx.scene.paint.Color;

public class Cell {
    public Mark mark;
    private Color color;

    public Cell(Mark mark){
        this.mark=mark;
        this.color= MarkToColor.getColor(mark);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Mark getMark(){
        return this.mark;
    }
}
