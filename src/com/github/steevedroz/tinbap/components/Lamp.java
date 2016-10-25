package com.github.steevedroz.tinbap.components;

import com.github.steevedroz.tinbap.Connector;
import com.github.steevedroz.tinbap.IOType;

public class Lamp extends Component {
    private static final String NAME = "Lamp";
    private static final double THRESHOLD = 1.0;

    private Connector left;
    private Connector right;
    private double threshold;

    public Lamp() {
	this(THRESHOLD);
    }

    public Lamp(double threshold) {
	super(NAME);
	this.left = new Connector(IOType.BOTH);
	this.right = new Connector(IOType.BOTH);
	this.threshold = threshold;
    }

    @Override
    public void eval() {
	if (isOn()) {
	    Connector in = (left.getVoltage() > right.getVoltage()) ? left : right;
	    Connector out = (left.getVoltage() > right.getVoltage()) ? right : left;

	    out.setVoltage(in.getVoltage() - threshold);
	}
    }

    public double getThreshold() {
	return threshold;
    }

    public boolean isOn() {
	return Math.abs(left.getVoltage() - right.getVoltage()) >= threshold;
    }

    public void setThreshold(double threshold) {
	this.threshold = threshold;
    }
}
