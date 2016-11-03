package com.github.steevedroz.tinbap.view.component;

import com.github.steevedroz.tinbap.IOType;
import com.github.steevedroz.tinbap.components.Transistor;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class TransistorWidget extends ComponentWidget {

    public TransistorWidget() {
	super(new Transistor());
	drawWidget();
    }

    @Override
    public void setCenter(double x, double y) {
	setLayout(x - 10, y - 12.5);
    }

    @Override
    public Point2D getCenter() {
	return new Point2D(getLayoutX() + 10, getLayoutY() + 12.5);
    }

    @Override
    public Transistor getComponent() {
	return (Transistor) super.getComponent();
    }

    @Override
    protected void drawWidget() {
	Rectangle rectangle = new Rectangle(0, 10, 20, 5);
	rectangle.setFill(null);
	rectangle.setStroke(Color.BLACK);
	getChildren().add(rectangle);

	Line baseLine = new Line(10, 0, 10, 10);
	getChildren().add(baseLine);

	Line collectorLine = new Line(5, 15, 0, 25);
	getChildren().add(collectorLine);

	Line emitterLine = new Line(15, 15, 20, 25);
	getChildren().add(emitterLine);

	ConnectorWidget base = new ConnectorWidget(IOType.IN);
	base.setCenter(10, 0);
	getChildren().add(base);

	ConnectorWidget collector = new ConnectorWidget(IOType.BOTH);
	collector.setCenter(0, 25);
	getChildren().add(collector);

	ConnectorWidget emitter = new ConnectorWidget(IOType.BOTH);
	emitter.setCenter(20, 25);
	getChildren().add(emitter);
    }

}
