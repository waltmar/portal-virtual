package br.com.biopids.exception;

import br.com.biopids.language.Marcador;
import br.com.biopids.util.PropertiesLoader;

public enum TypeErrors {
	SEVERITY_INFO {
		public String toString() {
			PropertiesLoader loader = new PropertiesLoader(Marcador.class);
			return (String) loader.getValor("tipoInfo");
		}

	},
	SEVERITY_WARN {
		public String toString() {
			PropertiesLoader loader = new PropertiesLoader(Marcador.class);
			return (String) loader.getValor("tipoWarn");
		}
	}

	,
	SEVERITY_ERROR {
		public String toString() {
			PropertiesLoader loader = new PropertiesLoader(Marcador.class);
			return (String) loader.getValor("tipoError");
		}
	}

	,
	SEVERITY_FATAL {
		public String toString() {
			PropertiesLoader loader = new PropertiesLoader(Marcador.class);
			return (String) loader.getValor("tipoFatal");
		}
	}
}
