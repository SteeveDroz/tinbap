package com.github.steevedroz.tinbap;

import java.io.IOException;

import com.github.steevedroz.phonebookjava.PhoneBook;
import com.github.steevedroz.tinbap.view.component.ComponentWidget;
import com.github.steevedroz.tinbap.view.component.DiodeWidget;
import com.github.steevedroz.tinbap.view.component.LampWidget;
import com.github.steevedroz.tinbap.view.component.ResistorWidget;
import com.github.steevedroz.tinbap.view.component.TransistorWidget;

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
	setCurrent(new TransistorWidget());
    }

    @FXML
    public void diode() {
	setCurrent(new DiodeWidget());
    }

    @FXML
    public void lamp() {
	setCurrent(new LampWidget());
    }

    @FXML
    public void resistor() {
	setCurrent(new ResistorWidget());
    }

    private void setCurrent(ComponentWidget componentWidget) {
	((WorkbenchController) PhoneBook.call("workbench")).setCurrent(componentWidget);
    }
}
