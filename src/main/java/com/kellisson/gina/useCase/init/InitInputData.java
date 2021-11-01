package com.kellisson.gina.useCase.init;

import com.kellisson.gina.useCase.InputData;

public class InitInputData implements InputData {

	private String command;

	@Override
	public String getCommand() {
		return command;
	}

	@Override
	public void setCommand(String command) {
		this.command = command;
	}

}
