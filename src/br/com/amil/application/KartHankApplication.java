package br.com.amil.application;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.com.amil.entity.Chegada;
import br.com.amil.entity.OrdemChegada;
import br.com.amil.entity.Volta;
import br.com.amil.util.ProjectUtils;

public class KartHankApplication {

	public static void main(String[] args) {

		List<Volta> voltas = new ArrayList<Volta>();
		File logCorrida = new File("log_corrida");
		List<String> lstLogCorrida = ProjectUtils.read(logCorrida);

		lstLogCorrida.remove(0);
		voltas = new Volta().getLogCorridaVoltas(lstLogCorrida);

		List<Chegada> ordemChegada = new ArrayList<>();
		ordemChegada = new OrdemChegada().getLstChegada(voltas);
		new OrdemChegada().imprimeOrdemChegada(ordemChegada);
	}

}
