package com.kellisson.gina.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kellisson.gina.controller.cli.CLIController;

public class CLIControllerTest {

	private CLIController cliController;

	@BeforeEach
	public void loadController() {
		cliController = new CLIController();
	}
	
	@Test
	public void invalidCommandTest() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> cliController.execute(null));
	}
}
