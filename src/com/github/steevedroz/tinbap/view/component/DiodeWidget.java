package com.github.steevedroz.tinbap.view.component;

import com.github.steevedroz.tinbap.components.Diode;

import javafx.scene.Node;
import javafx.scene.shape.Circle;

public class DiodeWidget extends ComponentWidget {

    public DiodeWidget() {
	super(new Diode());
    }

    @Override
    public Node getNode() {
	Circle circle = new Circle(10);
	return circle;
    }

}
