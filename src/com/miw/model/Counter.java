package com.miw.model;

public class Counter {
	private Integer value = 0;

	public Integer getValue() {
		return value;
	}

	public void increment() {
		value++;
	}

	public String toString() {
		return value.toString();
	}
}
