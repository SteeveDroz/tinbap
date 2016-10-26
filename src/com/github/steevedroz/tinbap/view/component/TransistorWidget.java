package com.github.steevedroz.tinbap.view.component;

import com.github.steevedroz.tinbap.components.Transistor;

import javafx.scene.shape.Circle;

public class TransistorWidget extends ComponentWidget {

    public TransistorWidget() {
	super(new Transistor());
	getChildren().add(new Circle(10, 10, 10));
    }

    @Override
    public void setCenter(double x, double y) {
	setLayout(x - 10, y - 10);
    }

    @Override
    protected void drawWidget() {
	// TODO Auto-generated method stub

    }

}
