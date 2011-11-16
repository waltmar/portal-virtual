package br.com.biopids.domain;

public enum TipoImovel {
	
	ProprioQuitado {
		public String toString() {
			return "Próprio quitado";
		}
	},
	ProprioFinanciado{
		public String toString() {
			return "Próprio financiado";
		}
	},
	Alugado {
		public String toString() {
			return "Alugado";
		}
	},
	Familiar {
		public String toString() {
			return "Familiar";
		}
	},
	Cedido {
		public String toString() {
			return "Cedido";
		}
	}
	
}
