package com.kellisson.gina.controller.cli.options;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.cli.Option;

import com.kellisson.gina.controller.InitUseCaseStrategy;
import com.kellisson.gina.controller.UseCaseStrategy;
import com.kellisson.gina.controller.cli.StrategyContext;
import com.kellisson.gina.controller.cli.options.strategies.OptionInitStrategy;
import com.kellisson.gina.useCase.InputData;
import com.kellisson.gina.useCase.UseCase;

public class CLIOptions implements StrategyContext {

	private List<InitUseCaseStrategy<Option>> optionsUseCaseList;

	private Option getINITOption() {
		return Option.builder("init").hasArg().numberOfArgs(1).build();
	}

	private Option getADDOption() {
		return Option.builder("add").hasArg().build();
	}

	private Option getCOMMITOption() {
		return Option.builder("commit").hasArg().numberOfArgs(1).build();
	}

	private Option getPUSHOption() {
		return Option.builder("push").hasArg(false).build();
	}

	private Option getPULLOption() {
		return Option.builder("pull").hasArg(false).build();
	}

	private Option getDIFFOption() {
		return Option.builder("diff").hasArg().numberOfArgs(1).build();
	}

	private Option getCHECKOUTOption() {
		return Option.builder("checkout").hasArg().numberOfArgs(1).build();
	}

	public CLIOptions() {
		this.optionsUseCaseList = loadMap();
	}

	private List<InitUseCaseStrategy<Option>> loadMap() {
		List<InitUseCaseStrategy<Option>> optionsUseCaseList = new ArrayList<InitUseCaseStrategy<Option>>();
		optionsUseCaseList.add(new OptionInitStrategy(getINITOption()));
		optionsUseCaseList.add(new OptionInitStrategy(getADDOption()));
		optionsUseCaseList.add(new OptionInitStrategy(getCHECKOUTOption()));
		optionsUseCaseList.add(new OptionInitStrategy(getCOMMITOption()));
		optionsUseCaseList.add(new OptionInitStrategy(getDIFFOption()));
		optionsUseCaseList.add(new OptionInitStrategy(getPULLOption()));
		optionsUseCaseList.add(new OptionInitStrategy(getPUSHOption()));

		return optionsUseCaseList;
	}

	@Override
	public UseCaseStrategy<InputData, UseCase> getStrategy(String command) throws NoSuchElementException {
		return optionsUseCaseList.stream().filter(option -> option.getInput().getOpt().equals(command)).findFirst()
				.orElseThrow();
	}

}
