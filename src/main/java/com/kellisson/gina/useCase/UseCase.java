package com.kellisson.gina.useCase;

public interface UseCase<T> {

	void execute(T inputData);
}
