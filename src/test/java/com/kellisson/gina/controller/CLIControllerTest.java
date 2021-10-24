package com.kellisson.gina.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.kellisson.gina.useCase.InputData;

public class CLIControllerTest {

	@Test
	public void initCommandTest() {
		String command = "gina init";
		Assertions.assertNotNull(CLIController.getCommand(command));
		InputData inputData = CLIController.getInputData(command);
		Assertions.assertEquals("init", inputData.getCommand());
	}

	@Test
	public void invalidCommandTest() {
		String command = null;
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			CLIController.getCommand(command);
		});
	}
}
