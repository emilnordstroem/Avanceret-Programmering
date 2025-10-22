package lektion06IteratorPattern.geometricFigure;

public class App {

    public static void main(String[] args) {
        Drawing myDrawing = new Drawing(120, 50);

        GeometricFigure rectangle = new Rectangle(10, 20);
        GeometricFigure triangle = new Triangle(10, 15);
        rectangle.addGeometricFigure(triangle);
        myDrawing.addFigureToCanvas(rectangle);

        GeometricFigure eclipse = new Eclipse(30, 30);
        myDrawing.addFigureToCanvas(eclipse);

        myDrawing.seeDrawing();

    }

}
