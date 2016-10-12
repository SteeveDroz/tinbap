package com.github.steevedroz.tinbap;

import java.util.ArrayList;
import java.util.List;

public abstract class Component {
    private String name;
    private List<Connector> topConnectors;
    private List<Connector> bottomConnectors;
    private List<Connector> leftConnectors;
    private List<Connector> rightConnectors;

    public Component(String name) {
	this.name = name;
	this.topConnectors = new ArrayList<Connector>();
	this.bottomConnectors = new ArrayList<Connector>();
	this.leftConnectors = new ArrayList<Connector>();
	this.rightConnectors = new ArrayList<Connector>();
    }

    public static Component createTransistor() {
	Component transistor = new Component("Transistor") {
	    @Override
	    public void eval() {
		Connector base = getConnector("Base");
		Connector collector = getConnector("Collector");
		Connector emitter = getConnector("Emitter");
		if (base.getVoltage() > 0.2) {
		    double maxVoltage = Math.max(collector.getVoltage(), emitter.getVoltage());
		    collector.setVoltage(maxVoltage);
		    emitter.setVoltage(maxVoltage);
		}
	    }
	};
	transistor.getTopConnectors().add(new Connector("Base", IOType.IN));
	transistor.getLeftConnectors().add(new Connector("Emitter", IOType.BOTH));
	transistor.getRightConnectors().add(new Connector("Collector", IOType.BOTH));
	return transistor;
    }

    public static Component createDiode() {
	Component diode = new Component("Diode") {

	    @Override
	    public void eval() {
		Connector in = getConnector("In");
		Connector out = getConnector("Out");
		out.setVoltage(Math.max(in.getVoltage(), out.getVoltage()));
	    }
	};
	diode.getLeftConnectors().add(new Connector("In", IOType.IN));
	diode.getRightConnectors().add(new Connector("Out", IOType.OUT));
	return diode;
    }

    public static Component createLamp() {
	Component lamp = new Component("Lamp") {
	    private double threshold = 1.0;

	    @Override
	    public void eval() {
		Connector left = getLeftConnectors().get(0);
		Connector right = getRightConnectors().get(0);
		if (left.getVoltage() - right.getVoltage() > threshold) {
		    right.setVoltage(left.getVoltage() - threshold);
		} else if (right.getVoltage() - left.getVoltage() > threshold) {
		    left.setVoltage(right.getVoltage() - threshold);
		}
	    }
	};
	lamp.getLeftConnectors().add(new Connector(IOType.BOTH));
	lamp.getRightConnectors().add(new Connector(IOType.BOTH));
	return lamp;
    }

    public String getName() {
	return name;
    }

    public List<Connector> getTopConnectors() {
	return topConnectors;
    }

    public List<Connector> getBottomConnectors() {
	return bottomConnectors;
    }

    public List<Connector> getLeftConnectors() {
	return leftConnectors;
    }

    public List<Connector> getRightConnectors() {
	return rightConnectors;
    }

    public Connector getConnector(String name) {
	for (Connector connector : topConnectors) {
	    if (connector.getName().equals(name)) {
		return connector;
	    }
	}
	for (Connector connector : bottomConnectors) {
	    if (connector.getName().equals(name)) {
		return connector;
	    }
	}
	for (Connector connector : leftConnectors) {
	    if (connector.getName().equals(name)) {
		return connector;
	    }
	}
	for (Connector connector : rightConnectors) {
	    if (connector.getName().equals(name)) {
		return connector;
	    }
	}
	return null;
    }

    public void setName(String name) {
	this.name = name;
    }

    public abstract void eval();
}
