package com.example.app.api.circle.impl;

import com.example.app.api.circle.Circle;

public class CircleImpl implements Circle {

	@Override
	public double area(double rad) {
		return Math.PI * Math.pow(rad, 2);
	}

}