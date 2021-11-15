package com.kellisson.gina.useCase.init;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.kellisson.gina.useCase.UseCase;

public class InitUseCase implements UseCase<InitInputData> {

	@Override
	public void execute(InitInputData inputData) {
		// TODO criar pasta .gina no local indicado por inputData.getDirectory
		StringBuilder directoryPath = new StringBuilder();
		if(inputData.getDirectory() == null || inputData.getDirectory().isBlank()) {
			directoryPath.append(".");
		} else {
			directoryPath.append(inputData.getDirectory());
		}
		directoryPath.append("gina");
		Path path = Paths.get(directoryPath.toString());
		if(!Files.exists(path)) {
			try {
				Files.createDirectory(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO criar branch com o nome definido por inputData.getInitialBranch
	}

}
