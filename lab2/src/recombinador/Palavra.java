package recombinador;

import com.google.common.base.Objects;

/**
 * Representa uma palavra de um texto
 */
public class Palavra {
	
	private String palavra;
	
	public Palavra(String palavra) {
		this.setPalavra(palavra);
	}

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Palavra)) {
			return false;
		}
		Palavra other = (Palavra) obj;
		return Objects.equal(other.palavra, this.palavra);
	}
}