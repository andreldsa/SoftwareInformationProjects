package recombinador;

import java.util.Collections;
import java.util.List;

public enum TipoRecombinacao {
	
	ALEATORIA_SEM_REPOSICAO {
		
		public Linha getLinha(List<Linha> lista) {
			int num = Util.sorteia(lista.size()-1);
			Linha linha = lista.get(num);
			lista.remove(num);
			return linha;
		}
		
		@Override
		public String toString() {
			return "Aleat�ria sem reposi��o";
		}
	},
	ALEATORIA_COM_REPOSICAO {
		
		@Override
		public String toString() {
			return "Aleat�ria com reposi��o";
		}
	},
	INVERSA {
		@Override
		public String toString() {
			return "Inversa";
		}
	};

}
