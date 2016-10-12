package com.github.steevedroz.tinbap;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.Canvas;

public class WorkbenchController extends Canvas {
    public WorkbenchController() {
	try {
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/github/steevedroz/tinbap/Workbench.fxml"));
	    loader.setRoot(this);
	    loader.setController(this);
	    loader.load();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}
