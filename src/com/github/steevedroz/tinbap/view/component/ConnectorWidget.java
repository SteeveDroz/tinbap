package com.github.steevedroz.tinbap.view.component;

import com.github.steevedroz.phonebookjava.PhoneBook;
import com.github.steevedroz.tinbap.IOType;
import com.github.steevedroz.tinbap.WorkbenchController;
import com.github.steevedroz.tinbap.components.Connector;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ConnectorWidget extends ComponentWidget {
    private static final double SIZE = 4.0;

    public ConnectorWidget(IOType type) {
	super(new Connector(type));
	setOnMouseClicked(event -> {
	    click();
	    event.consume();
	});
	drawWidget();
    }

    public void click() {
	ConnectorWidget connector = (ConnectorWidget) PhoneBook.call("selected-connector");
	if (connector == null) {
	    PhoneBook.addEntry("selected-connector", this);
	} else if (connector == this) {
	    PhoneBook.removeEntry("selected-connector");
	} else {
	    WireWidget wireWidget = new WireWidget(connector, this);
	    ((WorkbenchController) PhoneBook.call("workbench")).addComponent(wireWidget);
	    wireWidget.setPickOnBounds(false);
	    PhoneBook.removeEntry("selected-connector");
	}
    }

    @Override
    public void setCenter(double x, double y) {
	setLayout(x - SIZE, y - SIZE);
    }

    @Override
    public Point2D getCenter() {
	return new Point2D(getLayoutX() + SIZE, getLayoutY() + SIZE);
    }

    @Override
    public Connector getComponent() {
	return (Connector) super.getComponent();
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

    @Override
    public Point2D getAbsoluteLayout() {
	return super.getAbsoluteLayout().add(new Point2D(SIZE, SIZE));
    }
}
