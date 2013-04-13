package recombinador;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Objects;

/**
 * Representa a linha de um texto.
 */
public class Linha {
	
	private List<Palavra> palavras;
	
	public Linha() {
		this.palavras = new ArrayList<Palavra>();
	}
	
	public void adicionaPalavra(Palavra palavra) {
		palavras.add(palavra);
	}

	public List<Palavra> getPalavras() {
		return palavras;
	}

	public void setPalavras(List<Palavra> palavras) {
		this.palavras = palavras;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Linha)) {
			return false;
		}
		Linha other = (Linha) obj;
		return Objects.equal(other.palavras, this.palavras);
	}
}
