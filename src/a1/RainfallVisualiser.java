package a1;

import examples.MosaicCanvas;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import textio.TextIO;

/**
 * This file can be used to draw a chart that effectively represents rainfall data.  Just fill in
 * the definition of drawPicture with the code that draws your picture.
 */
public class RainfallVisualiser extends Application {

    private final static int ROWS = 40;        // rows in the mosaic
    private final static int COLUMNS = 40;     // columns in the mosaic
    private final static int SQUARE_SIZE = 15; // size of each square
    private MosaicCanvas mosaic;
    private int currentRed, currentGreen, currentBlue;  // The current color.

    /**
     * Draws a picture.  The parameters width and height give the size
     * of the drawing area, in pixels.
     */
    public void drawPicture(GraphicsContext g, int width, int height) {
        // TODO: draw the x-axis and y-axis
        // TODO: draw the monthly totals as a bar chart
    } // end drawPicture()


    //------ Implementation details: DO NOT EDIT THIS ------
    public void start(Stage stage) {
//        int width = 218 * 6 + 40;
//        int height = 500;
//        Canvas canvas = new Canvas(width, height);
//        drawPicture(canvas.getGraphicsContext2D(), width, height);
//        BorderPane root = new BorderPane(canvas);
//        root.setStyle("-fx-border-width: 4px; -fx-border-color: #444");
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.setTitle("Rainfall Visualiser");
//        stage.show();
//        stage.setResizable(false);

        mosaic = new MosaicCanvas(ROWS, COLUMNS, SQUARE_SIZE, SQUARE_SIZE);
        mosaic.setOnMousePressed( e -> doMouse(e));
//        mosaic.setOnMouseDragged( e -> doMouse(e));
        mosaic.clear();
        currentRed = 255;
        currentGreen = 0;
        currentBlue = 0;

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root);

        root.setCenter(mosaic);
//        root.setTop( createMenuBar() );

        stage.setTitle("Rainfall Visualiser");
//        stage.setTitle("Mosaic Draw");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setX(150);  // Put the window at screen coords (150,100).
        stage.setY(100);
        stage.show();
    }
    //------ End of Implementation details ------



    public static void main(String[] args) {
//        System.out.print("Enter path: ");
//        var path = TextIO.getln();
//
//        String path = "C:\\Users\\Sabu Mini\\IdeaProjects\\Assignment 1 trialssrc/a1/MountSheridanStationCNS_analysed.csv";
//        TextIO.readFile(path);
        launch();

    }
    private void doMouse(MouseEvent evt) {
        int row = mosaic.yCoordToRowNumber((int)evt.getY());
        int col = mosaic.xCoordToColumnNumber((int)evt.getX());
        if (row >= 0 && row < mosaic.getRowCount() && col >= 0 && col < mosaic.getColumnCount()) {
            // (the test in this if statement will be false if the user drags the
            //  mouse outside the canvas after pressing the mouse on the canvas)
            paintSquare(row, col);
        }
    }


    private void paintSquare(int row, int col) {
        int r = currentRed;
        int g = currentGreen;
        int b = currentBlue;
        Color color = Color.rgb(r,g,b);
        mosaic.setColor(row, col, color);
    }

} // end SimpleGraphicsStarter
