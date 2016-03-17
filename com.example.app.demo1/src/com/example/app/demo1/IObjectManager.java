package com.example.app.demo1;

public interface IObjectManager {

	<T> T getExternalTool(Class<T> t);

	
	public void readRegistry() ;
	
}