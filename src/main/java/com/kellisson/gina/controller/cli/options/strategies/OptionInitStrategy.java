package com.kellisson.gina.controller.cli.options.strategies;

import com.kellisson.gina.controller.UseCaseStrategy;
import com.kellisson.gina.useCase.init.InitInputData;
import com.kellisson.gina.useCase.init.InitUseCase;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "init")
public class OptionInitStrategy implements UseCaseStrategy<InitInputData, InitUseCase>, Runnable {
	
	@Parameters(paramLabel = "directory", description = "local do repositório")
	public String directory;
	
	@Override
	public InitInputData getInputData() {
		return new InitInputData();
	}

	@Override
	public InitUseCase getUseCase() {
		return new InitUseCase();
	}

	@Override
	public void run() {
		InitInputData initInputData = getInputData(); 
		initInputData.setDirectory(directory);
		getUseCase().execute(initInputData);
	}

}
