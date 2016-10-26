package com.github.steevedroz.tinbap.view.component;

import com.github.steevedroz.tinbap.components.Lamp;

import javafx.scene.shape.Circle;

public class LampWidget extends ComponentWidget {

    public LampWidget() {
	super(new Lamp());
	getChildren().add(new Circle(10, 10, 10));
    }

    @Override
    public void setCenter(double x, double y) {
	setLayout(x - 10, y - 10);
    }

}
