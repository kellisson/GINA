package com.kellisson.gina.controller;

import com.kellisson.gina.useCase.InputData;

public class CLIController {

	public static final String INIT = "init";
	public static final String ADD = "add";
	public static final String COMMIT = "commit";
	public static final String PUSH = "push";
	public static final String PULL = "pull";
	public static final String DIFF = "diff";
	public static final String CHECKOUT = "checkout";

	public static String getCommand(String command) throws IllegalArgumentException {
		if (!(command == null || command.isBlank())){
			if(command.equals("init"))
			  return INIT;
			if(command.equals("add"))
			  return ADD;
			if(command.equals("commit"))
			  return COMMIT;
			if(command.equals("push"))
			  return PUSH;
			if(command.equals("pull"))
			  return PULL;
			if(command.equals("diff"))
			  return DIFF;
			if(command.equals("checkout"))
			  return CHECKOUT;
		}
		throw new IllegalArgumentException();
	}

	public static InputData getInputData(String command) {
		InputData inputData = new InputData();
		inputData.setCommand(getCommand(command));
		return inputData;
	}

}
