package com.kellisson.gina.controller.cli;

import com.kellisson.gina.controller.UseCaseStrategy;
import com.kellisson.gina.useCase.InputData;
import com.kellisson.gina.useCase.UseCase;

public class CLIController {

	private StrategyContext strategyContext;
	
	private UseCaseStrategy<InputData, UseCase> useCaseStrategy;
	
	public CLIController(StrategyContext strategyContext) {
		this.strategyContext = strategyContext;
	}
	
	public void setStrategy(String command) throws IllegalArgumentException {
		if (!(command == null || command.isBlank())){
			useCaseStrategy = strategyContext.getStrategy(command);
		} else {
			throw new IllegalArgumentException();
		}
	}

	public InputData getInputData(String command) {
		setStrategy(command);
		return useCaseStrategy.getInputData();
	}

	public UseCase getUseCase(String command) {
		setStrategy(command);
		return useCaseStrategy.getUseCase();
	}

}
