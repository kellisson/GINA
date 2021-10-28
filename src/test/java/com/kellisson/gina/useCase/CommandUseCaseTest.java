package com.kellisson.gina.useCase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommandUseCaseTest {

	@Test
	public void getInitUseCaseTest() {
		String useCase = "init";
		Assertions.assertNotNull(GINACommandUseCase.getUseCase(useCase));
	}
}
