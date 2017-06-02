package br.com.amil.entity;

public enum LogCorridaEnum {
	
	HORA(0),
	PILOTO(1),
	NUMERO_VOLTA(2),
	TEMPO_VOLTA(3),
	VELOCIDADE_MEDIA_VOLTA(4);
	
	private int posicao;
	
	private LogCorridaEnum(int posicao) {
		this.posicao = posicao;
	}
	
	public int getPosicao() {
		return posicao;
	}

}
