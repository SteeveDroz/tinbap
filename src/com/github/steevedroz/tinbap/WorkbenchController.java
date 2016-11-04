package com.github.steevedroz.tinbap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.github.steevedroz.tinbap.view.component.ComponentWidget;
import com.github.steevedroz.tinbap.view.component.ConnectorWidget;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class WorkbenchController extends Pane {
    private AnimationTimer timer;
    private List<ComponentWidget> components;
    private ComponentWidget current;

    public WorkbenchController() {
	this.timer = new AnimationTimer() {

	    @Override
	    public void handle(long now) {
		update();
	    }
	};
	this.timer.start();
	this.components = new ArrayList<ComponentWidget>();
	this.current = null;
	try {
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/github/steevedroz/tinbap/Workbench.fxml"));
	    loader.setRoot(this);
	    loader.setController(this);
	    loader.load();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    @FXML
    public void moveComponent(MouseEvent event) {
	if (current != null) {
	    current.setCenter(event.getX(), event.getY());
	}
    }

    @FXML
    public void placeComponent(MouseEvent event) {
	if (current != null) {
	    current.setCenter(event.getX(), event.getY());
	    addComponent(current);
	    current = null;
	} else {
	    ConnectorWidget connector = new ConnectorWidget(IOType.BOTH);
	    connector.setCenter(event.getX(), event.getY());
	    addComponent(connector);
	    connector.click();
	}
    }

    public void addComponent(ComponentWidget component) {
	components.add(component);
	if (getChildren().indexOf(component) == -1) {
	    getChildren().add(component);
	}
    }

    private void update() {
	if (current != null) {
	}
	components.forEach(component -> component.update());
    }

    public void setCurrent(ComponentWidget current) {
	this.current = current;
	current.setCenter(Integer.MIN_VALUE, Integer.MIN_VALUE);
	getChildren().add(current);
    }
}
