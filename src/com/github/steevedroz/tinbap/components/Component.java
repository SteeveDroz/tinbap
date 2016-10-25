package com.github.steevedroz.tinbap.components;

import java.util.ArrayList;
import java.util.List;

import com.github.steevedroz.tinbap.Connector;

public abstract class Component {
    private String name;
    protected List<Connector> connectors;

    public Component(String name) {
	this.name = name;
	this.connectors = new ArrayList<Connector>();
    }

    public void update() {
	eval();
	for (Connector connector : connectors) {
	    connector.send();
	}
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    protected abstract void eval();
}
