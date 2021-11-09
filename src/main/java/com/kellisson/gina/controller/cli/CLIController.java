package com.kellisson.gina.controller.cli;

import com.kellisson.gina.controller.cli.options.CLIOptions;

import picocli.CommandLine;

public class CLIController {

	public void execute(String[] command) {
		CommandLine cmd = new CommandLine(new CLIOptions());
		cmd.execute(command);
	}

}
