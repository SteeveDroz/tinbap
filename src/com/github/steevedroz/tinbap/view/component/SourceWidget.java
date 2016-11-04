package com.github.steevedroz.tinbap.view.component;

import com.github.steevedroz.tinbap.IOType;
import com.github.steevedroz.tinbap.components.Source;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class SourceWidget extends ComponentWidget {
    public SourceWidget() {
	super(new Source());
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
    protected void drawWidget() {
	Rectangle rectangle = new Rectangle(0, 0, 20, 20);
	rectangle.setFill(Color.RED);
	getChildren().add(rectangle);
	Line line = new Line(20, 10, 30, 10);
	getChildren().add(line);
	ConnectorWidget connector = new ConnectorWidget(IOType.OUT);
	connector.setCenter(30, 10);
	connector.setAccessibleText("S");
	getChildren().add(connector);
    }

}
