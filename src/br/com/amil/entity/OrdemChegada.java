package br.com.amil.entity;

import static br.com.amil.entity.Chegada.OrdenadorSort.TEMPO_TOTAL_PROVA;
import static br.com.amil.entity.Chegada.OrdenadorSort.VOLTAS_COMPLETADAS;
import static br.com.amil.entity.Chegada.OrdenadorSort.combinarOrdenacoes;
import static br.com.amil.entity.Chegada.OrdenadorSort.ordenacaoInvertida;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class OrdemChegada {

	public List<Chegada> getLstChegada(List<Volta> voltas) {

		List<Chegada> ordemChegada = new ArrayList<>();
		int lstVoltasSize = voltas.size();
		int qtdVoltas = 0;
		long tempoTotalProva = 0L;
		Piloto pilotoAnterior = lstVoltasSize > 0 ? voltas.get(0).getPiloto() : null;
		
		for (Volta volta : voltas) {
			System.out.println(volta.getPiloto().getNome());
			if (pilotoAnterior.equals(volta.getPiloto())) {
				qtdVoltas++;
				tempoTotalProva += volta.getTempo().getTimeInMillis();
				if (voltas.get(voltas.size() - 1).equals(volta)) {
					Chegada chegada = new Chegada();
					chegada.setPiloto(pilotoAnterior);
					chegada.setQtdeVoltasCompletadas(qtdVoltas);
					Calendar cal = Calendar.getInstance();
					cal.setTimeInMillis(tempoTotalProva);
					chegada.setTempoTotalProva(cal);
					ordemChegada.add(chegada);
				}
			} else if (voltas.get(voltas.size()-1).equals(volta) 
					&& qtdVoltas == 1) {
				tempoTotalProva += volta.getTempo().getTimeInMillis();
				Chegada chegada = new Chegada();
				chegada.setPiloto(volta.getPiloto());
				chegada.setQtdeVoltasCompletadas(qtdVoltas);
				Calendar cal = Calendar.getInstance();
				cal.setTimeInMillis(tempoTotalProva);
				chegada.setTempoTotalProva(cal);
				ordemChegada.add(chegada);
			} else {
				Chegada chegada = new Chegada();
				chegada.setPiloto(pilotoAnterior);
				chegada.setQtdeVoltasCompletadas(qtdVoltas);
				Calendar cal = Calendar.getInstance();
				cal.setTimeInMillis(tempoTotalProva);
				chegada.setTempoTotalProva(cal);
				ordemChegada.add(chegada);
				qtdVoltas = 1;
				tempoTotalProva = 0L;
			}
			pilotoAnterior = volta.getPiloto();
		}

		Collections.sort(ordemChegada, combinarOrdenacoes(ordenacaoInvertida(VOLTAS_COMPLETADAS), TEMPO_TOTAL_PROVA));
		return ordemChegada;
	}
	
	public void imprimeOrdemChegada(List<Chegada> ordemChegada) {
		int posicao = 0;
		for (Chegada chegada : ordemChegada) {
			posicao++;
			DateFormat formatadordata = new SimpleDateFormat("mm:ss:SSS");
			String dataFormatada = formatadordata.format(chegada.getTempoTotalProva().getTime());
			System.out.println("Posição: " + posicao
			+ " Id: " + chegada.getPiloto().getId()
			+ " Piloto: " + chegada.getPiloto().getNome()
			+ " Quantidade de voltas: " + chegada.getQtdeVoltasCompletadas()
			+ " Tempo " + dataFormatada);
			
		}
	}
}
