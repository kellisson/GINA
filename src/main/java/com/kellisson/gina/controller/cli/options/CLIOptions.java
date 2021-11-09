package com.kellisson.gina.controller.cli.options;

import com.kellisson.gina.controller.cli.options.strategies.OptionInitStrategy;

import picocli.CommandLine.Command;

@Command(subcommands = {OptionInitStrategy.class})
public class CLIOptions {

}
