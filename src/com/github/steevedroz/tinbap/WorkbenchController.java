package com.github.steevedroz.tinbap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.github.steevedroz.tinbap.components.Component;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.Canvas;

public class WorkbenchController extends Canvas {
    private AnimationTimer timer;
    private List<Component> components;
    private Component current;

    public WorkbenchController() {
	this.timer = new AnimationTimer() {

	    @Override
	    public void handle(long now) {
		update();
	    }
	};
	this.timer.start();
	this.components = new ArrayList<Component>();
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

    private void update() {
	if (current != null) {
	}
    }

    public void setCurrent(Component current) {
	this.current = current;
    }
}
