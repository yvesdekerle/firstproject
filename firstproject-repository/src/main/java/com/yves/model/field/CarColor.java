package com.yves.model.field;

public class CarColor {

	private String color1;
	
	private String color2;

	public CarColor() {
		super();
	}

	public CarColor(String color1, String color2) {
		super();
		this.color1 = color1;
		this.color2 = color2;
	}

	public String getColor1() {
		return color1;
	}

	public void setColor1(String color1) {
		this.color1 = color1;
	}

	public String getColor2() {
		return color2;
	}

	public void setColor2(String color2) {
		this.color2 = color2;
	}

	@Override
	public String toString() {
		return "CarColor [color1=" + color1 + ", color2=" + color2 + "]";
	}
}
