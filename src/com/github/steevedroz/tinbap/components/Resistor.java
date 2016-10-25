package com.github.steevedroz.tinbap.components;

import com.github.steevedroz.tinbap.Connector;
import com.github.steevedroz.tinbap.IOType;

public class Resistor extends Component {
    private static final String NAME = "Resistor";
    private static final double RESISTIVITY = 1;

    private double resistivity;
    private Connector left;
    private Connector right;

    public Resistor() {
	this(RESISTIVITY);
    }

    public Resistor(double resisitvity) {
	super(NAME);

	this.resistivity = resisitvity;
	left = new Connector(IOType.BOTH);
	right = new Connector(IOType.BOTH);
    }

    @Override
    public void eval() {
	if (left.getVoltage() > right.getVoltage()) {
	    right.setVoltage(Math.min(right.getVoltage(), left.getVoltage() - resistivity));
	} else {
	    left.setVoltage(Math.min(left.getVoltage(), right.getVoltage() - resistivity));
	}
    }
}
