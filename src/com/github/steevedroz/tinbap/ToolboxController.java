package com.github.steevedroz.tinbap;

import java.io.IOException;

import com.github.steevedroz.phonebookjava.PhoneBook;
import com.github.steevedroz.tinbap.view.component.DiodeWidget;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

public class ToolboxController extends HBox {

    public ToolboxController() {
	try {
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/github/steevedroz/tinbap/Toolbox.fxml"));
	    loader.setRoot(this);
	    loader.setController(this);
	    loader.load();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    @FXML
    public void transistor() {
	// TODO ((WorkbenchController)
	// PhoneBook.call("workbench")).setCurrent(new Transistor());
    }

    @FXML
    public void diode() {
	((WorkbenchController) PhoneBook.call("workbench")).setCurrent(new DiodeWidget());
    }

    @FXML
    public void lamp() {
    }

    @FXML
    public void resistor() {
    }
}
