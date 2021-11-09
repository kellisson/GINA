package com.kellisson.gina.controller;

import com.kellisson.gina.useCase.UseCase;

public interface UseCaseStrategy<T, T2 extends UseCase<T>> {

	public T getInputData();
	
	public T2 getUseCase();
}
