package com.github.steevedroz.tinbap;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class TinbapController extends BorderPane {
    public TinbapController() {
	try {
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/github/steevedroz/tinbap/Tinbap.fxml"));
	    loader.setRoot(this);
	    loader.setController(this);
	    loader.load();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}
