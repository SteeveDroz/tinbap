package com.github.steevedroz.tinbap.view.component;

import com.github.steevedroz.tinbap.IOType;
import com.github.steevedroz.tinbap.components.Lamp;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class LampWidget extends ComponentWidget {

    public LampWidget() {
	super(new Lamp());
	drawWidget();
    }

    @Override
    public void setCenter(double x, double y) {
	setLayout(x - 20, y - 10);
    }

    @Override
    public Point2D getCenter() {
	return new Point2D(getLayoutX() + 20, getLayoutY() + 10);
    }

    @Override
    public Lamp getComponent() {
	return (Lamp) super.getComponent();
    }

    @Override
    protected void drawWidget() {
	Circle circle = new Circle(20, 10, 10);
	circle.setFill(null);
	circle.setStroke(Color.BLACK);
	getChildren().add(circle);
	Line leftLine = new Line(0, 10, 10, 10);
	getChildren().add(leftLine);
	Line rightLine = new Line(30, 10, 40, 10);
	getChildren().add(rightLine);
	Line cross1 = new Line(10, 10, 30, 10);
	cross1.setRotate(45);
	getChildren().add(cross1);
	Line cross2 = new Line(10, 10, 30, 10);
	cross2.setRotate(-45);
	getChildren().add(cross2);
	ConnectorWidget connectorLeft = new ConnectorWidget(IOType.BOTH);
	connectorLeft.setCenter(0, 10);
	getChildren().add(connectorLeft);
	ConnectorWidget connectorRight = new ConnectorWidget(IOType.BOTH);
	connectorRight.setCenter(40, 10);
	getChildren().add(connectorRight);
    }

}
