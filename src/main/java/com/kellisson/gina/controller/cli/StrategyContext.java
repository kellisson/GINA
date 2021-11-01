package com.kellisson.gina.controller.cli;

import java.util.NoSuchElementException;

import com.kellisson.gina.controller.UseCaseStrategy;
import com.kellisson.gina.useCase.InputData;
import com.kellisson.gina.useCase.UseCase;

public interface StrategyContext {

	public UseCaseStrategy<InputData, UseCase> getStrategy(String command) throws NoSuchElementException;
}
