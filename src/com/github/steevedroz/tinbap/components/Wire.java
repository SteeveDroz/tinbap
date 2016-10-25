package com.github.steevedroz.tinbap.components;

import com.github.steevedroz.tinbap.Connector;
import com.github.steevedroz.tinbap.IOType;

public class Wire extends Component {
    private static final String NAME = "Wire";

    private Connector left;
    private Connector right;

    public Wire() {
	super(NAME);
	this.left = new Connector(IOType.BOTH);
	this.right = new Connector(IOType.BOTH);
	this.connectors.add(this.left);
	this.connectors.add(this.right);
    }

    @Override
    protected void eval() {
	double max = Math.max(left.getVoltage(), right.getVoltage());
	left.setVoltage(max);
	right.setVoltage(max);
    }
}
