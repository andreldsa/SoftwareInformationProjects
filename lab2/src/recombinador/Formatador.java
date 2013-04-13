package recombinador;

import java.util.ArrayList;
import java.util.List;

/**
 * Formatador de texto.
 */
public class Formatador {

	/**
	 * Gera um resumo com as n primeiras palavras do texto.
	 */
	public static String geraResumo(String texto, int numPalavras) {
		int maxIndex = numPalavras;
		String[] palavras = formata(texto);
		if(palavras.length < 12) {
			maxIndex = palavras.length;
		}
		String result = "";
		for(int i = 0; i < maxIndex; i++) {
			result += palavras[i]+ " ";
		}
		return result.substring(0, result.length()-1);
	}
	
	private static String[] formata(String texto) {
		return texto.replaceAll("[\n | \t]", " ").split(" ");
	}
	
	/**
	 * Formata texto quebrando-o em linhas.
	 * @return lista com as linhas do texto
	 */
	public static List<Linha> formataTexto(String texto, int palavrasPorLinha) {
		String[] palavras = formata(texto);
		List<Linha> linhas = new ArrayList<Linha>();
		Linha linha = new Linha();
		int count = 0;
		for(int i = 0; i < palavras.length; i++) {
			if (count == palavrasPorLinha) {
				linha = new Linha();
			}
			linha.adicionaPalavra(new Palavra(palavras[i]));
		}
		return linhas;
	}
}