package lektion06IteratorPattern.geometricFigure;

public class Drawing {
    private GeometricFigure geometricFigures;

    public Drawing(double canvasHeight, double canvasWidth) {
        this.geometricFigures = new Rectangle(canvasHeight, canvasWidth);
    }

    public void addFigureToCanvas (GeometricFigure geometricFigure) {
        geometricFigures.addGeometricFigure(geometricFigure);
    }

    public void seeDrawing(){
        System.out.println(geometricFigures.draw());
    }


}
