package com.kellisson.gina.controller;

import com.kellisson.gina.useCase.InputData;
import com.kellisson.gina.useCase.UseCase;
import com.kellisson.gina.useCase.init.InitInputData;
import com.kellisson.gina.useCase.init.InitUseCase;

public abstract class InitUseCaseStrategy<T> implements UseCaseStrategy<InputData, UseCase> {

	protected abstract InitInputData createInputData(T input);
	
	protected abstract InitUseCase createUseCase(T input);
	
	protected InitInputData inputData;
	
	protected InitUseCase useCase;
	
	protected T input;
	
	public InitUseCaseStrategy(T input) {
		this.inputData = createInputData(input);
		this.useCase = createUseCase(input);
		this.input = input;
	}
	
	@Override
	public InputData getInputData() {
		return inputData;
	}

	@Override
	public UseCase getUseCase() {
		return useCase;
	}

	public T getInput() {
		return input;
	}

}
