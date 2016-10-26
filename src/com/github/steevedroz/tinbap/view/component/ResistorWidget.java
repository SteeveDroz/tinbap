package com.github.steevedroz.tinbap.view.component;

import com.github.steevedroz.tinbap.components.Resistor;

import javafx.scene.shape.Circle;

public class ResistorWidget extends ComponentWidget {

    public ResistorWidget() {
	super(new Resistor());
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
