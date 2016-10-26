package com.github.steevedroz.tinbap.view.component;

import com.github.steevedroz.tinbap.components.Diode;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;

public class DiodeWidget extends ComponentWidget {

    public DiodeWidget() {
	super(new Diode());
    }

    @Override
    public void setCenter(double x, double y) {
	setLayout(x - 20, y - 10);
    }

    @Override
    protected void drawWidget() {
	Polygon polygon = new Polygon();
	polygon.getPoints().addAll(new Double[] { 10.0, 0.0, 30.0, 10.0, 10.0, 20.0 });
	polygon.setFill(null);
	polygon.setStroke(Color.BLACK);
	getChildren().add(polygon);

	Line input = new Line(0, 10, 10, 10);
	getChildren().add(input);

	Line output = new Line(30, 10, 40, 10);
	getChildren().add(output);

	ConnectorWidget inputConnector = new ConnectorWidget();
	inputConnector.setCenter(0, 10);
	getChildren().add(inputConnector);

	ConnectorWidget outputWidget = new ConnectorWidget();
	outputWidget.setCenter(40, 10);
	getChildren().add(outputWidget);
    }
}
