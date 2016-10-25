package com.github.steevedroz.tinbap.view.component;

import com.github.steevedroz.tinbap.components.Component;

import javafx.scene.Node;

public abstract class ComponentWidget {
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

    public abstract Node getNode();
}
