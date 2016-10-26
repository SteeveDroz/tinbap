package com.github.steevedroz.tinbap.view.component;

import com.github.steevedroz.tinbap.components.Component;

import javafx.scene.layout.Pane;

public abstract class ComponentWidget extends Pane {
    protected Component component;

    public ComponentWidget(Component component) {
	this.component = component;
    }

    public void update() {
	component.update();
    }

    public Component getComponent() {
	return component;
    }

    public void setComponent(Component component) {
	this.component = component;
    }

    public void setLayout(double x, double y) {
	setLayoutX(x);
	setLayoutY(y);
    }

    public abstract void setCenter(double x, double y);
}
