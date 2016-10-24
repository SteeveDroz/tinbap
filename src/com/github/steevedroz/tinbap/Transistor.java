package com.github.steevedroz.tinbap;

public class Transistor extends Component {
    private static final String NAME = "Transistor";

    private Connector base;
    private Connector collector;
    private Connector emitter;

    public Transistor() {
	super(NAME);
	this.base = new Connector("Base", IOType.IN);
	this.collector = new Connector("Collector", IOType.BOTH);
	this.emitter = new Connector("Emitter", IOType.BOTH);
    }

    @Override
    public void eval() {
	if (base.getVoltage() > 0.2) {
	    double maxVoltage = Math.max(collector.getVoltage(), emitter.getVoltage());
	    collector.setVoltage(maxVoltage);
	    emitter.setVoltage(maxVoltage);
	}
    }
}
