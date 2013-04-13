package recombinador;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa um texto.
 */
public class Texto {
	
	private String resumo;
	private List<Linha> linhas;

	public Texto(String texto, int numPalavrasResumo) {
		setLinhas(new ArrayList<Linha>());
		resumo = Formatador.geraResumo(texto, numPalavrasResumo);
		linhas = Formatador.formataTexto(texto,10);
	}
	
	public Texto() {
	}

	public List<Linha> getLinhas() {
		return linhas;
	}

	public void setLinhas(List<Linha> linhas) {
		this.linhas = linhas;
	}

	/**
	 * Resumo do texto em 12 palavras.
	 * @return String resumo
	 */
	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	
	public void removeLinha(Linha linha) {
		linhas.remove(linha);
	}
	
	@Override
	protected Texto clone() {
		Texto novo = new Texto();
		novo.setLinhas(this.linhas);
		novo.setResumo(this.resumo);
		return novo;
	}
}
