package com.github.steevedroz.tinbap.components;

import java.util.ArrayList;
import java.util.List;

import com.github.steevedroz.tinbap.IOType;

public class Connector extends Component {
    private static final String NAME = "Connector";

    private String name;
    private IOType type;
    private double voltage;
    private List<Connector> connectors;

    public Connector(IOType type) {
	super(NAME);
	this.type = type;
	this.connectors = new ArrayList<Connector>();
    }

    public Connector(String name, IOType type) {
	this(type);
	this.name = name;
    }

    public void send() {
	for (Connector connector : connectors) {
	    if (connector != null && this.canSend()) {
		connector.receive(this);
	    }
	}
    }

    public boolean canSend() {
	switch (type) {
	case BOTH:
	case OUT:
	    return true;
	default:
	    return false;
	}
    }

    public boolean canReceive() {
	switch (type) {
	case BOTH:
	case IN:
	    return true;
	default:
	    return false;
	}
    }

    public void pair(Connector other) {
	this.connectors.add(other);
	other.connectors.add(this);
    }

    public String getName() {
	return name;
    }

    public IOType getType() {
	return type;
    }

    public double getVoltage() {
	return voltage;
    }

    public void setName(String name) {
	this.name = name;
    }

    public void setType(IOType type) {
	this.type = type;
    }

    public void setVoltage(double voltage) {
	this.voltage = Math.max(voltage, 0);
    }

    private void receive(Connector connector) {
	if (connector != null && this.canReceive()) {
	    this.setVoltage(Math.max(connector.getVoltage(), this.getVoltage()));
	}
    }

    @Override
    protected void eval() {
	send();
    }
}
