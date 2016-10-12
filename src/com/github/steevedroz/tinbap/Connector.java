package com.github.steevedroz.tinbap;

public class Connector {
    private String name;
    private IOType type;
    private double voltage;

    public Connector(IOType type) {
	this.type = type;
    }

    public Connector(String name, IOType type) {
	this(type);
	this.name = name;
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
}
