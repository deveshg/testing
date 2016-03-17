package com.example.app.api.rectangle.impl;

import com.example.app.api.rectangle.Rectangle;

public class RectangleImpl implements Rectangle {

	@Override
	public int area(int width, int height) {
		return width*height;
	}
	
}