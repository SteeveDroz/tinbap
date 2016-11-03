package com.github.steevedroz.tinbap.view.component;

import com.github.steevedroz.tinbap.IOType;
import com.github.steevedroz.tinbap.components.Resistor;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class ResistorWidget extends ComponentWidget {

    public ResistorWidget() {
	super(new Resistor());
	drawWidget();
    }

    @Override
    public void setCenter(double x, double y) {
	setLayout(x - 10, y - 10);
    }

    @Override
    public Point2D getCenter() {
	return new Point2D(getLayoutX() + 10, getLayoutY() + 10);
    }

    @Override
    public Resistor getComponent() {
	return (Resistor) super.getComponent();
    }

    @Override
    protected void drawWidget() {
	Rectangle rectangle = new Rectangle(10, 5, 20, 10);
	rectangle.setFill(null);
	rectangle.setStroke(Color.BLACK);
	getChildren().add(rectangle);
	Line leftLine = new Line(0, 10, 10, 10);
	getChildren().add(leftLine);
	Line rightLine = new Line(30, 10, 40, 10);
	getChildren().add(rightLine);
	ConnectorWidget connectorLeft = new ConnectorWidget(IOType.BOTH);
	connectorLeft.setCenter(0, 10);
	getChildren().add(connectorLeft);
	ConnectorWidget connectorRight = new ConnectorWidget(IOType.BOTH);
	connectorRight.setCenter(40, 10);
	getChildren().add(connectorRight);
    }

}
