package com.github.steevedroz.tinbap.components;

import com.github.steevedroz.tinbap.IOType;

public class Source extends Component {
    private static final String NAME = "Source";
    private static final double VOLTAGE = 5.0;

    private double voltage;
    private Connector emitter;

    public Source() {
	this(VOLTAGE);
    }

    public Source(double voltage) {
	super(NAME);
	this.voltage = voltage;
	this.emitter = new Connector(IOType.OUT);
	this.connectors.add(this.emitter);
    }

    @Override
    protected void eval() {
	emitter.setVoltage(voltage);
    }

    public double getVoltage() {
	return voltage;
    }

    public void setVoltage(double voltage) {
	this.voltage = voltage;
    }
}
