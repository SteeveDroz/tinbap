package com.github.steevedroz.tinbap.components;

import com.github.steevedroz.tinbap.Connector;
import com.github.steevedroz.tinbap.IOType;

public class Ground extends Component {
    private static final String NAME = "Ground";

    private Connector collector;

    public Ground() {
	super(NAME);
	this.collector = new Connector(IOType.IN);
	this.connectors.add(this.collector);
    }

    @Override
    protected void eval() {
	collector.setVoltage(0);
    }
}
