package com.kellisson.gina.controller;

import com.kellisson.gina.useCase.InputData;

public class CLIController {

	public static final String INIT = "init";

	public static String getCommand(String command) throws IllegalArgumentException {
		if (command == null || command.isBlank())
			throw new IllegalArgumentException();
		if (command.equals("gina init"))
			return INIT;
		throw new IllegalArgumentException();
	}

	public static InputData getInputData(String command) {
		InputData inputData = new InputData();
		inputData.setCommand(getCommand(command));
		return inputData;
	}

}
