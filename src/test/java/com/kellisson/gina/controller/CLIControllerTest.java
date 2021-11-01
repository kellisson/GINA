package com.kellisson.gina.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.kellisson.gina.controller.cli.CLIController;
import com.kellisson.gina.controller.cli.options.CLIOptions;
import com.kellisson.gina.useCase.InputData;
import com.kellisson.gina.useCase.UseCase;

public class CLIControllerTest {

	private CLIController cliController;

	@BeforeEach
	public void loadController() {
		cliController = new CLIController(new CLIOptions());
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"init","add","commit","push","pull","diff","checkout"})
	public void inputDataTest(String command) {
		Assertions.assertNotNull(cliController.getInputData(command));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"init","add","commit","push","pull","diff","checkout"})
	public void validInputDataTest(String command) {
		InputData inputData = cliController.getInputData(command);
		Assertions.assertEquals(command, inputData.getCommand());
	}

	@ParameterizedTest
	@ValueSource(strings = {"init","add","commit","push","pull","diff","checkout"})
	public void validUseCasesTest(String command) {
		UseCase useCase = cliController.getUseCase(command);
		Assertions.assertNotNull(useCase);
	}
	
	@Test
	public void invalidCommandTest() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> cliController.setStrategy(null));
	}
}
