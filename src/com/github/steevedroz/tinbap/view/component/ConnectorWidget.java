package com.github.steevedroz.tinbap.view.component;

import com.github.steevedroz.tinbap.IOType;
import com.github.steevedroz.tinbap.components.Connector;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ConnectorWidget extends ComponentWidget {
    private static final double SIZE = 3.0;

    public ConnectorWidget() {
	super(new Connector(IOType.BOTH));
    }

    @Override
    public void setCenter(double x, double y) {
	setLayout(x - SIZE, y - SIZE);
    }

    @Override
    protected void drawWidget() {
	Circle circle = new Circle(SIZE, SIZE, SIZE);
	circle.setFill(Color.WHITE);
	circle.setStroke(Color.BLACK);
	getChildren().add(circle);

	circle.setOnMouseEntered(event -> circle.setFill(Color.RED));
	circle.setOnMouseExited(event -> circle.setFill(Color.WHITE));
    }

}
