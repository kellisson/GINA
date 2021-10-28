package com.kellisson.gina.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.kellisson.gina.useCase.InputData;

public class CLIControllerTest {

	@ParameterizedTest
	@ValueSource(strings = {"init","add","commit","push","pull","diff","checkout"})
	public void validCommandsTest(String command) {
		Assertions.assertNotNull(CLIController.getCommand(command));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"init","add","commit","push","pull","diff","checkout"})
	public void validCommandValuesTest(String command) {
		InputData inputData = CLIController.getInputData(command);
		Assertions.assertEquals(command, inputData.getCommand());
	}
	
	@Test
	public void invalidCommandTest() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> CLIController.getCommand(null));
	}
}
