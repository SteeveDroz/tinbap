package com.github.steevedroz.tinbap.components;

import java.util.ArrayList;
import java.util.List;

import com.github.steevedroz.tinbap.Component;
import com.github.steevedroz.tinbap.Connector;

public class PinPoint extends Component {
    private static final String NAME = "Pin point";
    private List<Connector> connectors;

    public PinPoint() {
	super(NAME);

	this.connectors = new ArrayList<Connector>();
    }

    @Override
    public void eval() {
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
