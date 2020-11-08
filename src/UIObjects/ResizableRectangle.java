package UIObjects;

import javafx.scene.shape.Rectangle;

public class ResizableRectangle extends Rectangle {
    public ResizableRectangle(double w, double h) {
        super(w, h);
    }
    public ResizableRectangle() {
        super(0,0);
    }

    @Override
    public boolean isResizable() {
        return true;
    }

    @Override
    public double minWidth(double height) {
        return 0.0;
    }

    @Override
    public double minHeight(double height) {return 0.0;}
}