package com.github.steevedroz.tinbap.components;

public abstract class Component {
    private String name;

    public Component(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public abstract void eval();
}
