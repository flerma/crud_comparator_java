package br.com.amil.entity.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Test;

import br.com.amil.entity.Chegada;
import br.com.amil.entity.OrdemChegada;
import br.com.amil.entity.Piloto;
import br.com.amil.entity.Volta;

public class OrdemChegadaTest {
	
	@Test
	public void testaGetOrdemChegada() throws ParseException {
		
		List<Volta> voltas = new ArrayList<>();
		
		Volta volta1 = new Volta();
		volta1.setNumero(1);
		String tempo_volta = "1:02.852";
		Calendar horaFormatada = Calendar.getInstance();
		horaFormatada.setTime(new SimpleDateFormat("mm:ss.SSS").parse(tempo_volta));
		volta1.setTempo(horaFormatada);
		
		Piloto piloto = new Piloto();
		piloto.setId(1);
		piloto.setNome("Fernando");
		volta1.setPiloto(piloto);
		voltas.add(volta1);
		
		Volta volta2 = new Volta();
		volta2.setNumero(1);
		tempo_volta = "1:01.852";
		horaFormatada = Calendar.getInstance();
		horaFormatada.setTime(new SimpleDateFormat("mm:ss.SSS").parse(tempo_volta));
		volta2.setTempo(horaFormatada);		
		piloto = new Piloto();
		piloto.setId(2);
		piloto.setNome("Joao");
		volta2.setPiloto(piloto);
		voltas.add(volta2);
		
		Volta volta3 = new Volta();
		volta3.setNumero(1);
		tempo_volta = "1:03.852";
		horaFormatada = Calendar.getInstance();
		horaFormatada.setTime(new SimpleDateFormat("mm:ss.SSS").parse(tempo_volta));
		volta3.setTempo(horaFormatada);		
		piloto = new Piloto();
		piloto.setId(3);
		piloto.setNome("Jose");
		volta3.setPiloto(piloto);
		voltas.add(volta3);
		
		List<Chegada> lstChegada = new OrdemChegada().getLstChegada(voltas);
		
		assertEquals(2, lstChegada.size());

	}
	
//	@Test
//	public void imprimeOrdemChegada(List<Chegada> ordemChegada) {
//		int posicao = 0;
//		for (Chegada chegada : ordemChegada) {
//			posicao++;
//			DateFormat formatadordata = new SimpleDateFormat("mm:ss:SSS");
//			String dataFormatada = formatadordata.format(chegada.getTempoTotalProva().getTime());
//			System.out.println("Posição: " + posicao + " Id: " + chegada.getPiloto().getId() + " Piloto: "
//					+ chegada.getPiloto().getNome() + " Quantidade de voltas: " + chegada.getQtdeVoltasCompletadas()
//					+ " Tempo " + dataFormatada);
//
//		}
//	}
}
