package com.kellisson.gina.controller;

import com.kellisson.gina.useCase.InputData;
import com.kellisson.gina.useCase.UseCase;

public interface UseCaseStrategy<T extends InputData, T2 extends UseCase> {

	public T getInputData();
	
	public T2 getUseCase();
}
