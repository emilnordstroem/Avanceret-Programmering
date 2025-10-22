package lektion06IteratorPattern.geometricFigure;

import java.util.ArrayList;
import java.util.List;

public abstract class GeometricFigure {
    private String name;
    private double xMeasure;
    private double yMeasure;

    private final List<GeometricFigure> containingGeometricFigures = new ArrayList<>();

    public GeometricFigure(String name, double xMeasure, double yMeasure) {
        this.name = name;
        this.xMeasure = xMeasure;
        this.yMeasure = yMeasure;
    }

    public String draw() {
        StringBuilder drawing = new StringBuilder(name);
        for (GeometricFigure currentFigure : containingGeometricFigures) {
            drawing.append("--Contains-->").append(currentFigure.draw());
        }
        return drawing.toString();
    }

    public double getArea() {
        return xMeasure * yMeasure;
    }

    public void addGeometricFigure(GeometricFigure geometricFigure) {
        if (!this.containingGeometricFigures.contains(geometricFigure)) {
            containingGeometricFigures.add(geometricFigure);
        }
    }

    public String getName() {
        return name;
    }

    public double getxMeasure() {
        return xMeasure;
    }

    public double getyMeasure() {
        return yMeasure;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setxMeasure(double xMeasure) {
        this.xMeasure = xMeasure;
    }

    public void setyMeasure(double yMeasure) {
        this.yMeasure = yMeasure;
    }

}
