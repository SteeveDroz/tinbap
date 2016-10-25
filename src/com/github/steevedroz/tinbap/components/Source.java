package com.github.steevedroz.tinbap.components;

import com.github.steevedroz.tinbap.Connector;
import com.github.steevedroz.tinbap.IOType;

public class Source extends Component {
    private static final String NAME = "Source";
    private static final double VOLTAGE = 5.0;

    private double voltage;
    private Connector out;

    public Source() {
	this(VOLTAGE);
    }

    public Source(double voltage) {
	super(NAME);
	this.voltage = voltage;
	this.out = new Connector(IOType.OUT);
    }

    @Override
    public void eval() {
	out.setVoltage(voltage);
    }

    public double getVoltage() {
	return voltage;
    }

    public void setVoltage(double voltage) {
	this.voltage = voltage;
    }
}
