package com.kellisson.gina.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.kellisson.gina.controller.cli.options.CLIOptions;
import com.kellisson.gina.controller.cli.options.strategies.OptionInitStrategy;
import picocli.CommandLine;

public class CLIInitSubCommandTest {

	@Test
	public void commandParserTest() {
		String[] args = {"init","-d","."};
		CLIOptions initStrategy = new CLIOptions();
		CommandLine commandLine = new CommandLine(initStrategy);
		Assertions.assertTrue(commandLine.parseArgs(args).hasSubcommand());

		args = new String[] {"init"};
		Assertions.assertTrue(commandLine.parseArgs(args).hasSubcommand());
		commandLine.execute(args);
	}
	
	@Test
	public void initialBranchTest() {
		String[] args = {"-d",".", "-b","mister"};
		OptionInitStrategy initStrategy = new OptionInitStrategy();

		CommandLine commandLine = new CommandLine(initStrategy);
		commandLine.parseArgs(args);
		Assertions.assertEquals("mister", initStrategy.getInitialBranch());
		Assertions.assertEquals(".", initStrategy.getDirectory());
		
		commandLine.execute(args);
		Assertions.assertEquals("mister", initStrategy.getInputData().getInitialBranch());
		Assertions.assertEquals(".", initStrategy.getInputData().getDirectory());
		
		args = new String[] {};
		initStrategy = new OptionInitStrategy();
		commandLine = new CommandLine(initStrategy);
		Assertions.assertNull(initStrategy.getInitialBranch());
		Assertions.assertNull(initStrategy.getDirectory());
		
		commandLine.execute(args);
		Assertions.assertNull(initStrategy.getInputData().getInitialBranch());
		Assertions.assertNull(initStrategy.getInputData().getDirectory());
		
		Path path = Paths.get(".gina");
		Assertions.assertTrue(Files.exists(path));
	}
}
