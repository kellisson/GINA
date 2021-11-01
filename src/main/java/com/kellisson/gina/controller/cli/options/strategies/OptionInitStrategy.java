package com.kellisson.gina.controller.cli.options.strategies;

import org.apache.commons.cli.Option;

import com.kellisson.gina.controller.InitUseCaseStrategy;
import com.kellisson.gina.useCase.init.InitInputData;
import com.kellisson.gina.useCase.init.InitUseCase;

public class OptionInitStrategy extends InitUseCaseStrategy<Option> {

	public OptionInitStrategy(Option input) {
		super(input);
	}
	
	@Override
	protected InitInputData createInputData(Option input) {
		InitInputData inputData = new InitInputData();
		inputData.setCommand(input.getOpt());
		return inputData;
	}

	@Override
	protected InitUseCase createUseCase(Option input) {
		return new InitUseCase();
	}

}
