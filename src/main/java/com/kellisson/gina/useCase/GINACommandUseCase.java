package com.kellisson.gina.useCase;

import com.kellisson.gina.useCase.init.InitUseCase;

public class GINACommandUseCase {

	public static Object getUseCase(String useCase) {
		// TODO Auto-generated method stub
		return new InitUseCase();
	}

}
