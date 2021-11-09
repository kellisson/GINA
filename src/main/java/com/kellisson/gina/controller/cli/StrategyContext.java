package com.kellisson.gina.controller.cli;

import java.util.NoSuchElementException;

import com.kellisson.gina.controller.UseCaseStrategy;
import com.kellisson.gina.useCase.UseCase;

public interface StrategyContext<T> {

	public UseCaseStrategy<?, ? extends UseCase<?>> getStrategy(T command) throws NoSuchElementException;
}
