package com.github.steevedroz.tinbap.components;

import com.github.steevedroz.tinbap.Component;
import com.github.steevedroz.tinbap.Connector;
import com.github.steevedroz.tinbap.IOType;

public class Transistor extends Component {
    private static final String NAME = "Transistor";
    private static final double THRESHOLD = 0.2;

    private Connector base;
    private Connector collector;
    private Connector emitter;
    private double threshold;

    public Transistor() {
	this(THRESHOLD);
    }

    public Transistor(double threshold) {
	super(NAME);
	this.base = new Connector("Base", IOType.IN);
	this.collector = new Connector("Collector", IOType.BOTH);
	this.emitter = new Connector("Emitter", IOType.BOTH);
	this.threshold = threshold;
    }

    @Override
    public void eval() {
	if (base.getVoltage() > threshold) {
	    double maxVoltage = Math.max(collector.getVoltage(), emitter.getVoltage());
	    collector.setVoltage(maxVoltage);
	    emitter.setVoltage(maxVoltage);
	}
    }

    public double getThreshold() {
	return threshold;
    }

    public void setThreshold(double threshold) {
	this.threshold = threshold;
    }
}
