package com.github.steevedroz.tinbap.components;

import java.util.List;

@Deprecated
public class PinPoint extends Component {
    private static final String NAME = "Pin point";

    public PinPoint() {
	super(NAME);
    }

    @Override
    protected void eval() {
	double maxFinder = 0;
	for (Connector connector : connectors) {
	    maxFinder = Math.max(connector.getVoltage(), maxFinder);
	}

	final double max = maxFinder;
	connectors.forEach(connector -> connector.setVoltage(max));
    }

    public List<Connector> getConnectors() {
	return connectors;
    }
}
