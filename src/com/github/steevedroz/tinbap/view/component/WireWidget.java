package com.github.steevedroz.tinbap.view.component;

import com.github.steevedroz.tinbap.components.Wire;

import javafx.scene.shape.Line;

public class WireWidget extends ComponentWidget {
    private ConnectorWidget source;
    private ConnectorWidget destination;

    public WireWidget(ConnectorWidget source, ConnectorWidget destination) {
	super(new Wire());
	this.source = source;
	this.destination = destination;
	getComponent().getLeft().pair(source.getComponent());
	getComponent().getRight().pair(destination.getComponent());
	drawWidget();
    }

    @Override
    public void setCenter(double x, double y) {
	setLayout(x - source.getLayoutX() + destination.getLayoutX(),
		y - source.getLayoutY() + destination.getLayoutY());
    }

    @Override
    public Wire getComponent() {
	return (Wire) super.getComponent();
    }

    @Override
    protected void drawWidget() {
	Line line = new Line(source.getAbsoluteLayout().getX(), source.getAbsoluteLayout().getY(),
		destination.getAbsoluteLayout().getX(), destination.getAbsoluteLayout().getY());
	getChildren().add(line);
    }
}
