package br.com.amil.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Volta implements Comparator<Volta>{
	
	private int numero;
	private Calendar hora;
	private Piloto piloto;
	private Calendar tempo;
	private float velocidadeMedia;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Calendar getTempo() {
		return tempo;
	}
	public void setTempo(Calendar tempo) {
		this.tempo = tempo;
	}
	public float getVelocidadeMedia() {
		return velocidadeMedia;
	}
	public void setVelocidadeMedia(float velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
	}
	public Calendar getHora() {
		return hora;
	}
	public void setHora(Calendar hora) {
		this.hora = hora;
	}
	public Piloto getPiloto() {
		return piloto;
	}
	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}
	@Override
	public int compare(Volta o1, Volta o2) {
		Integer volta1 = o1.getPiloto().getId();
	    Integer volta2 = o2.getPiloto().getId();
	    
		if (volta1 > volta2)
			return 1;
		if (volta1 < volta2)
			return -1;
		return 0;
	}
	
	public List<Volta> getLogCorridaVoltas(List<String> lstLogCorrida) {
		
		List<Volta> voltas = new ArrayList<>();
		
		for (String linha : lstLogCorrida) {
			
			String[] arrLinha = linha.replace(" ", "").split("\t");
			List<String> lstLinha = new ArrayList<String>(Arrays.asList(arrLinha));
			lstLinha.removeAll(Arrays.asList(""));
			
			Volta volta = new Volta();
			try {
				String hora = lstLinha.get(LogCorridaEnum.HORA.getPosicao()).trim();
				Calendar horaFormatada = Calendar.getInstance();
				horaFormatada.setTime(new SimpleDateFormat("HH:mm:ss.SSS").parse(hora));
				
				volta.setHora(horaFormatada);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			Piloto piloto = new Piloto();
			
			String infoPiloto = lstLinha.get(LogCorridaEnum.PILOTO.getPosicao()).trim();
			String[] dadosPiloto = infoPiloto.split("–");
			
			int idPiloto = Integer.parseInt(dadosPiloto[0].trim());
			String nomePiloto = dadosPiloto[1].trim();
			piloto.setId(idPiloto);
			piloto.setNome(nomePiloto);
			volta.setPiloto(piloto);
				
			int numeroVolta = Integer.parseInt(lstLinha.get(LogCorridaEnum.NUMERO_VOLTA.getPosicao()).trim());
			volta.setNumero(numeroVolta);
			
			try {
				String tempo_volta = lstLinha.get(LogCorridaEnum.TEMPO_VOLTA.getPosicao()).trim();
				Calendar horaFormatada = Calendar.getInstance();
				horaFormatada.setTime(new SimpleDateFormat("mm:ss.SSS").parse(tempo_volta));
				volta.setTempo(horaFormatada);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			float velocidadeMedia = Float.parseFloat(lstLinha.get(LogCorridaEnum.VELOCIDADE_MEDIA_VOLTA.getPosicao()).trim().replace(",", "."));
			volta.setVelocidadeMedia(velocidadeMedia);
			
			voltas.add(volta);
		}
		
		Collections.sort(voltas, new Volta());
		
		return voltas;
	}
	
}
