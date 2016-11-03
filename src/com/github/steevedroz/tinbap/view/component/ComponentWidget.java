package com.github.steevedroz.tinbap.view.component;

import com.github.steevedroz.phonebookjava.PhoneBook;
import com.github.steevedroz.tinbap.WorkbenchController;
import com.github.steevedroz.tinbap.components.Component;

import javafx.geometry.Point2D;
import javafx.scene.Node;
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

    public Point2D getAbsoluteLayout() {
	Point2D layout = Point2D.ZERO;
	WorkbenchController workbench = (WorkbenchController) PhoneBook.call("workbench");
	Node current = this;
	while (current != workbench) {
	    layout = layout.add(new Point2D(current.getLayoutX(), current.getLayoutY()));
	    current = current.getParent();
	}
	return layout;
    }

    public void setComponent(Component component) {
	this.component = component;
    }

    public void setLayout(double x, double y) {
	setLayoutX(x);
	setLayoutY(y);
    }

    public abstract void setCenter(double x, double y);

    public abstract Point2D getCenter();

    protected abstract void drawWidget();
}
