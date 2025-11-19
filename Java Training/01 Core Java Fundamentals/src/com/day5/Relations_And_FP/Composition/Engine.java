package com.day5.Relations_And_FP.Composition;

import java.util.ArrayList;
import java.util.List;

public class Engine {

	private String engineName;
	private List<Car> carNames = new ArrayList<>();

	Engine(String engineName) {
		this.engineName = engineName;
	}

	public String getEngineName() {
		return engineName;
	}
	
}
