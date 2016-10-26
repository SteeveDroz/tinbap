package com.github.steevedroz.tinbap.components;

import com.github.steevedroz.tinbap.IOType;

public class Diode extends Component {
    private static final String NAME = "Diode";

    private Connector in;
    private Connector out;

    public Diode() {
	super(NAME);
	this.in = new Connector("In", IOType.IN);
	this.out = new Connector("Out", IOType.OUT);
	this.connectors.add(this.in);
	this.connectors.add(this.out);
    }

    @Override
    protected void eval() {
	out.setVoltage(Math.max(in.getVoltage(), out.getVoltage()));
    }
}
