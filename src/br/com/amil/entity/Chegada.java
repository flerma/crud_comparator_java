package br.com.amil.entity;

import java.util.Calendar;
import java.util.Comparator;

public class Chegada {
	
		private int posicaoChegada;
		private Piloto piloto;
		private int qtdeVoltasCompletadas;
		private Calendar tempoTotalProva;
		
		public int getPosicaoChegada() {
			return posicaoChegada;
		}
		public void setPosicaoChegada(int posicaoChegada) {
			this.posicaoChegada = posicaoChegada;
		}
		public Piloto getPiloto() {
			return piloto;
		}
		public void setPiloto(Piloto piloto) {
			this.piloto = piloto;
		}
		public int getQtdeVoltasCompletadas() {
			return qtdeVoltasCompletadas;
		}
		public void setQtdeVoltasCompletadas(int qtdeVoltasCompletadas) {
			this.qtdeVoltasCompletadas = qtdeVoltasCompletadas;
		}
		public Calendar getTempoTotalProva() {
			return tempoTotalProva;
		}
		public void setTempoTotalProva(Calendar tempoTotalProva) {
			this.tempoTotalProva = tempoTotalProva;
		}
		
		public abstract static class OrdenadorSort implements Comparator<Chegada> {
	        public static OrdenadorSort VOLTAS_COMPLETADAS = new OrdenadorSort() {
	            public int compare(Chegada c1, Chegada c2) {
	                return Integer.valueOf(c1.getQtdeVoltasCompletadas())
	                		.compareTo(c2.getQtdeVoltasCompletadas());
	            }
	        };
	        public static OrdenadorSort TEMPO_TOTAL_PROVA = new OrdenadorSort() {
	            public int compare(Chegada c1, Chegada c2) {
	            	Long tempoTotalProva1 = c1.getTempoTotalProva().getTimeInMillis();
	            	Long tempoTotalProva2 = c2.getTempoTotalProva().getTimeInMillis();
	            	return tempoTotalProva1.compareTo(tempoTotalProva2);
	            }
	        };

	        public static OrdenadorSort ordenacaoInvertida(final OrdenadorSort inverso) {
	            return new OrdenadorSort() {
	                public int compare(Chegada c1, Chegada c2) {
	                    return -1 * inverso.compare(c1, c2);
	                }
	            };
	        }

	        public static Comparator<Chegada> combinarOrdenacoes(final OrdenadorSort... multiplosOrdenadores) {
	            return new Comparator<Chegada>() {
	                public int compare(Chegada c1, Chegada c2) {
	                    for (OrdenadorSort chegadaComparator: multiplosOrdenadores) {
	                        int result = chegadaComparator.compare(c1, c2);
	                        if (result != 0) {
	                            return result;
	                        }
	                    }
	                    return 0;
	                }
	            };
	        }
	    }
		
		
		@Override
		public String toString() {
			return "Chegada [qtdeVoltasCompletadas=" + qtdeVoltasCompletadas + ", tempoTotalProva=" + tempoTotalProva
					+ "]";
		}
		
		
}
