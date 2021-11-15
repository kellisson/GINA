package com.kellisson.gina.controller.cli.options.strategies;

import com.kellisson.gina.controller.UseCaseStrategy;
import com.kellisson.gina.useCase.init.InitInputData;
import com.kellisson.gina.useCase.init.InitUseCase;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "init")
public class OptionInitStrategy implements UseCaseStrategy<InitInputData, InitUseCase>, Runnable {
	
	private InitInputData initInputData;
	
	@Option(names = {"-b", "--initial-branch"}, description = "nome do branch inicial do repositório")
	private String initialBranch;
	
	@Option(names = {"-d", "--location"}, description = "local do repositório")
	private String directory;
	
	@Override
	public InitInputData getInputData() {
		return initInputData;
	}

	@Override
	public InitUseCase getUseCase() {
		return new InitUseCase();
	}

	@Override
	public void run() {
		this.initInputData = createInputData();
		getUseCase().execute(getInputData());
	}

	private InitInputData createInputData() {
		InitInputData initInputData = new InitInputData();
		initInputData.setDirectory(directory);
		initInputData.setInitialBranch(initialBranch);
		return initInputData;
	}

	public String getInitialBranch() {
		return initialBranch;
	}

	public void setInitialBranch(String initialBranch) {
		this.initialBranch = initialBranch;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

}
