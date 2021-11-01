package com.kellisson.gina.controller;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.kellisson.gina.controller.cli.StrategyContext;
import com.kellisson.gina.controller.cli.options.CLIOptions;

public class CLIOptionsTest {
	
	@Test
	public void commandParserTest() {
		String[] args = {"init","add","commit","push","pull","diff","checkout"};
		StrategyContext cliStrategy = new CLIOptions();
		Arrays.asList(args).forEach(arg -> Assertions.assertNotNull(cliStrategy.getStrategy(arg)));
		Assertions.assertThrows(NoSuchElementException.class, () -> cliStrategy.getStrategy("not a GINA command"));
	}
}
