package recombinador;

import java.util.ArrayList;
import java.util.List;

public class Recombinador {
	
	private static Recombinador recombinador;
	private static final int NUM_PALAVRAS_RESUMO = 12;
	private List<Texto> textos;
	
	private Texto textoEmRecombinacao;
	
	private Recombinador() {
		setTextos(new ArrayList<Texto>());
	}
	
	public static Recombinador getInstance() {
		if (recombinador == null) {
			recombinador = new Recombinador();
		}
		return recombinador;
	}

	public void novoTexto(String texto) {
		Texto novoTexto = new Texto(texto, NUM_PALAVRAS_RESUMO);
		getTextos().add(novoTexto);
	}

	public int numTextosCadastrados() {
		return getTextos().size();
	}

	public Texto getUltimoTexto() {
		return getTextos().get(getTextos().size()-1);
	}

	public List<Texto> getTextos() {
		return textos;
	}

	public void setTextos(List<Texto> textos) {
		this.textos = textos;
	}

	public String getLinha(Texto textoSelecionado,
			TipoRecombinacao tipoRecombinacao) {
		textoEmRecombinacao = textoSelecionado.clone();
		List<Linha> linhas = textoEmRecombinacao.getLinhas();
		if (tipoRecombinacao.equals(TipoRecombinacao.ALEATORIA_COM_REPOSICAO)) {
			return getLinhaRecombinacao(linhas, false).toString();
		} else if (tipoRecombinacao.equals(TipoRecombinacao.ALEATORIA_SEM_REPOSICAO)) {
			return getLinhaRecombinacao(linhas, true).toString();
		} else {
			return getLinhaInversa(linhas).toString();
		}
	}
	
	private Linha getLinhaInversa(List<Linha> linhas) {
		Linha linha = linhas.get(linhas.size()-1);
		linhas.remove(linhas.size()-1);
		return linha;
	}

	private Linha getLinhaRecombinacao(List<Linha> lista, boolean semReposicao) {
		int num = Util.sorteia(lista.size()-1);
		Linha linha = lista.get(num);
		if (semReposicao) {
			lista.remove(num);
		}
		return linha;
	}
}
