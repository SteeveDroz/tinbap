package com.github.steevedroz.tinbap.view.component;

import com.github.steevedroz.tinbap.components.Diode;

import javafx.scene.shape.Circle;

public class DiodeWidget extends ComponentWidget {

    public DiodeWidget() {
	super(new Diode());
	getChildren().add(new Circle(10, 10, 10));
    }

    @Override
    public void setCenter(double x, double y) {
	setLayout(x - 10, y - 10);
    }
}
