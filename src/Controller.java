import Map.Cell;
import Map.Map;
import Map.Utils;
import Map.SolveMap;
import UIObjects.AlertBox;
import UIObjects.ResizableRectangle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;


import static java.lang.System.exit;

public class Controller implements Initializable {
    @FXML private TextField  n;
    @FXML private TextField m;
    public GridPane mainGrid;
    GridPane mapGrid;
    Map map;
    Thread mapChaingingThread;


    @FXML
    public void loadMap(ActionEvent actionEvent) {
        this.clearThread();
        int rows;
        int columns;
        try {
            rows= Integer.parseInt(n.getText());
            columns= Integer.parseInt(m.getText());
        }catch (Exception e){
            rows=0;
            columns=0;
        }
        this.map = new Map(rows,columns);
        GridPane newMapGrid = this.createMapGrid(this.map);
        setMapGrid(newMapGrid);

    }
    @FXML
    public void solveMap(ActionEvent actionEvent){
        int result= SolveMap.solve(this.map);
        GridPane newMapGrid = this.createMapGrid(this.map);
        setMapGrid(newMapGrid);

        AlertBox.display(Utils.getMessage(result));
    }

    private void setMapGrid(GridPane grid) {
        GridPane.setConstraints(grid, 0,1);
        GridPane.setColumnSpan(grid, GridPane.REMAINING);
        if (mapGrid != null) {
            mainGrid.getChildren().remove(this.mapGrid);
        }
        this.mainGrid.getChildren().add(grid);
        this.mapGrid = grid;
    }

    private void clearThread() {
        if(this.mapChaingingThread == null) return;
        this.mapChaingingThread.interrupt();
        this.mapChaingingThread = null;
    }

    public void exitFunc() {
        exit(0);
    }

    private GridPane createMapGrid(Map inMap) {
        int pad = 2;
        int menuBarSize = 25;
        GridPane mapGrid = new GridPane();
        int rows = inMap.getRowsNumber();
        int columns = inMap.getColumnsNumber();
        mapGrid.setGridLinesVisible(true);
        Scene scene = this.mainGrid.getScene();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Rectangle rec = new ResizableRectangle();
                //width
                rec.widthProperty().bind(scene.widthProperty().divide(columns).add(-2 * pad));
                //height
                rec.heightProperty().bind(scene.heightProperty().add(-menuBarSize).divide(rows).add(-2 * pad));
                Cell c = inMap.getMatrix()[i][j];
                IntegerProperty r = new SimpleIntegerProperty(0);

                rec.fillProperty().bind(Bindings.createObjectBinding(() -> c.getColor(), r));

                GridPane.setConstraints(rec, j, i);
                GridPane.setMargin(rec, new Insets(pad, pad, pad, pad));
                mapGrid.getChildren().add(rec);

            }
        }
        GridPane.setConstraints(mapGrid, 0, 1);
        return mapGrid;
    }








    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }



}

